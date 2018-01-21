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
//@Ignore
public class RoleTest extends SpringTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void saveTest() {
        Role role = new Role();
        role.setRoleName("总监");
        role.setRemark("公司总监");
        role.setDeptId(1L);
        role.setCreateTime(DateUtil.fetchCurrentTime());
        roleService.roleSave(role);
    }

}
