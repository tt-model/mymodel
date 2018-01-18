import nu.xom.*;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @auther ttm
 * @date 2017/11/8
 */
//@Ignore
public class XmlTest {

    @Test
    public void xmlParse() {
        Builder builder = new Builder();
        try {
            File file = new File("D:/JTOMTOPERP-NAVIGATOR.xml");
            Document document = builder.build(file);
            parseXml(document);
        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseXml(Document document) {
        Element element = document.getRootElement();
        TreeMap<Integer, ArrayList> navTree = new TreeMap<Integer,  ArrayList>();
        /* frist navigator elments */
        Elements firstNavElements = element.getChildElements();
        for (int i = 0; i < firstNavElements.size(); i++) {
            Element firstNav = firstNavElements.get(i);
            String firstNavName = firstNav.getLocalName().toLowerCase();

            String host = "";

            Integer sortOrder = 100;
            if (StringUtils.isNotEmpty(firstNav.getAttributeValue("sort_order"))) {
                sortOrder = Integer.parseInt(firstNav.getAttributeValue("sort_order"));
            }
            /* second navigator elments */
            Elements secondNavElements = firstNav.getChildElements();
            for (int j = 0; j < secondNavElements.size(); j++) {
                Element secondNav = secondNavElements.get(j);
                String secondNavName = secondNav.getLocalName();
                /* third navigator elements */
                Elements thirdNavElements = secondNav.getChildElements();
                /* third navigator data */
                LinkedHashSet<HashMap> thirdNavData = new LinkedHashSet<HashMap>();
                for (int k = 0; k < thirdNavElements.size(); k++) {
                    Element thirdNav = thirdNavElements.get(k);
                    /* acl */
                    Element aclElement = thirdNav.getFirstChildElement("acl");
                    if (null != aclElement) {
                        Elements aclAllowElements = aclElement.getChildElements();
                        for (int l = 0; l < aclAllowElements.size(); l++) {
                            Element aclAllowElement = aclAllowElements.get(l);
                            String aclLink = aclAllowElement.getAttributeValue("link");
                            String staffLevelName = aclAllowElement.getAttributeValue("staffLevel");
                            if (null != aclAllowElement.getAttributeValue("method")) {

                            }
                            Boolean hasAccess = false;
                        }
                    }
                    /* acl */
                    if (null != aclElement) {
                        HashMap<String, String> aclAllowData = new HashMap<String, String>();
                        Elements aclAllowElements = aclElement.getChildElements();
                        for (int l = 0; l < aclAllowElements.size(); l++) {
                            Element aclAllowElement = aclAllowElements.get(l);
                            String aclLink = aclAllowElement.getAttributeValue("link");
                            aclAllowData.put(aclLink.trim(),
                                    aclAllowElement.getLocalName());
                        }
                    }
                }
            }
        }

    }

}
