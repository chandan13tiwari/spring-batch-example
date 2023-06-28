package com.poc.springbatch.component;

import com.poc.springbatch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee employee) throws Exception {
        long salary = employee.getSalary();

        if(salary >= 50000) {
            return employee;
        }

        return null;
    }
}
