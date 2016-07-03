import com.svichkar.service.TestCaseService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Created by konstantin on 6/7/2016.
 */
@RunWith(JUnit4.class)
@ComponentScan
public class TestClass {

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {

        sessionFactory.getCurrentSession();
        testCaseService.findAll();
        System.out.println("good");
    }
}
