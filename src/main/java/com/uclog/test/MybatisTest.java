package com.uclog.test;/**
 * Created by wangyu on 2017/8/9.
 */

import com.uclog.model.User;
import com.uclog.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

/**
 * @author yu.wang15
 * @create 2017-08-09 13:47
 **/
public class MybatisTest {

    private UserServiceImpl userService;

         /**
           * 这个before方法在所有的测试方法之前执行，并且只执行一次
           * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
          * 比如在before方法里面初始化ApplicationContext和userService
           */


         @Before
         public void before(){
                 //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
               ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml","mybatis/spring-mybatis.xml"});
                 //从Spring容器中根据bean的id取出我们要使用的userService对象
                 userService = (UserServiceImpl) ac.getBean("userServiceImpl");
         }


         @Test
         public void testAddUser(){
            List<User> allUser = userService.getAllUser();
             for (User user : allUser) {
                 System.out.print(user.getId());
             }
         }







}
