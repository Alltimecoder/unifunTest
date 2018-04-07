package com.sayal.assessment.persistance;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
repositories used for getting values from database or saving data to database*/

public interface MSIDrepository extends org.springframework.data.repository.CrudRepository<Msisdns, Long> {


    List<Msisdns> findAllByMsisdns(String msisdns);

}
