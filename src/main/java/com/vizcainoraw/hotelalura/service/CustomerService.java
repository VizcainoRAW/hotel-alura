package com.vizcainoraw.hotelalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.dto.costumer.CustomerDto;
import com.vizcainoraw.hotelalura.dto.costumer.CustomerMapper;
import com.vizcainoraw.hotelalura.model.Customer;
import com.vizcainoraw.hotelalura.repository.CustomerRepository;

import lombok.NonNull;

@Service
public class CustomerService {

  private final CustomerRepository repository;
  private final CustomerMapper mapper;

  public CustomerService(CustomerRepository repository, CustomerMapper mapper){
      this.repository = repository;
      this.mapper = mapper;
  }

  public List<CustomerDto> getAllCustomers() {
      List<Customer> customers = repository.findAll();
      return customers.stream()
                    .map(mapper)
                    .collect(Collectors.toList());
  }

  public CustomerDto create(@NonNull Customer customer){
      return mapper.apply(repository.save(customer));
  }

  public CustomerDto getCustomer(@NonNull Integer id){
      return repository.findById(id)
          .map(mapper)
          .orElseThrow(() -> new ResourceNotFoundException(
              "costumer with id [%s] not found".formatted(id)));
  }

  public CustomerDto updateCustomer(@NonNull Integer id, Customer updateCustomer){
      Customer customer = repository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException(
              "costumer with id [%s] not found".formatted(id)));

      customer.setEmail(updateCustomer.getEmail());
      customer.setFirstName(updateCustomer.getFirstName());
      customer.setLastName(updateCustomer.getLastName());
      customer.setPhoneNumber(updateCustomer.getPhoneNumber());

      return mapper.apply(repository.save(customer));
  }

  public boolean deleteCustomer(@NonNull Integer id){
      if (repository.existsById(id)) {
          repository.deleteById(id);
          return !repository.existsById(id);
      }else{
          return false;
      }
  }
}
