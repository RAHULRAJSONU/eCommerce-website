package com.rahul.ecartbackend.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@ComponentScan(basePackages = { "com.rahul.ecartbackend.dto" })
@EnableTransactionManagement
public class HibernateConfiguration {

	@Bean("dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		try {
			dataSource.setUrl(getPropValues("database.url"));
			dataSource.setUsername(getPropValues("database.user"));
			dataSource.setDriverClassName(getPropValues("database.driver"));
			dataSource.setPassword(getPropValues("database.password"));
		} catch (IOException e) {
			System.out.println("DB properties could not set!");
		}

		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.rahul.ecartbackend.dto");
		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getTransectionManager(SessionFactory factory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(factory);
		return hibernateTransactionManager;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		try {
			properties.put("hibernate.dialect", getPropValues("hibernate.dialect"));
			properties.put("hibernate.show_sql", getPropValues("hibernate.show_sql"));
			properties.put("hibernate.format_sql", getPropValues("hibernate.format_sql"));
			properties.put("hibernate.hbm2ddl.auto", getPropValues("hibernate.hbm2ddl.auto"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	public String getPropValues(String key) throws IOException {
		InputStream inputStream = null;
		String value = null;
		try {
			Properties prop = new Properties();
			String propFileName = "com/rahul/ecartbackend/resources/config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return value;
	}
}
