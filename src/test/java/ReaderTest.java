import com.application.v1.library.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther ttm
 * @date 2017/12/8
 */
public class ReaderTest {

    @Test
    public void readTest() {
        String remarkStr = "1: 【于 2018-01-13 15:06:09 由 刘婷 -4108(172.16.63.77)操作退款重发而来，原订单条码58692056】<br/>2: 【于2018-01-13 15:06:10由172.16.63.77刘婷 -4108申请退款重发，审核状态:待主管审核】<br/>3: 【于 2018-01-14 22:09:59 由 程丽红-2785(192.168.0.89) 审核同意本订单退款】<br/>4: 【于 2018-01-15 12:04:04 由系统自动退款完成, 退款金额：5592】";
        fetchReturnDate(remarkStr);
    }

    @Test
    public void eq() {
        String defaultProcessDate = "2018-01-01 00:00:00";
        String eqDate = "2017-12-31 12:59:59";
        System.out.println("show : " + eqDate.compareTo(defaultProcessDate));
    }


    private String fetchReturnDate(String remark) {
        String[] returnRemarkList = StringUtils.split(remark, "<br/>");
        String dateStr = "";
        for (String row : returnRemarkList) {
            if (StringUtils.contains(row, "由系统自动退款完成")) {
                String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(row);
                if (m.find()) {
                    dateStr = m.group();
                }
                break;
            }
        }
        return dateStr;
    }

}
