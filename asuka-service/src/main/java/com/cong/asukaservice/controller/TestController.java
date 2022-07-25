package com.cong.asukaservice.controller;

import com.cong.asukaservice.pojo.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("asuka/test")
public class TestController {

    @GetMapping("get")
    public Test getTest(HttpServletRequest request, HttpServletResponse response){
        log.info("requestURI: {}",request.getRequestURI());
        log.info("getRemoteHost: {}",request.getRemoteHost());
        Test test = new Test();
        test.setName("测试");
        test.setAge(16);
        test.setUrl("http://10.104.1.206/foo/bar");
        return test;
    }
}
