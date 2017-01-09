package fr.pizzeria.dao;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaSpringJdbc;

@Configuration
@ComponentScan({"fr.pizzeria.dao"})
public class SpringJdbcConfig {
	/*@Bean//avec mysql
	DriverManagerDataSource dataSource(){
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
		data.setUsername("root");
		data.setPassword("");
		return data;
	}*/
	
	@Bean//avec H2
	DataSource dataSource(){		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); 
		return builder.setType(EmbeddedDatabaseType.H2).addScript("pizza.sql").build(); 
	
	}
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	@Bean
	public PizzaDao dao(){
		return new PizzaSpringJdbc();
	}
}
