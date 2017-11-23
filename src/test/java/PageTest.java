import com.application.v1.library.Page;
import org.junit.Test;

/**
 * @author ttm
 * @data 2017/11/23
 */
public class PageTest {

    @Test
    public void pageTest() {
        Page page = new Page(200, 6, 20);
        System.out.println("ttm | " + page.toString());
    }

}
