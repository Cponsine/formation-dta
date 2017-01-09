package fr.pizzeria.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("fr.pizzeria.*")
public class AspectConfig {
	@Bean//avec mysql
	DriverManagerDataSource dataSource(){
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
		data.setUsername("root");
		data.setPassword("");
		return data;
	}

}
