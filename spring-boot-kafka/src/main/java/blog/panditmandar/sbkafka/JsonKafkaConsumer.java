package blog.panditmandar.sbkafka;

import static blog.panditmandar.sbkafka.ApplicationConstant.JSON_KAFKA_LISTENER_CONTAINER_FACTORY;
import static blog.panditmandar.sbkafka.ApplicationConstant.JSON_TOPIC_NAME;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class JsonKafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = JSON_TOPIC_NAME, containerFactory = JSON_KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessage(Customer customer) {
		logger.info(JSON_TOPIC_NAME + ": Received JSON message=" + customer);
		latch.countDown();
	}

}
