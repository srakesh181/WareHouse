package com.app.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Document;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.WhUserType;

@Configuration
@ComponentScan("com.app")
@EnableWebMvc
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		return new InternalResourceViewResolver(env.getProperty("spring.mvc.prefix"),env.getProperty("spring.mvc.suffix"));
	}
	
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("spring.jdbc.dc"));
		ds.setUrl(env.getProperty("spring.jdbc.url"));
		ds.setUsername(env.getProperty("spring.jdbc.un"));
		ds.setPassword(env.getProperty("spring.jdbc.pwd"));
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(basicDataSource());
		sf.setHibernateProperties(props());
		sf.setAnnotatedClasses(ShipmentType.class,Uom.class,WhUserType.class,OrderMethod.class,Item.class,Document.class);
		//sf.setPackagesToScan("com.app.model");
		return sf;
	}
	
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("spring.orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("spring.orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("spring.orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("spring.orm.ddlauto"));
		return p;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(localSessionFactoryBean().getObject());
		return ht;
	} 
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(localSessionFactoryBean().getObject());
		return htm;
	}
	
	//@Bean
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr=new CommonsMultipartResolver();
		return cmr;
	} 

}
