package com.example.rabbitMQproducerr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitMQproducerr.Entity.Employee;
import com.example.rabbitMQproducerr.Service.RabbitMQSender;

@RestController
@RequestMapping(value= "/producermq")
public class Controller {

	@Autowired
	RabbitMQSender rabbitmqsender;
	
	@GetMapping(value="/producerclass")
	public String producer(@RequestParam("empName") String emp, @RequestParam("empId") String empid) {
		Employee empl = new Employee();
		empl.setEmpId(empid);
		empl.setEmpName(emp);
		rabbitmqsender.send(empl);
		return "Message sent";
	}
	
}
