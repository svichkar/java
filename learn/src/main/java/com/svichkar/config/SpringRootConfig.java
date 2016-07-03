package com.svichkar.config;

import com.svichkar.model.Priority;
import com.svichkar.model.TestCase;
import com.svichkar.model.Tester;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by konstantin on 6/29/2016.
 */
@Configuration
@EnableTransactionManagement
public class SpringRootConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/testsDB");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Autowired
    @Bean(name = {"sessionFactory"})
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("com.svichkar.model");
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager txName() throws IOException {
        HibernateTransactionManager txName = new HibernateTransactionManager();
        txName.setSessionFactory(getSessionFactory(getDataSource()));
        txName.setDataSource(getDataSource());
        return txName;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.connection.autocommit", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
}
