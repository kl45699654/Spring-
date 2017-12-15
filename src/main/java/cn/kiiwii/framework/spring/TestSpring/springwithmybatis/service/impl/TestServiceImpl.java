package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service.impl;

import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.dao.ITestDAO;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.Account;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements ITestService {

	Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Resource
	private ITestDAO testDAO;
	public void test() {
	}

	public boolean transfer(float money, int from, int to) throws Exception {
		
		this.testDAO.minusMoney(from, money);
		//int i = 1/0;
		this.testDAO.addMoney(to, money);
		return true;
	}
	
	public int insertAccount(Account account){
		return this.testDAO.insertAccount(account);
	}

	public Account findAccountById(int i) {
		
		return this.testDAO.getAccountById(i);
	}

	public List<Account> findAccountsById(int i) {
		List<Account> accounts = this.testDAO.findAccountsById(i);
		return this.testDAO.findAccountsById(i);
	}

	public void insert(String name,Integer money) {
		this.testDAO.insert(name, money);
	}

	public void delete(Integer id){
		this.testDAO.delete(id);

	}
	public List<Account> findAccountsByName(String name){
		List<Account> accounts = this.testDAO.findAccountsByName(name);
		return this.testDAO.findAccountsByName(name);
	}
	public void modify(Integer id,Integer money) {
		this.testDAO.updateMoney(id, money);
	}
	public void insert_good(String good_name,Integer good_price,Integer fav_price,String fav_start,String fav_end,Integer good_surnum,Integer state) {
		this.testDAO.insertgood(good_name, good_price,fav_price,fav_start,fav_end,good_surnum,state);
	}
}
