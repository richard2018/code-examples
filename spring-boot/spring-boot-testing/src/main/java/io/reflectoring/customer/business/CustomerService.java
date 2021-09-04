package io.reflectoring.customer.business;

import io.reflectoring.customer.data.Customer;
import io.reflectoring.customer.data.CustomerRepository;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).get();
    }
}
