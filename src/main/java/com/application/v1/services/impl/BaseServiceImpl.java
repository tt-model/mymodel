package com.application.v1.services.impl;

import com.application.v1.core.session.FilterSession;
import com.application.v1.core.session.MapSession;
import com.application.v1.core.session.PageSession;
import com.application.v1.library.RequestServletUtil;
import com.application.v1.repositorys.BaseRepository;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.BaseService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/29
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService {

    private SpecificationOperator operator;

    @Override
    public void execute(HttpServletRequest request) {
        //获取过滤条件
        operator = generateSpecification(request);
        siteFilterSession(operator);
        //分页条件
        sitePageSession(operator);
    }

    /**
     * 获取数据集合
     * @param request
     * @return
     */
    public abstract List<T> getCollection(HttpServletRequest request);

    /**
     * 获取数据集合数量
     * @param request
     * @return
     */
    public abstract Long getCollectionCount(HttpServletRequest request);

    @Override
    public List getCollection(BaseRepository baseRepository, HttpServletRequest request) {
        return baseRepository.getCollection(operator);
    }

    @Override
    public Long getCollectionCount(BaseRepository baseRepository, HttpServletRequest request) {
        return baseRepository.getCollectionCount(operator);
    }

    /**
     * 设置分页条件
     * @param operator
     */
    private void sitePageSession(SpecificationOperator operator) {
        PageSession pageSession = new PageSession();

    }

    /**
     * 设置过滤条件
     * @param operator
     */
    private void siteFilterSession(SpecificationOperator operator) {
        //设置过滤条件
        MapSession mapSession = new MapSession();
        for (Object key : operator.keySet()) {
            Object value = operator.get(key);
            if (value instanceof Long) {
                mapSession.put(key + "[Long]", value.toString());
            } else if (value instanceof Integer) {
                mapSession.put(key + "[Integer]", value.toString());
            } else if (value instanceof Double) {
                mapSession.put(key + "[Double]", value.toString());
            } else {
                mapSession.put(key + "[String]", value.toString());
            }
        }
        HttpSession session = RequestServletUtil.fetchSession();
        session.removeAttribute(FilterSession.FILTER);
        if (MapUtils.isNotEmpty(mapSession)) {
//            FilterSession filterSession = new FilterSession();
            //去除session没有作为条件查询的值
            RequestServletUtil.fetchSession().setAttribute(FilterSession.FILTER, mapSession);
        }
    }

    /**
     * 生成查询条件
     * @param request
     * @return
     */
    private SpecificationOperator generateSpecification(HttpServletRequest request) {
        SpecificationOperator operator = new SpecificationOperator();
        Map<String, Object> paramsMap = request.getParameterMap();
        for (String keyRow : paramsMap.keySet()) {
            String[] valueRow = (String[]) paramsMap.get(keyRow);
            splitQuery(keyRow, valueRow, operator);
        }
        return operator;
    }

    public static void main(String[] args) {
        SpecificationOperator operator = new SpecificationOperator();
        DeptServiceImpl deptService = new DeptServiceImpl();
        deptService.splitQuery("parentId", new String[]{"1"}, operator);
    }

    /**
     * 获取类型
     * @param text
     * @return
     */
    public void splitQuery(String text, String[] value, SpecificationOperator operator) {
        List<String> initList = new ArrayList<>();
        initList.add("[Long]");
        initList.add("[Integer]");
        initList.add("[Double]");
        initList.add("[String]");
        String queryType = "String";
        String queryName = "";
        if (StringUtils.endsWith(text, "]")) {
            for (String type : initList) {
                if (StringUtils.isNotEmpty(text) && StringUtils.endsWith(text, type)) {
                    queryName = StringUtils.removeEnd(text, type);
                    queryType = StringUtils.substring(text, (queryName.length() + 1), text.length() - 1);
                    break;
                }
            }
        } else {
            queryName = text;
        }
        if (queryType.equals("Long")) {
            operator.put(queryName, Long.valueOf(value[0]));
        } else if (queryType.equals("Integer")) {
            operator.put(queryName, Integer.valueOf(value[0]));
        } else if (queryType.equals("Double")) {
            operator.put(queryName, Double.valueOf(value[0]));
        } else {
            operator.put(queryName, value[0]);
        }
    }

}
