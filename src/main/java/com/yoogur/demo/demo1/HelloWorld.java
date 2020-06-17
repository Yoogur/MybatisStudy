package com.yoogur.demo.demo1;

import com.yoogur.commons.dao.UserMapper;
import com.yoogur.commons.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class HelloWorld {
  public static void main(String[] args) throws IOException {
    String mbResource = "mybatis-conf.xml";
    InputStream is = Resources.getResourceAsStream(mbResource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
//      String username = sqlSession.selectOne("com.yoogur.commons.dao.UserMapper.getUserById",1);
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      User user = userMapper.getUserById(1);
      System.out.println(user);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
