package taitt.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import taitt.springboot.bean.Bean1;

@Configuration
public class AppConfig {

	@Bean
	public Bean1 getBean1(){
		Bean1 bean1 = new Bean1();
		bean1.setName("TaiTT4");
		return bean1;
	}
	
}
