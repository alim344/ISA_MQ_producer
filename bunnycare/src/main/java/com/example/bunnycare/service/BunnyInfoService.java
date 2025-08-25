package com.example.bunnycare.service;

import com.example.bunnycare.model.BunnyCareInfo;
import com.example.bunnycare.repository.BunnyCareInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BunnyInfoService {

    @Autowired
    private BunnyCareInfoRepository infoRepository;


    public BunnyCareInfo findById(Long id) {
        return infoRepository.findBunnyCareInfoById(id);
    }

}
