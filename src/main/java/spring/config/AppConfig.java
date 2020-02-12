package spring.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import spring.model.User;

@Configuration
@ComponentScan(basePackages = {
        "spring.dao",
        "spring.service"
})
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_train?serverTimezone=EET");
        dataSource.setUsername("newUserDB");
        dataSource.setPassword("1234user");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.setAnnotatedClasses(User.class);
        return sessionFactoryBean;
    }
}
