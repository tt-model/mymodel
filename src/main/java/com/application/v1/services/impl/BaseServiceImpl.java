package com.application.v1.services.impl;

import com.application.v1.core.session.FilterSession;
import com.application.v1.core.session.MapSession;
import com.application.v1.core.session.PageSession;
import com.application.v1.library.PageUtil;
import com.application.v1.library.RequestServletUtil;
import com.application.v1.repositorys.BaseRepository;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.BaseService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.core.IsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

/**
 * @auther ttm
 * @date 2017/11/29
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService {

    private SpecificationOperator operator;

    private PageRequest page;

    private static final String PAGE_NUMBER = "pageNumber";

    private static final String PAGE_SIZE = "pageSize";

    private static final String DATETIME_FORM = "[form]";

    private static final String DATETIME_TO = "[to]";

    private static final String GTE = "$gte";

    private static final String LTE = "$lte";

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求url
     */
    private String requestUrl;

    @Override
    public void execute(HttpServletRequest request) {
        //请求方式获取
        method = request.getMethod();
        //url
        requestUrl = request.getRequestURI();
        //获取过滤条件
        operator = generateSpecification(request);
        siteFilterSession(operator);
        //分页条件
        page = generatePage(request);
        sitePageSession(page);
    }

    @Override
    public PageRequest fetchPage() {
        return page;
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
        return baseRepository.getCollection(operator, page);
    }

    @Override
    public Long getCollectionCount(BaseRepository baseRepository, HttpServletRequest request) {
        return baseRepository.getCollectionCount(operator);
    }

    /**
     * 设置分页Session
     * @param request
     */
    private void sitePageSession(PageRequest request) {
        PageSession pageSession = new PageSession();
        pageSession.setPageRequest(request);
        if (null != request) {
            RequestServletUtil.fetchSession().setAttribute(PageSession.PAGE + "/" + requestUrl, pageSession);
        }
    }

    /**
     * 设置过滤条件
     * @param operator
     */
    private void siteFilterSession(SpecificationOperator operator) {
        //设置过滤条件
        MapSession mapSession = new MapSession();
        List<String> filterName = new ArrayList<>();
        for (Object key : operator.keySet()) {
            Object value = operator.get(key);
            if (value instanceof Long) {
                mapSession.put(key + "[Long]", value.toString());
                filterName.add(key + "[Long]");
            } else if (value instanceof Integer) {
                mapSession.put(key + "[Integer]", value.toString());
                filterName.add(key + "[Integer]");
            } else if (value instanceof Double) {
                mapSession.put(key + "[Double]", value.toString());
                filterName.add(key + "[Double]");
            } else {
                mapSession.put(key + "[String]", value.toString());
                filterName.add(key + "[String]");
            }
        }
        if (MapUtils.isNotEmpty(mapSession)) {
            //去除session没有作为条件查询的值
            RequestServletUtil.fetchSession().setAttribute(FilterSession.FILTER + "/" + requestUrl, mapSession);
        }
    }

    /**
     * 验证是否是分页参数
     * @param pageable
     * @return
     */
    private boolean validatePageParams(String pageable) {
        if (PAGE_NUMBER.equals(pageable)) {
            return false;
        } else if (PAGE_SIZE.equals(pageable)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 生成查询条件
     * @param request
     * @return
     */
    private SpecificationOperator generateSpecification(HttpServletRequest request) {
        SpecificationOperator operator = new SpecificationOperator();
        Map<String, Object> paramsMap = new LinkedHashMap<>(request.getParameterMap());
        HttpSession session = RequestServletUtil.fetchSession();
        MapSession mapSession = (MapSession) session.getAttribute(FilterSession.FILTER + "/" + requestUrl);
        //默认进入获取Session中的查询条件数据
        if (null != mapSession && method.equals("GET")) {
            for (Object key : mapSession.keySet()) {
                String value = mapSession.get(key).toString();
                List<String> newValues = new ArrayList<>();
                newValues.add(value);
                paramsMap.put(key.toString(), newValues.toArray(new String[newValues.size()]));
            }
        }
        //获取当前的查询条件
        if(method.equals("POST")) {
            //清除指定查询条件Session
            session.removeAttribute(FilterSession.FILTER + "/" + requestUrl);
        }
        for (String keyRow : paramsMap.keySet()) {
            if (validatePageParams(keyRow)) {
                String[] valueRow = (String[]) paramsMap.get(keyRow);
                splitQuery(keyRow, valueRow, operator);
            }
        }
        return operator;
    }

    /**
     * 生成分页参数
     * @param request
     * @return
     */
    public PageRequest generatePage(HttpServletRequest request) {
        String pageNumber = request.getParameter(PAGE_NUMBER);
        String pageSize = request.getParameter(PAGE_SIZE);
        Integer pageNumberByCurrent = fetchDefaultPageNumber(pageNumber);
        Integer pageSizeByCurrent = fetchDefaultPageSize(pageSize);
        HttpSession session = RequestServletUtil.fetchSession();
        PageSession pageSession = (PageSession) session.getAttribute(PageSession.PAGE + "/" + requestUrl);
        if (null != pageSession && method.equals("GET")) {
            PageRequest pageRequestBySession = pageSession.getPageRequest();
            pageNumberByCurrent = pageRequestBySession.getPageNumber();
            pageSizeByCurrent = pageRequestBySession.getPageSize();
        }
        PageRequest pageRequest = new PageRequest(pageNumberByCurrent, pageSizeByCurrent);
        return pageRequest;
    }

    /**
     *
     * @param pageSize
     * @return
     */
    private Integer fetchDefaultPageSize(String pageSize) {
        return StringUtils.isEmpty(pageSize) ? 10 : Integer.valueOf(pageSize);
    }

    /**
     * 获取当前页
     * @param pageNumber
     * @return
     */
    private Integer fetchDefaultPageNumber(String pageNumber) {
        return StringUtils.isEmpty(pageNumber) ? 0 : Integer.valueOf(pageNumber) - 1;
    }

    public static void main(String[] args) {
        SpecificationOperator operator = new SpecificationOperator();
        DeptServiceImpl deptService = new DeptServiceImpl();
        deptService.splitQuery("createDate[String][form]", new String[]{"2016"}, operator);
        deptService.splitQuery("createDate[String][to]", new String[]{"2018"}, operator);
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
        //时间格式处理
        if (validateDatetime(text)) {
            startDateForm(text, initList, value[0], operator);
        } else {
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

    private void startDateForm(String dateText, List<String> init, String value, SpecificationOperator operator) {
        String queryName = "";
        String queryType = "String";
        if (StringUtils.endsWith(dateText, DATETIME_FORM)) {
            String dateForm = StringUtils.removeEnd(dateText, DATETIME_FORM);
            for (String type : init) {
                if (StringUtils.isNotEmpty(dateForm) && StringUtils.endsWith(dateForm, type)) {
                    queryName = StringUtils.removeEnd(dateForm, type);
                    queryType = StringUtils.substring(dateForm, (queryName.length() + 1), dateForm.length() - 1);
                    break;
                }
            }
            SpecificationOperator formOperator = (SpecificationOperator) operator.get(queryName);
            if (null == formOperator) {
                formOperator = new SpecificationOperator();
            }
            if (queryType.equals("Long")) {
                formOperator.put(GTE, Long.valueOf(value));
            } else if (queryType.equals("Integer")) {
                formOperator.put(GTE, Integer.valueOf(value));
            } else if (queryType.equals("Double")) {
                formOperator.put(GTE, Double.valueOf(value));
            } else {
                formOperator.put(GTE, value);
            }
            operator.put(queryName, formOperator);
        }
        if (StringUtils.endsWith(dateText, DATETIME_TO)) {
            String dateTo = StringUtils.removeEnd(dateText, DATETIME_TO);
            for (String type : init) {
                if (StringUtils.isNotEmpty(dateTo) && StringUtils.endsWith(dateTo, type)) {
                    queryName = StringUtils.removeEnd(dateTo, type);
                    queryType = StringUtils.substring(dateTo, (queryName.length() + 1), dateTo.length() - 1);
                    break;
                }
            }
            SpecificationOperator toOperator = (SpecificationOperator) operator.get(queryName);
            if (null == toOperator) {
                toOperator = new SpecificationOperator();
            }
            if (queryType.equals("Long")) {
                toOperator.put(LTE, Long.valueOf(value));
            } else if (queryType.equals("Integer")) {
                toOperator.put(LTE, Integer.valueOf(value));
            } else if (queryType.equals("Double")) {
                toOperator.put(LTE, Double.valueOf(value));
            } else {
                toOperator.put(LTE, value);
            }
            operator.put(queryName, toOperator);
        }

    }

    /**
     * 验证是否是时间格式
     * @param dateText
     * @return
     */
    private boolean validateDatetime(String dateText) {
        return StringUtils.endsWith(dateText, DATETIME_FORM) || StringUtils.endsWith(dateText, DATETIME_TO);
    }

    public SpecificationOperator getOperator() {
        return operator;
    }

    public void setOperator(SpecificationOperator operator) {
        this.operator = operator;
    }

    public PageRequest getPage() {
        return page;
    }

    public void setPage(PageRequest page) {
        this.page = page;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
