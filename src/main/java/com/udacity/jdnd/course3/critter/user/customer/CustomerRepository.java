package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByPetDistinctContaining(Pet pet);
}
