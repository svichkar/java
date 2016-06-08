import com.svichkar.config.ApplicationContextConfig;
import com.svichkar.dao.TestCaseDao;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by konstantin on 6/7/2016.
 */
@RunWith(JUnit4.class)
public class TestClass {

    @Autowired
    ApplicationContextConfig config;

    @Test
    public void test() {
        System.out.println("good");
    }
}
