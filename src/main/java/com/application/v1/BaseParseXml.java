package com.application.v1;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析 管理页面
 * @auther ttm
 * @date 2017/11/8
 */
public class BaseParseXml {

    private Logger logger = Logger.getLogger(BaseParseXml.class);

    private Map<String, Object> xmlMap;

    /**
     * 列表页面 xml存放路径
     */
    private static final String MAIN_XML_PATH = "com/application/v1/main/";

    public void parseMainXml(String name) {
        String path = MAIN_XML_PATH + name + ".xml";
        try {
            parseXml(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析 xml
     * @param path
     */
    public void parseXml(String path) throws IOException, DocumentException {
        xmlMap = new HashMap<>();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + path);
        SAXReader reader = new SAXReader();
        File xmlFile = resource.getFile();
        if (xmlFile != null && xmlFile.exists()) {
            //headerTitle
            List<Map<String, Object>> parseXmlList = new ArrayList<>();
            Document document = reader.read(xmlFile);
            Element root = document.getRootElement();
            logger.info("root " + root.getName());
            Element header = root.element("headers");
            List<Element> headerColumnList = header.elements("column");
            for (Element element : headerColumnList) {
                String name = element.attributeValue("name");
                String title = element.attributeValue("title");
                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("name", name);
                columnMap.put("title", title);
                parseXmlList.add(columnMap);
            }
            xmlMap.put("headerTitle", parseXmlList);
            //widths
            List<String> parseWidthList = new ArrayList<>();
            Element widths = root.element("widths");
            List<Element> widthColumnList = widths.elements("width");
            for (Element element : widthColumnList) {
                String width = element.attributeValue("value");
                parseWidthList.add(width);
            }
            xmlMap.put("widthTitle", parseWidthList);
            System.out.println("ttm | " + xmlMap.toString());
        } else {
            logger.warn(path + " file is null");
        }
    }

    public Map<String, Object> getXmlMap() {
        return xmlMap;
    }

    public void setXmlMap(Map<String, Object> xmlMap) {
        this.xmlMap = xmlMap;
    }
}
