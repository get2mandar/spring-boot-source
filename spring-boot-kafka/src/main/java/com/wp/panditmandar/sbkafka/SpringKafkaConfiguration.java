package com.wp.panditmandar.sbkafka;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
public class SpringKafkaConfiguration {

	@Autowired
	private KafkaProperties properties;

	// Simple String Message Passing KAFKA Configuration
	@Bean
	public KafkaTemplate<Integer, String> simpleKafkaTemplate(
			ProducerFactory<Integer, String> simpleKafkaProducerFactory) {
		KafkaTemplate<Integer, String> kafkaTemplate = new KafkaTemplate<Integer, String>(simpleKafkaProducerFactory);
		return kafkaTemplate;
	}

	@Bean
	public ProducerFactory<Integer, String> simpleKafkaProducerFactory() {
		Map<String, Object> producerConfigMap = this.properties.buildProducerProperties();
		producerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		producerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		DefaultKafkaProducerFactory<Integer, String> simpleFactory = new DefaultKafkaProducerFactory<Integer, String>(
				producerConfigMap);
		String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
		if (transactionIdPrefix != null) {
			simpleFactory.setTransactionIdPrefix(transactionIdPrefix);
		}
		return simpleFactory;
	}

	@Bean
	public ConsumerFactory<Integer, String> simpleKafkaConsumerFactory() {
		Map<String, Object> consumerConfigMap = this.properties.buildConsumerProperties();
		consumerConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		consumerConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(consumerConfigMap);
	}

	@Bean("simpleKafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Integer, String> simpleKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<Integer, String>();
		factory.setConsumerFactory(simpleKafkaConsumerFactory());
		return factory;
	}

	// JSON Object Passing KAFKA Configuration
	@Bean
	public KafkaTemplate<String, Customer> jsonKafkaTemplate(
			ProducerFactory<String, Customer> jsonKafkaProducerFactory) {
		KafkaTemplate<String, Customer> kafkaTemplate = new KafkaTemplate<String, Customer>(jsonKafkaProducerFactory);
		return kafkaTemplate;
	}

	@Bean
	public ProducerFactory<String, Customer> jsonKafkaProducerFactory() {
		Map<String, Object> producerConfigMap = this.properties.buildProducerProperties();
		producerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		DefaultKafkaProducerFactory<String, Customer> simpleFactory = new DefaultKafkaProducerFactory<String, Customer>(
				producerConfigMap);
		String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
		if (transactionIdPrefix != null) {
			simpleFactory.setTransactionIdPrefix(transactionIdPrefix);
		}
		return simpleFactory;
	}

	@Bean
	public ConsumerFactory<String, Customer> jsonKafkaConsumerFactory() {
		Map<String, Object> consumerConfigMap = this.properties.buildConsumerProperties();
		consumerConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerConfigMap.put(JsonDeserializer.TRUSTED_PACKAGES, "blog.panditmandar.code.kafkademo");
		return new DefaultKafkaConsumerFactory<>(consumerConfigMap);
	}

	@Bean("jsonKafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, Customer> jsonKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Customer> factory = new ConcurrentKafkaListenerContainerFactory<String, Customer>();
		factory.setConsumerFactory(jsonKafkaConsumerFactory());
		return factory;
	}

}
