package com.ryan.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory
public class MybatisUtil {

    private  static  SqlSessionFactory sqlSessionFactory;
    static{
        //使用mybatis第一步 获取sqlSessionFactory对象
        try { String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"test");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"development");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  // SqlSession 完全包含了对面向数据库执行sql所需的方法
    public static SqlSession getSqlSession(){
      return  sqlSessionFactory.openSession();
  }
}
