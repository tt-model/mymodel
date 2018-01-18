import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther ttm
 * @date 2017/11/21
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/application/v1/spring/applicationContent.xml", "classpath*:com/application/v1/spring/dispatcher-servlet.xml", "classpath*:com/application/v1/spring/hibernate.xml"})
public class SpringTest {
}
