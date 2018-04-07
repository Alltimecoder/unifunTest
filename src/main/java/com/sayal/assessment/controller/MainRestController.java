package com.sayal.assessment.controller;


import com.sayal.assessment.persistance.DeliveryLogs;
import com.sayal.assessment.persistance.LogRepository;
import com.sayal.assessment.persistance.MSIDrepository;
import com.sayal.assessment.persistance.Msisdns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/*This is the controller which handles all the call regarding the listing of all database*/

@RestController
public class MainRestController {

    @Autowired
    private MSIDrepository msiDrepository; /*to get value from msisdns database*/

    @Autowired
    private LogRepository logRepository; /*to get value from delivery logs database*/

    @RequestMapping("/api/data/")
    public @ResponseBody
    Iterable<Msisdns> findAll(){
        Iterable<Msisdns> msisdns= msiDrepository.findAll();
        return msisdns;
    }

    @RequestMapping("/log/data")
    public @ResponseBody
    Iterable<DeliveryLogs> findAlllogs(){
        Iterable<DeliveryLogs> deliveryLogs= logRepository.findAll();
        return deliveryLogs;
    }

}
