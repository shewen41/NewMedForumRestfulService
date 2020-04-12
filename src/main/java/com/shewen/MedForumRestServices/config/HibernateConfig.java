package com.shewen.MedForumRestServices.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/*import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;*/
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import static org.hibernate.cfg.Environment.*;


/* @EnableTransactionManagement */
/* @PropertySource(value = {"classpath:database.properties"}) */
@Configuration
@ComponentScan(basePackages = { "com.shewen.MedForumRestServices.dao" })
public class HibernateConfig{
	
	
	@Bean("dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/forumshewendb?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("shewen123456*");
         
        return dataSource;
    }
	
	
	/*
	 * @Bean public CategoryDAO getCategoryDAO() { return new
	 * CategoryDAOimpl(getDataSource()); }
	 */
	
	
	
	
	
	
	/*
	 * @Autowired Environment env;
	 * 
	 * @Bean public LocalSessionFactoryBean sessionFactory() throws
	 * PropertyVetoException { LocalSessionFactoryBean sessionFactory = new
	 * LocalSessionFactoryBean(); sessionFactory.setDataSource(restDataSource());
	 * sessionFactory.setPackagesToScan("com.shewen.pShoppingbackend.dto");
	 * sessionFactory.setHibernateProperties(hibernateProperties()); return
	 * sessionFactory; }
	 * 
	 * @Bean public ComboPooledDataSource restDataSource() throws
	 * PropertyVetoException{ ComboPooledDataSource dataSource = new
	 * ComboPooledDataSource();
	 * dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
	 * dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	 * dataSource.setUser(env.getProperty("jdbc.user"));
	 * dataSource.setPassword(env.getProperty("jdbc.pass")); return dataSource; }
	 * 
	 * @Bean
	 * 
	 * @Autowired public HibernateTransactionManager transactionManager(
	 * SessionFactory sessionFactory) {
	 * 
	 * HibernateTransactionManager txManager = new HibernateTransactionManager();
	 * txManager.setSessionFactory(sessionFactory);
	 * 
	 * return txManager; }
	 * 
	 * Properties hibernateProperties() { return new Properties() { {
	 * setProperty("hibernate.hbm2ddl.auto",
	 * env.getProperty("hibernate.hbm2ddl.auto")); setProperty("hibernate.dialect",
	 * env.getProperty("hibernate.dialect"));
	 * setProperty("hibernate.globally_quoted_identifiers", "true"); } }; }
	 */
	
	
	
	
	
	
	/*
	 * @Autowired private Environment environment;
	 * 
	 * private final static String DATABASE_URL =
	 * "jdbc:mysql://localhost:3306/pshopping"; private final static String
	 * DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver"; private final static String
	 * DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect"; private final
	 * static String DATABASE_USERNAME = "root"; private final static String
	 * DATABASE_PASWWORD = "shewen123456*";
	 * 
	 * @Bean public LocalSessionFactoryBean getSessionFactory() {
	 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 * 
	 * Properties props = new Properties();
	 * 
	 * props.put(DRIVER, environment.getProperty("com.mysql.cj.jdbc.Driver"));
	 * props.put(URL,
	 * environment.getProperty("jdbc:mysql://localhost:3306/pshopping"));
	 * props.put(USER, environment.getProperty("root")); props.put(PASS,
	 * environment.getProperty("shewen123456*"));
	 * 
	 * props.put(SHOW_SQL, environment.getProperty("true")); props.put(HBM2DDL_AUTO,
	 * environment.getProperty("update"));
	 * 
	 * sessionFactory.setHibernateProperties(props);
	 * 
	 * sessionFactory.setPackagesToScan("com.shewen.pShopping.dto");
	 * 
	 * return sessionFactory;
	 * 
	 * 
	 * }
	 */

