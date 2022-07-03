package com.example.petstore;

import com.example.petstore.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;


/**
 * http localhost:8080/customers id="jyjang@uengine.org" address:='{"zipcode":"123", "detail":"용인"}'
 */

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
@EnableBinding(KafkaProcessor.class)
public class StoreApplication {
	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(StoreApplication.class, args);
	}

	@Autowired
	PartyInfoRepository partyInfoRepository;

	@Autowired
	MemberRepository memberRepository;



	@RequestMapping(method = RequestMethod.PUT, path="s/{partyInfoId}/apply")
	public String applyParty(@PathVariable(value = "partyInfoId") Long partyInfoId){

		PartyInfo theParty = partyInfoRepository.findById(partyInfoId).get();

		partyInfoRepository.save(theParty);

		return "파티 신청이 완료되었습니다.";
	}

}
