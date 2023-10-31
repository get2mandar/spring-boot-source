package com.wp.panditmandar.sbkafka;

import static com.wp.panditmandar.sbkafka.ApplicationConstant.JSON_TOPIC_NAME;
import static com.wp.panditmandar.sbkafka.ApplicationConstant.STRING_TOPIC_NAME;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<Integer, String> simpleKafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Customer> jsonKafkaTemplate;

	@GetMapping("/message/simple/{simpleStringMsg}")
	public String sendSimpleStringMessage(@PathVariable String simpleStringMsg) {

		try {
			simpleKafkaTemplate.send(STRING_TOPIC_NAME, simpleStringMsg);
			logger.info(
					"Sent Message as Simple String : message=" + simpleStringMsg + " to topic=" + STRING_TOPIC_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Simple Message sent succuessfully";
	}

	@PostMapping("/message/json")
	public String sendJsonMessage(@RequestBody Customer customer) {

		try {
			jsonKafkaTemplate.send(JSON_TOPIC_NAME, customer);
			logger.info("Sent Message as JSON : message=" + customer + " to topic=" + JSON_TOPIC_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "JSON {Customer} sent succuessfully";
	}

}