package com.cumin.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@SuppressWarnings("deprecation")
@EnableWebMvc

@Configuration
@ComponentScan(basePackages = "com.cumin")
@PropertySource("classpath:Hibernate.properties")

public class AppConfig extends WebMvcConfigurerAdapter{
@Autowired
private Environment env;
	@Bean
	public InternalResourceViewResolver resolver(){
		InternalResourceViewResolver resolve=new InternalResourceViewResolver();
		resolve.setPrefix("/WEB-INF/view/");
		resolve.setSuffix(".jsp");
		return resolve;	
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
	public DataSource securityData() {
	// create connection pool
		ComboPooledDataSource securitydata=new ComboPooledDataSource();
		try {
			securitydata.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
      // set jdbc property
      securitydata.setJdbcUrl(env.getProperty("jdbc.url"));
      securitydata.setUser(env.getProperty("jdbc.user"));
      securitydata.setPassword(env.getProperty("jdbc.password"));
	  securitydata.setInitialPoolSize(getIntpropert("connection.pool.initialPoolSize"));
	  securitydata.setMinPoolSize(getIntpropert("connection.pool.minPoolSize"));
	  securitydata.setMaxPoolSize(getIntpropert("connection.pool.maxPoolSize"));
	  securitydata.setMaxIdleTime(getIntpropert("connection.pool.maxIdleTime"));
	  return securitydata;	
	}
	
	private int getIntpropert(String prop) {
		String propval=env.getProperty(prop);
		int intprop=Integer.parseInt(propval);
		return intprop;
	}
	@Bean
	public LocalSessionFactoryBean  sessionFactory() 
	{
	    LocalSessionFactoryBean  factory =new LocalSessionFactoryBean ();
		factory.setDataSource(securityData());
		Properties prop=new Properties();
		prop.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		prop.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		factory.setHibernateProperties(prop);
		factory.setPackagesToScan("com.cumin.entity");		
		return factory;
	}

	@Bean
	public HibernateTransactionManager manager() {
		HibernateTransactionManager man=new HibernateTransactionManager();
		man.setSessionFactory(sessionFactory().getObject());
		return man;
	}
	
	
	
	
	
}
