package com.wz.controller;

import com.wz.service.MemberService;
import com.wz.service.OrderHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/orderIndexHystrix")
    public Object orderIndexHystrix() throws InterruptedException {
        return new OrderHystrixCommand(memberService).execute();
    }

    @RequestMapping("/orderIndex")
    public Object orderIndex() throws InterruptedException {

        Map<String,Object> map = new HashMap<>();

        map.put("code","100");

        System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",订单服务调用会员服务:member:" + map);

        return map;
    }
}
