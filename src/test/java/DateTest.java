import com.application.v1.library.DateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @auther ttm
 * @date 2017/11/6
 */
@Ignore
public class DateTest {

    @Test
    public void dateTest() {
        System.out.println("ttm | " + DateUtil.fetchCurrentTime());
    }

}
