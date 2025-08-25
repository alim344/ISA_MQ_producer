package com.example.bunnycare.repository;

import com.example.bunnycare.model.BunnyCareInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BunnyCareInfoRepository extends JpaRepository<BunnyCareInfo, Long> {


    BunnyCareInfo findBunnyCareInfoById(Long id);
}
