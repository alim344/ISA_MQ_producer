package com.example.bunnycare.controller;

import com.example.bunnycare.model.BunnyCareInfo;
import com.example.bunnycare.service.Producer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private Producer producer;

    @PostMapping("send")
   public String sendMessage(@RequestParam BunnyCareInfo bunnyCareInfo) {
        producer.sendMessage(bunnyCareInfo);
        return bunnyCareInfo.getShelter_name() +"Message sent";
    }



}
