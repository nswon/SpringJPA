package com.kiyeol.controller;

import com.kiyeol.domain.WorkLog;
import com.kiyeol.repository.WorkLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class WorkController {
    @Autowired
    private WorkLogRepository workLogRepository;

    //운동저장
    @PostMapping("/work-save")
    public ResponseEntity SaveWorkLog(@Validated @RequestBody WorkLog workLog){
        System.out.println("Work : "+workLog.getUser_id()+"/"+workLog.getStart_latitude());
        WorkLog result = workLogRepository.save(workLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
