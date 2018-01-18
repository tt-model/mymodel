package com.application.v1.repositorys;

import com.application.v1.orms.User;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/4
 */
public interface UserRepository {

    public boolean userUpdate(User user);

    public List<User> userList(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> paging);

    public List<User> userList(Map<String, Object> query, Map<String, Object> sort);

    public List<User> userList(Map<String, Object> query);

    public User userOne(Map<String, Object> query);

}
