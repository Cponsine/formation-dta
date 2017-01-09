package fr.pizzeria.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class SpringJpaConfig {
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager();		
	}
	@Bean
	public LocalEntityManagerFactoryBean emf(){
		LocalEntityManagerFactoryBean em= new LocalEntityManagerFactoryBean();
		em.setPersistenceUnitName("h2");
		return em;
		
	}
	@Bean//avec H2
	DataSource dataSource(){		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); 
		return builder.setType(EmbeddedDatabaseType.H2).addScript("pizza.sql").build(); 
	
	}
	
}
