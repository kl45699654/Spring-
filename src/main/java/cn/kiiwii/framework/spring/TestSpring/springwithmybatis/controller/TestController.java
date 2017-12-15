package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.controller;

import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.model.Account;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service.ITestService;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.service.ITestXmlService;
import cn.kiiwii.framework.spring.TestSpring.springwithmybatis.utils.HttpServletUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhong on 2016/3/20.
 */
@Controller
@RequestMapping("/")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;


    @Autowired
    private ITestXmlService testXmlService;

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(3);

        logger.info(accountList);
        HttpServletUtils.responseAccessData(response,accountList);
    }
    @RequestMapping("/addUser")
    public void addUers(HttpServletRequest request, HttpServletResponse response,@RequestParam("name") String name,
                        @RequestParam("money") Integer money) {
        System.out.println(name);
        System.out.println(money);
        testService.insert(name,money);

        HttpServletUtils.responseAccessData(response,"success");
    }
    @RequestMapping("/addGood")
    public void addUers(HttpServletRequest request, HttpServletResponse response,@RequestParam("good_name") String good_name,
                        @RequestParam("good_price") Integer good_price,@RequestParam("fav_price") Integer fav_price,
                        @RequestParam("fav_start") String fav_start,
                        @RequestParam("fav_end") String fav_end,@RequestParam("good_surnum") Integer good_surnum,
                        @RequestParam("state") Integer state) {
        testService.insert_good(good_name,good_price,fav_price,fav_start,fav_end,good_surnum,state);


        HttpServletUtils.responseAccessData(response,"success");
    }
    @RequestMapping("/addorder")
    public void addorder(HttpServletResponse response,@RequestParam(""))
    @RequestMapping("/delUser")
    public void delUers(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") Integer id)
                        {
        testService.delete(id);

        HttpServletUtils.responseAccessData(response,"success");
    }
    @RequestMapping("/testXml")
    public void testXml(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testXmlService.findAccountsById(3);
        logger.info(accountList);
        HttpServletUtils.responseAccessData(response,accountList);
    }
    @RequestMapping("/queMoney")
    public void queMoney(HttpServletRequest request, HttpServletResponse response,@RequestParam("name") String name){
        List<Account> accountList = this.testService.findAccountsByName(name);
        logger.info(accountList);
        HttpServletUtils.responseAccessData(response,accountList);
    }
    @RequestMapping("/modifyMoney")
    public void modifyMoney(@RequestParam("id") Integer id,
                        @RequestParam("money") Integer money) {

        testService.modify(id,money);
/*
        HttpServletUtils.responseAccessData(response,"success");*/
    }
    @RequestMapping(value="/page/{name}/{age}",method = RequestMethod.GET)
    public String getName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") int age) {
        map.addAttribute("name", name);
        map.addAttribute("age", age);

        return "name";
    }
    @RequestMapping(value ="/result",method = RequestMethod.POST)
        public  String result(ModelMap map,@RequestParam String name,@RequestParam int age){
            map.addAttribute("name",name);
            map.addAttribute("age",age);
            return "result";
        }
        @RequestMapping(value="/adduser",method = RequestMethod.GET)
        public  String addUser(ModelMap map){
            User u = new User();
            u.setName("szhshuaige");
            map.addAttribute("user",u);
            return "add_user";


        }
    }


