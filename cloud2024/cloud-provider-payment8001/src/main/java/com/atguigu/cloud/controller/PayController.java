package com.atguigu.cloud.controller;


import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public String addPay(@RequestBody Pay pay){
        System.out.println(pay);
        int i =payService.add(pay);
        return "插入成功，返回值为" +i;
    }

    @DeleteMapping("/pay/del/{id}")
    public String deletePay(@PathVariable("id") Integer id){
        System.out.println(id);
        int i =payService.delete(id);
        return "删除成功，返回值为" +i;
    }

    @PutMapping("/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        System.out.println(pay);
        int i =payService.update(pay);
        return "更新成功，返回值为" +i;
    }

    @GetMapping("/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }
    @GetMapping("/pay/getAll")
    public List<Pay> getAll(){
        return payService.getAll();
    }

}
