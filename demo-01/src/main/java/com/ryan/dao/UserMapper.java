package com.ryan.dao;

import com.ryan.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    //假设 我们的实体类，或数据库中的表，字段或参数特别多，我们应该考虑使用Map （万能Map）
    User getUserById2(Map<String,Object> map);

}
