package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.app.config"})
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.app.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	
	public Properties hibernateProperties(){
		
		Properties p = new Properties();
		p.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		p.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		p.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		
		return p;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager txManager(SessionFactory s){
		
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(s);
		return tx;
	}
}
