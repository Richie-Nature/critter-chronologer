package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.employee.Employee;
import com.udacity.jdnd.course3.critter.user.employee.EmployeeSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    @ManyToMany
//    @JoinTable(name = "employee_schedule",
//            joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    )
    private List<Employee> employee;

    @ManyToMany
//    @JoinTable(name = "pet_schedule",
//            joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id")
//    )
    private List<Pet> pet;

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
