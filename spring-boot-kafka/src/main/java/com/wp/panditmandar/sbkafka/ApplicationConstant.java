package com.wp.panditmandar.sbkafka;

public class ApplicationConstant {

	public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:9092";
	
	public static final String STRING_TOPIC_NAME = "test-events-string-1";
	public static final String STRING_KAFKA_LISTENER_CONTAINER_FACTORY = "simpleKafkaListenerContainerFactory";
	
	public static final String JSON_TOPIC_NAME = "test-events-json-1";
	public static final String JSON_KAFKA_LISTENER_CONTAINER_FACTORY = "jsonKafkaListenerContainerFactory";

}
