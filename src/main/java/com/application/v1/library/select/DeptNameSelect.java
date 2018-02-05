package com.application.v1.library.select;

import com.application.v1.library.SpringContextUtil;
import com.application.v1.orms.Dept;
import com.application.v1.services.DeptService;
import com.application.v1.services.impl.DeptServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门名称
 */
public class DeptNameSelect {

    private DeptService deptServiceImpl;

    public Map<String, Object> getOption() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:com/application/v1/spring/applicationContent.xml");
        deptServiceImpl = SpringContextUtil.getBean("deptServiceImpl", DeptServiceImpl.class);
        List<Dept> deptList = deptServiceImpl.deptListByAll();
        Map<String, Object> optionMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(deptList)) {
            optionMap.put("", "");
            for (Dept row : deptList) {
                optionMap.put(String.valueOf(row.getDeptId()), row.getName());
            }
        }
        return optionMap;
    }

}
