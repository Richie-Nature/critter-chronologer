package com.udacity.jdnd.course3.critter.user.employee;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.User;
import com.udacity.jdnd.course3.critter.user.skill.Skill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
public class Employee extends User {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "skill", cascade = {CascadeType.ALL})
    private Set<Skill> skills;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @ElementCollection
    private Set<DayOfWeek> daysAvailable;

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
