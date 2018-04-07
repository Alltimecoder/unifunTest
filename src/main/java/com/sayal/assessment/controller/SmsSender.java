package com.sayal.assessment.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.sayal.assessment.MainService;
import com.sayal.assessment.persistance.MSIDrepository;

import com.sayal.assessment.persistance.Msisdns;
import org.apache.http.client.utils.URIBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/*Main fake sms sender script to send fake sms using smsc*/

@RestController
public class SmsSender {

    @Autowired
    private MSIDrepository msiDrepository;

    @Autowired
    MainService mainService; /*used as a bridge between repository and controller. useful for saving in database or deleting and so on*/


    @RequestMapping("/smstest")
    public String kannelSmsTest() {

        List<Msisdns> msisdns = (List<Msisdns>) msiDrepository.findAll();
        System.out.print(msisdns.size());
        //System.out.print(String.valueOf(msisdns.get(0).getMsisdns()));
        URI uri = null;
        String result = null;
        String text="script works really fast!!";

        /*using for loop to feed phone numbers to uri parameter and run in loop until there are more columns*/

       for(int i =0; i< msisdns.size()  ; i++) {


           try {

               uri = new URIBuilder()

                       .setScheme("http")

                       .setHost("localhost:13013")

                       .setPath("/cgi-bin/sendsms")

                       .setParameter("username", "sayal")  // kannel username

                       .setParameter("password", "adhikari")   // kannel password

                       .setParameter("smsc", "fake")        // smsc name

                       .setParameter("from", "Test")          // sender of message

                       .setParameter("to", String.valueOf(msisdns.get(i).getMsisdns()))   // mobile number

                       .setParameter("text", text)  // message to send

                       .build();

           } catch (URISyntaxException e) {
               e.printStackTrace();
           }

           RestTemplate restTemplate = new RestTemplate();
           result = restTemplate.getForObject(uri, String.class);

           /*calling main service to save log data to databse using repository*/
           mainService.addLogs(String.valueOf(msisdns.get(i).getMsisdns()),text,"2018 07;15PM",result);

           System.out.println(uri);
           System.out.print(result);

       }

        return result;
    }

}

