package com.sayal.assessment;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import com.sayal.assessment.persistance.MSIDrepository;
import com.sayal.assessment.persistance.Msisdns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/*
this script is useful only at the beginning for pushing data into database from provided csv file*/

@RestController
public class CSVreader {

    @Autowired
    private MSIDrepository msiDrepository;

    @Autowired
            private MainService mainService;

    String csvFile = "src/main/resources/msisdns.csv";


    @RequestMapping("/script")
    public String csvtoData() throws Exception {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFile));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {

            /*using foreach loop to add data to database until there is next data available in csv file*/

            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String msisdns = csvRecord.get(0);

                mainService.addMsisdns(csvRecord.get(0));
                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + msisdns);
                System.out.println("---------------\n\n");


            }
        }
        return "Script Running";
    }
}