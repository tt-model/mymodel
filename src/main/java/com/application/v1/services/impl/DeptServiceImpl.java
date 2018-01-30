package com.application.v1.services.impl;

import com.application.v1.daos.DeptDao;
import com.application.v1.orms.Dept;
import com.application.v1.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
