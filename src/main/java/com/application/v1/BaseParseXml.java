package com.application.v1;

import com.application.v1.library.CustomSelectAnalyze;
import com.application.v1.library.JsonUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
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
            String managerUrl = header.attributeValue("url");
            if (StringUtils.isEmpty(managerUrl)) {
                throw new NullPointerException("manager url is null，request!");
            }
            List<Element> headerColumnList = header.elements("column");
            for (Element element : headerColumnList) {
                String name = element.attributeValue("name");
                String title = element.attributeValue("title");
                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("name", name);
                columnMap.put("title", title);
                parseXmlList.add(columnMap);
            }
            xmlMap.put("managerUrl", managerUrl);
            xmlMap.put("headerTitle", parseXmlList);
            //widths
            Element widths = root.element("widths");
            List<String> parseWidthList = new ArrayList<>();
            List<Element> widthColumnList = widths.elements("width");
            for (Element element : widthColumnList) {
                String width = element.attributeValue("value");
                parseWidthList.add(width);
            }
            xmlMap.put("widthTitle", parseWidthList);
            //bread 功能名称
            Element bread = root.element("bread-title");
            String breadTitle = bread.attributeValue("title");
            String breadUrl = bread.attributeValue("url");
            Map<String, Object> parseBreadTitle = new HashMap<>();
            parseBreadTitle.put("breadTitle", breadTitle);
            parseBreadTitle.put("breadUrl", breadUrl);
            xmlMap.put("breadTitle", parseBreadTitle);
            //新增按钮
            Element addButton = root.element("add-button");
            String buttonName = addButton.attributeValue("title");
            String buttonUrl = addButton.attributeValue("url");
            Map<String, Object> parseAddButton = new HashMap<>();
            parseAddButton.put("buttonName", buttonName);
            parseAddButton.put("buttonUrl", buttonUrl);
            xmlMap.put("addButton", parseAddButton);
            //搜索
            Element search = root.element("search");
            List<Map<String, Object>> searchList = new ArrayList<>();
            List<Element> searchColumnList = search.elements();
            for (Element element : searchColumnList) {
                String searchTypeValue = element.attributeValue("type");
                String searchNameValue = element.attributeValue("name");
                List<String> defaultType = defaultType();
                Map<String, Object> newSearchMap = new HashMap<>();
                if (StringUtils.isEmpty(searchTypeValue)) {
                    newSearchMap.put("type", "");
                    newSearchMap.put("name", "");
                } else if (defaultType.contains(searchTypeValue)) {
                    newSearchMap.put("type", searchTypeValue);
                    newSearchMap.put("name", searchNameValue);
                } else {
                    CustomSelectAnalyze analyze = new CustomSelectAnalyze();
                    Map<String, Object> option = analyze.parseSelect(searchTypeValue);
                    newSearchMap.put("type", "select");
                    newSearchMap.put("name", searchNameValue);
                    newSearchMap.put("option", option);
                }
                searchList.add(newSearchMap);
            }
            xmlMap.put("search", searchList);
            System.out.println("ttm | " + JsonUtil.toJson(xmlMap));
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

    private List<String> defaultType() {
        List<String> defaultList = new ArrayList<>();
        defaultList.add("text");
        defaultList.add("datetime");
        return defaultList;
    }

}
