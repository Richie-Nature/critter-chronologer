package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.customer.Customer;
import com.udacity.jdnd.course3.critter.user.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> findByEmployee(Employee employee) {
        return scheduleRepository.findAllByEmployeeContaining(employee);
    }

    public List<Schedule> findByPet(Pet pet) {
        return scheduleRepository.findAllByPetContaining(pet);
    }

//    public List<Schedule> findByCustomer(Customer customer) {
//        return scheduleRepository.findAllByCustomerContaining(customer);
//    }

    public Schedule find(Long id) {
        return scheduleRepository.findById(id).
                orElseThrow(UnsupportedOperationException::new);
    }

    public List<Schedule> findAll() {
        return (List<Schedule>) scheduleRepository.findAll();
    }
}
