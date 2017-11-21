import com.application.v1.library.DateUtil;
import com.application.v1.orms.Role;
import com.application.v1.services.RoleService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther ttm
 * @date 2017/11/21
 */
@Ignore
public class RoleTest extends SpringTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void saveTest() {
        Role role = new Role();
        role.setName("总监");
        role.setParentId(0);
        role.setStatus(1);         //默认关闭
        String currentTile = DateUtil.fetchCurrentTime();
        role.setCreateTime(currentTile);
        role.setUpdateTime(currentTile);
        roleService.roleSave(role);
    }

}
