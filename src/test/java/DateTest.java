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
        LocalDate start = LocalDate.of(2017, 1, 1);
        LocalDate end = LocalDate.of(2017, 11, 6);
        System.out.println("ttm | " + (end.toEpochDay() - start.toEpochDay()));
    }

}
