package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByPet(Long petId) {
        return customerRepository.findByPetId(petId);
    }

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer find(Long id) {
        return customerRepository.findById(id).orElseThrow(UnsupportedOperationException::new);
    }

    public Customer addPets(List<Pet> pets, Customer customer) {
        return customerRepository.findById(customer.getId())
                .map(c -> {
                    c.setPets(pets);
                    return customerRepository.save(c);
                }).orElseThrow(UnsupportedOperationException::new); //todo custom exception
    }

    public void delete(Long id) {
        customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return customer;
        }).orElseThrow(UnsupportedOperationException::new);//todo custom exception
    }
}
