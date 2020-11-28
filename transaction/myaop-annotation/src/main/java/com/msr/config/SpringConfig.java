package com.msr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.msr")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("classpath:JdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfig {

}
