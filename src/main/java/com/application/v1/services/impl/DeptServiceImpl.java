package com.application.v1.services.impl;

import com.application.v1.daos.DeptDao;
import com.application.v1.orms.Dept;
import com.application.v1.repositorys.BaseRepository;
import com.application.v1.repositorys.SpecificationOperator;
import com.application.v1.services.DeptService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, Long> implements DeptService {

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
    public List getCollection(HttpServletRequest request) {
        return super.getCollection(deptDao, request);
    }

    @Override
    public Long getCollectionCount(HttpServletRequest request) {
        return super.getCollectionCount(deptDao, request);
    }

}
