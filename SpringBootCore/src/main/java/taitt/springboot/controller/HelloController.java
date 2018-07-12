package taitt.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taitt.springboot.bean.Bean1;

@RestController
public class HelloController {
	
	@Autowired
	public Bean1 bean1;
	
	@RequestMapping("/hellotaitt")
	public String hello(){
		System.out.println(bean1.getName());
		return bean1.getName();
	}
}
