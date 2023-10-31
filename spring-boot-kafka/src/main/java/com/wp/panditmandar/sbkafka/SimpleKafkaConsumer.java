package com.wp.panditmandar.sbkafka;

import static com.wp.panditmandar.sbkafka.ApplicationConstant.STRING_KAFKA_LISTENER_CONTAINER_FACTORY;
import static com.wp.panditmandar.sbkafka.ApplicationConstant.STRING_TOPIC_NAME;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleKafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(SimpleKafkaConsumer.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = STRING_TOPIC_NAME, containerFactory = STRING_KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessage(String message) {
		logger.info(STRING_TOPIC_NAME + ": Received Simple String message=" + message);
		latch.countDown();
	}

}
