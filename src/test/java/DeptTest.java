import com.application.v1.daos.DeptDao;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.DeptService;
import com.sun.javafx.collections.MappingChange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeptTest extends SpringTest {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DeptDao deptDao;


    @Test
    public void deptSaveTest() {
//        Dept dept = new Dept();
//        dept.setName("商品部");
//        dept.setOrderNum(3);
//        dept.setParentId(1L);
//        boolean saveFalg = deptService.deptSave(dept);
//        System.out.println("show result : " + saveFalg);
        String[] a = new String[1];
        a[0] = "3";
        SpecificationOperator query = new SpecificationOperator();
        query.put("parentId", a);
        deptService.getCollection(query);
    }

}
