import com.application.v1.library.Page;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author ttm
 * @data 2017/11/23
 */
@Ignore
public class PageTest {

    @Test
    public void pageTest() {
        Page page = new Page(200, 6, 20);
        System.out.println("ttm | " + page.toString());
    }

}
