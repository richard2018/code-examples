package io.reflectoring.customer;

import io.reflectoring.customer.business.CustomerService;
import io.reflectoring.customer.data.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CustomerConfiguration {

  @Bean
  public CustomerService customerService(CustomerRepository customerRepository){
    return new CustomerService(customerRepository);
  }
}
