package com.application.v1.repositorys;

import com.application.v1.orms.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @auther ttm
 * @date 2017/11/4
 */
public interface CustomizedUserRepository {

    public boolean userUpdate(User user);

}
