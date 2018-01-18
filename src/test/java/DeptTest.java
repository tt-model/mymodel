import com.application.v1.orms.Dept;
import com.application.v1.services.DeptService;
import com.tomtop.system.libraries.util.Dumper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeptTest extends SpringTest {

    @Autowired
    private DeptService deptService;

//    @Test
    public void deptSaveTest() {
        Dept dept = new Dept();
        dept.setName("销售部");
        dept.setOrderNum(3);
        dept.setParentId(1L);
        boolean saveFalg = deptService.deptSave(dept);
        System.out.println("show result : " + saveFalg);
    }

    @Test
    public void deptListAllTest() {
        Dumper.dump(deptService.deptListByAll());
    }

}
