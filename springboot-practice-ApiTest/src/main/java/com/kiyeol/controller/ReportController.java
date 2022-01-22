package com.kiyeol.controller;

import com.kiyeol.domain.Report;
import com.kiyeol.domain.ReportParam;
import com.kiyeol.domain.User;
import com.kiyeol.domain.WorkLog;
import com.kiyeol.repository.ReportRepository;
import com.kiyeol.repository.UserRepository;
import com.kiyeol.repository.WorkLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    //운동저장
    @PostMapping("/report-save")
    public ResponseEntity SaveReport(@Validated @RequestBody ReportParam reportParam){
        System.out.println("Work : "+reportParam.getUser_id()+"/"+reportParam.getContent());
        Report newReport = new Report();
        try{
            System.out.println(reportParam.getUser_id());
            Optional<User> selectUser = userRepository.findById(reportParam.getUser_id());
            System.out.println(selectUser.get().getName());
            if(selectUser!=null){
                newReport.setUser_id(selectUser.get());
                newReport.setContent(reportParam.getContent());
                Report result = reportRepository.save(newReport);
                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

}
