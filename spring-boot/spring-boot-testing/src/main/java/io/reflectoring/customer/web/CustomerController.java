package io.reflectoring.customer.web;

import io.reflectoring.customer.business.CustomerService;
import io.reflectoring.customer.data.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/customer")
  public String hello() {
    return "hello";
  }

  @PostMapping("/save")
  public Customer save(String name) {
    Customer customer = new Customer(1L, name);
    return customerService.save(customer);
  }

  @PostMapping("/getById")
  public Customer getById(Long id) {
    return customerService.getById(id);
  }
}
