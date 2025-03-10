package com.example.petstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


import com.example.petstore.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.petstore.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;


/**
 * http localhost:8080/customers id="jyjang@uengine.org" address:='{"zipcode":"123", "detail":"용인"}'
 */

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
@EnableBinding(KafkaProcessor.class)
@Transactional
public class StoreApplication {
	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(StoreApplication.class, args);
	}

	@Autowired
	PartyInfoRepository partyInfoRepository;


	@RequestMapping(method = RequestMethod.PUT, path="partyInfoes/{partyInfoId}/apply")
	public String applyParty(@PathVariable(value = "partyInfoId") Long partyInfoId){

		PartyInfo theParty = partyInfoRepository.findById(partyInfoId).get();

		partyInfoRepository.addMember();
		partyInfoRepository.save(theParty);

		return "파티 신청이 완료되었습니다.";
	}

}
