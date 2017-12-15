package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service;

import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.Account;

import java.util.List;

public interface ITestService {

	
	void test();
	
	 boolean transfer(float money, int from, int to) throws Exception;
	
	 int insertAccount(Account account) throws Exception;

	 Account findAccountById(int i);
	
	List<Account> findAccountsById(int i);

	void  insert(String name,Integer money);
	void  delete(Integer id);

	List<Account> findAccountsByName(String name);

	void modify(Integer id,Integer money);
	void insert_good(String good_name,Integer good_price,Integer fav_price,String fav_start,String fav_end,Integer good_surnum,Integer state);
}
