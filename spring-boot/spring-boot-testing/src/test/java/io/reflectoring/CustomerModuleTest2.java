package io.reflectoring;

import io.reflectoring.booking.business.BookingService;
import io.reflectoring.booking.data.BookingRepository;
import io.reflectoring.booking.web.BookingController;
import io.reflectoring.customer.business.CustomerService;
import io.reflectoring.customer.data.Customer;
import io.reflectoring.customer.data.CustomerRepository;
import io.reflectoring.customer.web.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class CustomerModuleTest2 {

  @Autowired(required = false)
  private BookingController bookingController;
  @Autowired(required = false)
  private BookingService bookingService;
  @Autowired(required = false)
  private BookingRepository bookingRepository;

  @Autowired
  private CustomerController customerController;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private WebApplicationContext applicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    this.mockMvc = MockMvcBuilders
            .webAppContextSetup(applicationContext)
            .build();
    System.out.println("xxxxx======");
    Arrays.stream(applicationContext.getBeanDefinitionNames())
            .map(name -> applicationContext.getBean(name).getClass().getName())
            .sorted()
            .forEach(System.out::println);
    System.out.println("yyyyy======");
  }

  @BeforeEach
  void printApplicationContext() {

  }
  @Test
  void onlyCustomerModuleIsLoaded() {
    assertThat(customerController).isNotNull();
    assertThat(customerService).isNotNull();
    assertThat(customerRepository).isNotNull();
    assertThat(bookingController).isNull();
    assertThat(bookingService).isNull();
    assertThat(bookingRepository).isNull();
  }

  @Test
  public void should_good_save_customer() throws Exception {
    Object o = this.mockMvc.perform(post("/save").param("name", "c1")).andReturn().getResponse();
    System.out.println("o : " + o);
    List<Customer> customerList = customerRepository.findByName("c1");
    customerList.stream().forEach(e -> {
      System.out.println("name : " + e.getName());
    });
  }
}