package com.application.v1.services;

import com.application.v1.orms.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    public boolean deptSave(Dept dept);

    public List<Dept> deptListByAll();

    public List<Dept> deptList(int pageNumber, int pageSize);

    public int deptCount();

    public List<Dept> getCollection(Map<String, Object> query);
}
