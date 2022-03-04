package com.ryan.dao;

import com.ryan.pojo.User;
import com.ryan.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 笔记本上的mysql5.7 创建的mybatis数据库 user表
 * 97bbdc5a28a3   mysql:5.7                          "docker-entrypoint.s…"   9 months ago     Up 7 minutes                 0.0.0.0:3306->3306/tcp, 33060/tcp
 */
public class UserDaoTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        try{
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            sqlSession.close();
        }

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id",2);
        User user = mapper.getUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }
}
