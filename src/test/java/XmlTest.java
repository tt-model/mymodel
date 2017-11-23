import com.application.v1.BaseParseXml;
import org.dom4j.DocumentException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * @auther ttm
 * @date 2017/11/8
 */
//@Ignore
public class XmlTest {

    @Test
    public void xmlParse() {
        BaseParseXml parseXml = new BaseParseXml();
        parseXml.parseMainXml("userManager");
    }

}
