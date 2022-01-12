package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByPet(Pet pet) {
        return customerRepository.findByPetDistinctContaining(pet);
    }

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer find(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Customer customer = optionalCustomer.orElseThrow(UnsupportedOperationException::new);
        return customer;
    }
}
