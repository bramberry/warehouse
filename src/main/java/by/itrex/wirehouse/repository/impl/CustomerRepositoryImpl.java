package by.itrex.wirehouse.repository.impl;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  private static Map<Long, Customer> customers = new HashMap<>();
  private AtomicLong atomicLong = new AtomicLong();

  @Override
  public Customer save(Customer customer) {
    Long id = atomicLong.incrementAndGet();
    customer.setId(id);
    customers.put(id, customer);
    return customer;
  }

  @Override
  public Customer getById(Long id) {
    return customers.get(id);
  }
}
