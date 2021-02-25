package com.wxss.hhlife.api.merchant.controller;

import com.wxss.hhlife.api.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("save")
    public String saveMerchantInfo(){
        merchantService.saveMerchantInfo();
        return "SAVE";
    }

    @GetMapping("test")
    public String test(){
        return "YES";
    }
}
