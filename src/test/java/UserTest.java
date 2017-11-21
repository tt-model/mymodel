import com.application.v1.library.AesEncodeUtil;
import com.application.v1.library.DateUtil;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Ignore
public class UserTest extends SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void userTest() throws Exception {
        User user = new User();
        user.setName("admin");
        user.setPassword(AesEncodeUtil.encryption("tangtaiming123"));
        String currentTime = DateUtil.fetchCurrentTime();
        user.setCreateTime(currentTime);
        user.setUpdateTime(currentTime);
        userService.userSave(user);
        System.out.println("ttm | " + user);
    }

}