	/*
	 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource(); dataSource.setDriverClassName(DRIVER,
	 * environment.getRequiredProperty("com.mysql.cj.jdbc.Driver"));
	 * dataSource.setUrl(environment.getRequiredProperty(
	 * "jdbc:mysql://localhost:3306/pshopping"));
	 * dataSource.setUsername(environment.getRequiredProperty("root"));
	 * dataSource.setPassword(environment.getRequiredProperty("shewen123456*"));
	 * return dataSource; }
	 * 
	 * private Properties hibernateProperties() { Properties properties = new
	 * Properties(); properties.put("hibernate.dialect",
	 * environment.getRequiredProperty("org.hibernate.dialect.MySQL5Dialect"));
	 * properties.put("hibernate.show_sql",
	 * environment.getRequiredProperty("true"));
	 * properties.put("hibernate.format_sql",
	 * environment.getRequiredProperty("true"));
	 * properties.put("hibernate.hbm2ddl.auto",
	 * environment.getRequiredProperty("create-drop")); return properties; }
	 */

	/*
	 * @Bean public HibernateTransactionManager getTransactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory(getSessionFactory().getObject()); return
	 * transactionManager; }
	 */

	/*
	 * @Bean public DataSource getDataSource() {
	 * 
	 * BasicDataSource dataSource = new BasicDataSource();
	 * 
	 * dataSource.setDriverClassName(DATABASE_DRIVER);
	 * dataSource.setUsername(DATABASE_USERNAME); dataSource.setUrl(DATABASE_URL);
	 * dataSource.setPassword(DATABASE_PASWWORD);
	 * 
	 * 
	 * 
	 * return dataSource;
	 * 
	 * }
	 * 
	 * @Bean public SessionFactory getSessionFactory(DataSource dataSource) {
	 * 
	 * LocalSessionFactoryBuilder builder = new
	 * LocalSessionFactoryBuilder(dataSource);
	 * 
	 * builder.addProperties(getHibernateProperties());
	 * builder.scanPackages("com.shewen.pShoppingbackend.dto");
	 * 
	 * return builder.buildSessionFactory(); }
	 * 
	 * 
	 * public Properties getHibernateProperties() {
	 * 
	 * Properties properties = new Properties();
	 * 
	 * properties.put("hibernate.dialect", DATABASE_DIALECT);
	 * properties.put("hibernate.show_sql", "true");
	 * properties.put("hibernate.format_sql", "true");
	 * properties.put("hbm2ddl_auto", "create-drop");
	 * 
	 * 
	 * 
	 * 
	 * return properties; }
	 */

	/*
	 * @Autowired private Environment env;
	 * 
	 * @Bean public LocalSessionFactoryBean getSessionFactory() {
	 * LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	 * Properties props = new Properties();
	 * 
	 * props.put(DRIVER, env.getProperty("com.mysql.cj.jdbc.Driver"));
	 * props.put(URL, env.getProperty("jdbc:mysql://localhost:3306/pshopping"));
	 * props.put(USER, env.getProperty("root")); props.put(PASS,
	 * env.getProperty("shewen123456*"));
	 * 
	 * 
	 * props.put(SHOW_SQL, env.getProperty("true")); props.put(HBM2DDL_AUTO,
	 * env.getProperty("create-drop")); props.put(FORMAT_SQL,
	 * env.getProperty("ture"));
	 * 
	 * props.put(DIALECT, env.getProperty("org.hibernate.dialect.MySQL5Dialect"));
	 * 
	 * 
	 * factoryBean.setHibernateProperties(props);
	 * factoryBean.setPackagesToScan("com.shewen.pShoppingbackend.dto");
	 * 
	 * return factoryBean;
	 * 
	 * }
	 */

	/*
	 * @Bean public HibernateTransactionManager getTransactionManager(SessionFactory
	 * sessionFactory) {
	 * 
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager(sessionFactory);
	 * 
	 * transactionManager.setSessionFactory(getSessionFactory().getObject());
	 * 
	 * 
	 * 
	 * return transactionManager;
	 * 
	 * }
	 */

