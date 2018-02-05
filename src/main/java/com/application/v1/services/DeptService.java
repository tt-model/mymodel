package com.application.v1.services;

import com.application.v1.orms.Dept;
import com.application.v1.services.impl.BaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DeptService extends BaseService {

    public boolean deptSave(Dept dept);

    public List<Dept> deptListByAll();

    public List<Dept> deptList(int pageNumber, int pageSize);

    public int deptCount();

}
