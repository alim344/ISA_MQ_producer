package com.example.bunnycare.controller;

import com.example.bunnycare.model.BunnyCareInfo;
import com.example.bunnycare.service.BunnyInfoService;
import com.example.bunnycare.service.Producer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private Producer producer;

    @Autowired
    private BunnyInfoService bunnyInfoService;

    @PostMapping("send/{info_id}")
   public String sendMessage(@PathVariable Long info_id) {

        BunnyCareInfo info = bunnyInfoService.findById(info_id);
        if(info != null) {
            producer.sendMessage(info);
            return info.getShelter_name() +"Message sent";
        }

        return "Info not found boo";


    }



}
