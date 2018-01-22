import com.application.v1.daos.MenuDao;
import com.application.v1.library.enumerate.MenuType;
import com.application.v1.orms.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuTest extends SpringTest {

    @Autowired
    private MenuDao menuDao;

//    @Test
    public void menuTest() {
        Menu menu = new Menu();
        menu.setParentId(0L);
        menu.setName("系统管理");
        menu.setType(MenuType.DIRECTORY.getType());
        menu.setIcon("fa fa-cog");
        menu.setOrderNum(0);
        menuDao.save(menu);
    }

}
