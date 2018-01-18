import com.application.v1.library.AesEncodeUtil;
import com.application.v1.library.DateUtil;
import com.application.v1.library.JsonUtil;
import com.application.v1.orms.User;
import com.application.v1.services.UserService;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * @auther ttm
 * @date 2017/10/31
 */
@Ignore
public class UserTest extends SpringTest {

    private final static Logger LOG = Logger.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    public void userTest() throws Exception {
        for (int x = 1; x < 1000; x++) {
            User user = new User();
            user.setName("test" + x);
            user.setPassword(AesEncodeUtil.encryption("tangtaiming123"));
            String currentTime = DateUtil.fetchCurrentTime();
            user.setCreateTime(currentTime);
            user.setUpdateTime(currentTime);
//            userService.userSave(user);
            System.out.println("ttm | " + user);
        }

    }

    @Test
    public void updateTest() {
        User user = userService.userFind(1);
        LOG.info(JsonUtil.toJson(user));
    }

}
