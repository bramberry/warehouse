package by.itrex.wirehouse.repository.impl;

import by.itrex.wirehouse.dto.Customer;
import by.itrex.wirehouse.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  private static final Map<Long, Customer> CUSTOMERS = new HashMap<>();
  private final AtomicLong atomicLong = new AtomicLong();

  @Override
  public Customer save(Customer customer) {
    Long id = atomicLong.incrementAndGet();
    customer.setId(id);
    CUSTOMERS.put(id, customer);
    return customer;
  }

  @Override
  public Customer getById(Long id) {
    return CUSTOMERS.get(id);
  }
}