	/*
	 * @Autowired Environment environment;
	 * 
	 * 
	 * private final static String DATABASE_URL
	 * ="jdbc:mysql://localhost:3306/pshopping"; private final static String
	 * DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver"; private final static String
	 * DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect"; private final
	 * static String DATABASE_USERNAME = "root"; private final static String
	 * DATABASE_PASSWORD = "shewen123456*";
	 * 
	 * 
	 * 
	 * //data source
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	 * final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	 * LocalContainerEntityManagerFactoryBean();
	 * entityManagerFactoryBean.setDataSource(getDataSource());
	 * entityManagerFactoryBean.setPackagesToScan(new String[] {
	 * "com.shewen.pShoppingbackend.dto" });
	 * 
	 * final HibernateJpaVendorAdapter vendorAdapter = new
	 * HibernateJpaVendorAdapter();
	 * entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	 * entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
	 * 
	 * return entityManagerFactoryBean; }
	 * 
	 * 
	 * //session Factory
	 * 
	 * @Bean public SessionFactory getSessionFactory(DataSource dataSource) {
	 * 
	 * LocalSessionFactoryBuilder builder = new
	 * LocalSessionFactoryBuilder(dataSource);
	 * 
	 * builder.addProperties(getHibernateProperties());
	 * builder.scanPackages("com.shewen.pShoppingbackend.dto");
	 * 
	 * return builder.buildSessionFactory();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Bean public LocalSessionFactoryBean sessionFactory() {
	 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 * sessionFactory.setDataSource(getDataSource());
	 * sessionFactory.setPackagesToScan(new
	 * String[]{"com.shewen.pShoppingbackend.dto"});
	 * sessionFactory.setHibernateProperties(hibernateProperties());
	 * 
	 * return sessionFactory; }
	 * 
	 * 
	 * @Bean public DataSource getDataSource() {
	 * 
	 * BasicDataSource dataSource = new BasicDataSource();
	 * dataSource.setDriverClassName(DRIVER, environment.getRequiredProperty(""));
	 * dataSource.setUrl(URL,
	 * environment.getRequiredProperty("jdbc:mysql://localhost:3306/pshopping"));
	 * dataSource.setUsername(USER, environment.getRequiredProperty("root"));
	 * dataSource.setPassword(PASS,
	 * environment.getRequiredProperty("shewen123456*")); return dataSource; }
	 * 
	 * 
	 * BasicDataSource dataSource = new BasicDataSource();
	 * 
	 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/pshopping");
	 * dataSource.setUsername("root"); dataSource.setPassword("shewen123456*");
	 * 
	 * 
	 * return dataSource;
	 * 
	 * 
	 * }
	 * 
	 * @Bean public HibernateTransactionManager hibernateTransactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory(sessionFactory().getObject()); return
	 * transactionManager; }
	 * 
	 * private final Properties hibernateProperties() { Properties
	 * hibernateProperties = new Properties(); hibernateProperties.setProperty(
	 * "hibernate.hbm2ddl.auto", "create-drop"); hibernateProperties.setProperty(
	 * "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	 * 
	 * return hibernateProperties; }
	 * 
	 * 
	 * 
	 * 
	 * private Properties getHibernateProperties() {
	 * 
	 * 
	 * 
	 * Properties properties = new Properties();
	 * 
	 * 
	 * 
	 * properties.setProperty("hibernate.driver", "com.mysql.cj.jdbc.Driver");
	 * properties.setProperty("hibernate.url",
	 * "jdbc:mysql://localhost:3306/pshopping");
	 * properties.setProperty("hibernate.user", "root");
	 * properties.setProperty("hibernate.pass", "shewen123456*");
	 * properties.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL5Dialect");
	 * 
	 * properties.setProperty("hibernate.show_sql", "true");
	 * properties.setProperty("hibernate.hbm2ddl", "create-drop");
	 * properties.setProperty("hibernate.format_sql", "true");
	 * 
	 * 
	 * 
	 * 
	 * properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	 * 
	 * 
	 * properties.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL5Dialect");
	 * properties.setProperty("hibernate.show_sql", "true");
	 * properties.setProperty("hibernate.format_sql", "true");
	 * 
	 * 
	 * 
	 * 
	 * return properties; }
	 * 
	 * 
	 * 
	 * @Bean public DriverManagerDataSource getDataSource1() {
	 * 
	 * DriverManagerDataSource dbs = new DriverManagerDataSource();
	 * 
	 * dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * dbs.setUrl("jdbc:mysql://localhost:3306/pshopping"); dbs.setUsername("root");
	 * dbs.setPassword("shewen123456*");
	 * 
	 * 
	 * return dbs;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @Bean public HibernateTransactionManager getTransactionManager(SessionFactory
	 * sessionFactory) {
	 * 
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager(sessionFactory);
	 * 
	 * 
	 * return transactionManager;
	 * 
	 * }
	 * 
	 */
}
