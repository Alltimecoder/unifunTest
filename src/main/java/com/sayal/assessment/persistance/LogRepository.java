package com.sayal.assessment.persistance;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
/*
repositories used for getting values from database or saving data to database*/

public interface LogRepository extends CrudRepository<DeliveryLogs, String> {


    List<DeliveryLogs> findAllByMsisdns(String msisdns);
}
