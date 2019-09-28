package com.top.demo.modules.admin.controller;


import com.top.demo.api.TestControllerApi;
import com.top.demo.base.BaseController;
import com.top.demo.modules.admin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lth
 * @version 1.0.0
 * @date
 */
@RestController
public class TestController extends BaseController implements TestControllerApi {

    @Autowired
    TestService testService;

    @Override
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }





}
