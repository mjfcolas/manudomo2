package com.manu.manudomo2.restapi.config;

import com.manu.manudomo2.restapi.data.entities.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    //Propriétés
    private static final Properties prop = new Properties();

    public static final DecimalFormat df = new DecimalFormat("#.0");
    public static final DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();

    static {
        try {
            prop.load(AppConfig.class.getClassLoader().getResourceAsStream("application.properties"));
            dfs.setDecimalSeparator('.');
            df.setDecimalFormatSymbols(dfs);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }

    @Autowired
    private Environment env;

    /**
     * Initialize dataSource
     *
     * @return DataSource
     */
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        return dataSource;
    }

    /**
     * Initialize hibernate properties
     *
     * @return Properties
     */
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("db.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("db.hibernate.showsql"));
        properties.put("hibernate.default_schema", env.getRequiredProperty("db.hibernate.schema"));
        properties.put("hibernate.id.new_generator_mappings", false);
        return properties;
    }

    /**
     * Initialize SessionFactory
     *
     * @return LocalSessionFactoryBean
     */
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.manu.manudomo2.restapi.data.entities");
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    /**
     * Initialize Transaction Manager
     *
     * @param sessionFactory
     * @return HibernateTransactionManager
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public SecurityConfigWrapper securityConfigWrapper() {
        return new SecurityConfigWrapper(User.class);
    }

    public static Properties prop() {
        return prop;
    }

}
