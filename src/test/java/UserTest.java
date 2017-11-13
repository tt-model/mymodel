import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/application/v1/spring/applicationContent.xml", "classpath*:com/application/v1/spring/dispatcher-servlet.xml", "classpath*:com/application/v1/spring/hibernate.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void userTest() {
        List<User> usersList = userService.userList();
        System.out.println("ttm | " + usersList.toString());
    }

}
