package com.application.v1.services.impl;

import com.application.v1.daos.DeptDao;
import com.application.v1.orms.Dept;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.DeptService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean deptSave(Dept dept) {
        deptDao.save(dept);
        return (dept.getDeptId() != null);
    }

    @Override
    public List<Dept> deptListByAll() {
        return deptDao.findAll();
    }

    @Override
    public List<Dept> deptList(int pageNumber, int pageSize) {
        Page<Dept> page = deptDao.findAll(new PageRequest(pageNumber - 1, pageSize));
        return page.getContent();
    }

    @Override
    public int deptCount() {
        return Long.valueOf(deptDao.count()).intValue();
    }

    @Override
    public List<Dept> getCollection(Map<String, Object> query) {
        if (MapUtils.isNotEmpty(query)) {
            SpecificationOperator operator = new SpecificationOperator();
            for (String keyRow : query.keySet()) {
                String[] valueRow = (String[]) query.get(keyRow);
                operator.put(keyRow, Long.valueOf(valueRow[0]));
            }
            return deptDao.getCollection(operator);
        } else {
            return deptDao.getCollection(null);
        }
    }


}
