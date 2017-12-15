package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ITestServiceTest {
    @Autowired
    ITestService iTestService;
    @Test
    public void modify() throws Exception {
        iTestService.modify(4,300);
    }

}