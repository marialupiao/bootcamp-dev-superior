package com.devsuperior.services;

import com.devsuperior.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    PensionService pensionService = new PensionService();
    @Autowired
    TaxService taxService = new TaxService();

    public double netSalary(Employee employee) {
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());
    }

}
