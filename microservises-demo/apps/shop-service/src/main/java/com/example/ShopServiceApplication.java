package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ShopServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/")
class DeviceController {

    @Autowired
    private RestTemplate template;

    @RequestMapping("/devices")
    public List<Device> devices() {
        ParameterizedTypeReference<Resources<Device>> deviceType =
                new ParameterizedTypeReference<Resources<Device>>() {};
        Collection<Device> devices = template
                .exchange("http://device-service/devices", HttpMethod.GET, null,
                        deviceType).getBody().getContent();

        ParameterizedTypeReference<Map<String, Double>> priceType =
                new ParameterizedTypeReference<Map<String, Double>>() {};
        Map<String, Double> rates = template
                .exchange("http://price-service", HttpMethod.GET, null,
                        priceType).getBody();

        return devices.stream().map(it -> {
            it.setPrice(rates.get(it.getName()));
            return it;
        }).collect(Collectors.toList());
    }
}

@Data
@NoArgsConstructor
class Device {
    private String name;
    private Double price;
}
