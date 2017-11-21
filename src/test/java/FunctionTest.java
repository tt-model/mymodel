import com.application.v1.library.DateUtil;
import com.application.v1.orms.Function;
import com.application.v1.services.FunctionService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther ttm
 * @date 2017/11/21
 */
@Ignore
public class FunctionTest extends SpringTest {

    @Autowired
    private FunctionService functionService;

    @Test
    public void saveTest() {
        Function function = new Function();
        function.setName("权限");
        function.setParentId(0);
        function.setUrl("/product");
        String currentTime = DateUtil.fetchCurrentTime();
        function.setCreateTime(currentTime);
        function.setUpdateTime(currentTime);
        functionService.functionSave(function);
    }

}
