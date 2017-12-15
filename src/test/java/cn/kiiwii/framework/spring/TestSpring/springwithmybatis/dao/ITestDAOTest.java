package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ITestDAOTest {
    @Autowired
    ITestDAO iTestDAO;
    @Test
    public void addMoney() throws Exception {
    }

    @Test
    public void minusMoney() throws Exception {
    }

    @Test
    public void insertAccount() throws Exception {
    }

    @Test
    public void getAccountById() throws Exception {
    }

    @Test
    public void findAccountsById() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAccountsByName() throws Exception {
    }

    @Test
    public void modify() throws Exception {
        iTestDAO.updateMoney(4,500);
    }

}