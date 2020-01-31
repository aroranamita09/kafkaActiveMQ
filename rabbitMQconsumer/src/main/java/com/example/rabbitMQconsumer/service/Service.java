package com.example.rabbitMQconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitMQconsumer.Entity.Employee;

@Component
public class Service {
	@RabbitListener(queues="${rabbitMQproducer.rabbitmq.queue}")
	public void receiveMessage(Object emp) {
		System.out.println("Received msg" + emp);
	}

}
