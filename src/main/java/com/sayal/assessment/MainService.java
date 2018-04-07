package com.sayal.assessment;

import com.sayal.assessment.persistance.DeliveryLogs;
import com.sayal.assessment.persistance.LogRepository;
import com.sayal.assessment.persistance.MSIDrepository;
import com.sayal.assessment.persistance.Msisdns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
/*
this is used as a mediator between controller and repositories.
all the repositories methods can be implemented here and used elsewhere */

@Service
public class MainService {

    @Autowired
    LogRepository logRepository;

    @Autowired
    MSIDrepository msiDrepository;

    public String addMsisdns(String msisdns1){
        Msisdns msisdns= new Msisdns();
        msisdns.setMsisdns(msisdns1);
        msisdns.setExtras("extra data");
        msisdns.setLog("test log");
        msiDrepository.save(msisdns);
        return "msisdns added";
    }

    public String addLogs(String msisdns, String text,
                          String deliveryTime, String deliveryReport) {
        DeliveryLogs deliveryLogs = new DeliveryLogs();
        Date date = new Date();
        deliveryLogs.setMsisdns(msisdns);
        deliveryLogs.setSentTime(date);
        deliveryLogs.setText(text);
        deliveryLogs.setDeliveryTime(deliveryTime);
        deliveryLogs.setDeliveryReport(deliveryReport);
        logRepository.save(deliveryLogs);
        return "log added";
    }
}
