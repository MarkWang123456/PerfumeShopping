package com.example.controller;

import com.example.domain.Order;
import com.example.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class OrderController {

    @Resource
    private OrderService orderService;

    //查詢所有訂單
    @GetMapping("/order")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> findAll = orderService.findAll();
        return ResponseEntity.ok(findAll);
    }

    //查詢所有訂單分頁
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> findByPaging(){
        List<Order> findAll = orderService.findAllPaging(0);
        return ResponseEntity.ok(findAll);
    }

}
