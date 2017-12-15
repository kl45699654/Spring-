package cn.kiiwii.framework.spring.TestSpring.springwithmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Form {
    @RequestMapping("/{formName}")
    public String form(@PathVariable String formName) {
      return formName;
    }
}
