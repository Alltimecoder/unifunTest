package com.sayal.assessment.controller;


import com.sayal.assessment.persistance.DeliveryLogs;
import com.sayal.assessment.persistance.LogRepository;
import com.sayal.assessment.persistance.MSIDrepository;
import com.sayal.assessment.persistance.Msisdns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/*
This controller is created for homepage Mapping and for testing if databases works or not
*/

@Controller
public class MainController {

    @Autowired
    private MSIDrepository msiDrepository;

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/")
    public String homepage(){
        return "home";
    }

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String msisdns
            , @RequestParam String log, @RequestParam String extra) {

        Msisdns msisdns1= new Msisdns();
        msisdns1.setMsisdns(msisdns);
        msisdns1.setLog(log);
        msisdns1.setExtras(extra);
        msiDrepository.save(msisdns1);
        return "Saved";
    }

    @GetMapping(path = "/logs")
    public @ResponseBody
    String addLogs(@RequestParam long msisdns,  @RequestParam String text,
                   @RequestParam String deliveryTime, @RequestParam String deliveryReport){
        DeliveryLogs deliveryLogs= new DeliveryLogs();
        Date date = new Date();
        deliveryLogs.setSentTime(date);
        deliveryLogs.setText(text);
        deliveryLogs.setDeliveryTime(deliveryTime);
        deliveryLogs.setDeliveryReport(deliveryReport);
        logRepository.save(deliveryLogs);
        return "log added";
    }
}
