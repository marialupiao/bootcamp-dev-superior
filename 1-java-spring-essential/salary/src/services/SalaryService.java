package services;

import entities.Employee;

public class SalaryService {

    PensionService pensionService = new PensionService();
    TaxService taxService = new TaxService();

    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }
    public double netSalary(Employee employee) {
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());
    }

}
