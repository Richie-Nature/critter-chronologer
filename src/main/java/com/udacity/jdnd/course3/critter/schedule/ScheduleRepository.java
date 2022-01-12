package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.customer.Customer;
import com.udacity.jdnd.course3.critter.user.employee.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findAllByEmployeeContaining(Employee employee);
    List<Schedule> findAllByPetContaining(Pet pet);
    List<Schedule> findAllByCustomerContaining(Customer customer);
}
