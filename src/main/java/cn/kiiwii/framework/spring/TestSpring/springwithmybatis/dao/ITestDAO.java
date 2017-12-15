package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.Account;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.User;
import org.mybatis.caches.ehcache.LoggingEhcache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Repository("testDAO")
public interface ITestDAO {

	String ADD_MONEY = "update account set money = money+#{1} where id = #{0}";
	
	String MINUS_MONEY = "update account set money = money-#{1} where id = #{0}";
	
	String INSERT_ACCOUT = "insert into account (name,money) values (#{name},#{money})";
	
	String FIND_ACCOUNT_BY_ID = "select " +
			" id as id," +
			" name as name," +
			" money as money" +
			" from account " +
			" where " +
			" id = #{id}";
	
	String FIND_ACCOUNTS_BY_ID = "select " +
			" id as id," +
			" name as name," +
			" money as money" +
			" from account " +
			" where " +
			" id >= #{id}";
	String INSERT ="insert into account(name,money) values(#{0},#{1})";
	String DELETE ="DELETE FROM account WHERE id = #{id}";
	String QUERY_MONEY="select money from account where name = #{name}";
	String MODIFY="update account set money = #{money} where id = #{id}";
	String ADDGOOD="insert into good (good_name,good_price,fav_price,fav_start,fav_end,good_surnum,state) values(#{good_name},#{good_price},#{fav_price},#{fav_start},#{fav_end},#{,good_surnum},#{state})";
	@Update(ADD_MONEY)
	public int addMoney(int userId,float money);
	
	@Update(MINUS_MONEY)
	public int minusMoney(int userId,float money);
	
	@Insert(INSERT_ACCOUT)
	@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
	public int insertAccount(Account account);

	@Select(FIND_ACCOUNT_BY_ID)
	@Cacheable(value = "indexCache",key = "'getAccountById'+#id")
	public Account getAccountById(int id);

	@Select(FIND_ACCOUNTS_BY_ID)
	@Cacheable(value = "indexCache",key = "'findAccountsById'+#id")
	public List<Account> findAccountsById(int id);

	@Insert(INSERT)
	void insert(String name, Integer money);

	@Update(DELETE)
	int delete(int id);
	@Select(QUERY_MONEY)
	//@Cacheable(value = "indexCache",key = "'findAccountsByName'+#name")
	public List<Account> findAccountsByName(String name);

	@Update(MODIFY)
	void updateMoney(@Param("id") Integer id, @Param("money")Integer money);
	@Insert(ADDGOOD)
	void insertgood(@Param("good_name") String good_name,@Param("good_price") Integer good_price,@Param("fav_price") Integer fav_price,@Param("fav_start") String fav_start,@Param("fav_end") String fav_end,@Param("good_surnum") Integer good_surnum,@Param("state") Integer state);

}
