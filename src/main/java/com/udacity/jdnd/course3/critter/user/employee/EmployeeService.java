package com.udacity.jdnd.course3.critter.user.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class EmployeeService {
   @Autowired
   private EmployeeRepository employeeRepository;

   public Employee create(Employee employee) {
       return employeeRepository.save(employee);
   }

//   public List<Employee> findByServiceAndTime(EmployeeSkill skill, DayOfWeek dayOfWeek) {
//       return employeeRepository.findAllBySkillAndAvailability(skill, dayOfWeek);
//   }

   public List<Employee> findAll() {
       return (List<Employee>) employeeRepository.findAll();
   }

   public Employee findById(Long id) {
       return employeeRepository.findById(id).
               orElseThrow(UnsupportedOperationException::new);
   }

   public Employee updateAvailability(Set<DayOfWeek> days, Long id) {
       return employeeRepository.findById(id).map(employee -> {
                 employee.setDaysAvailable(days);
                 return employeeRepository.save(employee);
               })
               .orElseThrow(UnsupportedOperationException::new);//todo custom exception
   }

   public void delete(Long id) {
       employeeRepository.findById(id).map(employee -> {
           employeeRepository.delete(employee);
           return employee;
       }).orElseThrow(UnsupportedOperationException::new);
   }
}
