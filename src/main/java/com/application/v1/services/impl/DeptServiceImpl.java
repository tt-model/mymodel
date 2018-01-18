package com.application.v1.services.impl;

import com.application.v1.daos.DeptDao;
import com.application.v1.orms.Dept;
import com.application.v1.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
