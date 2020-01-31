package com.example.rabbitMQproducerr.Service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbitMQproducerr.Entity.Employee;

@Service
public class RabbitMQSender {
//convert and sends
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${rabbitMQproducer.rabbitmq.exchange}")
	private String exchange;
	
	@Value("rabbitMQproducer.rabbitmq.routingkey")
	private String routingkey;
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange,routingkey,company);
		System.out.println("Send msg" + company);
	}
}
