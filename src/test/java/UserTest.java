import com.application.v1.library.DateUtil;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import com.application.v1.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther ttm
 * @date 2017/10/31
 */
public class UserTest extends SpringTest {

    @Autowired
    private UserService userService;

//    @Test
    public void userTest() {
//        User user = new User();
//        user.setUserName("admin");
//        user.setDeptId(1L);
//        String salt = RandomStringUtils.randomAlphanumeric(20);
//        user.setSalt(salt);
//        String password = ShiroUtils.sha256("admin", salt);
//        user.setPassword(password);
//        user.setEmail("1252575758@qq.com");
//        user.setMobile("15211636823");
//        user.setStatus(1);
//        user.setCreateTime(DateUtil.fetchCurrentTime());
//        Dumper.dump(user);
//        userService.userSave(user);
        genUser();
    }

    private void genUser() {
        for (int x = 1; x < 1000; x++) {
            User user = new User();
            user.setUserName("tangtaiming-" + x);
            user.setDeptId(1L);
            String salt = RandomStringUtils.randomAlphanumeric(20);
            user.setSalt(salt);
            String password = ShiroUtils.sha256("tangtaiming", salt);
            user.setPassword(password);
            user.setEmail("1252575758@qq.com");
            user.setMobile("15211636823");
            user.setStatus(1);
            user.setCreateTime(DateUtil.fetchCurrentTime());
            userService.userSave(user);
        }
    }

}
