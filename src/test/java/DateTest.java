import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @auther ttm
 * @date 2017/11/6
 */
public class DateTest {

    @Test
    public void dateTest() {
        String transacationId = "171117111205156014350-1-R";
        String updateTransactionId = DateTest.getUpdateTransactionId(transacationId);
        System.out.println("ttm | " + updateTransactionId);
    }

    public static String getUpdateTransactionId(String updateTranscationId) {
        //8K163619KR866722K-1-R1   19
        Integer index = StringUtils.lastIndexOf(updateTranscationId, "-");
        return StringUtils.substring(updateTranscationId, 0, index);
    }

}
