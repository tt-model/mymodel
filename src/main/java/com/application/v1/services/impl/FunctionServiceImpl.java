package com.application.v1.services.impl;

import com.application.v1.daos.FunctionDao;
import com.application.v1.orms.Function;
import com.application.v1.services.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther ttm
 * @date 2017/11/21
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionDao functionDao;

    @Override
    public boolean functionSave(Function function) {
        Function saveFlag = functionDao.save(function);
        return saveFlag.getId() > 0 ? true : false;
    }

}
