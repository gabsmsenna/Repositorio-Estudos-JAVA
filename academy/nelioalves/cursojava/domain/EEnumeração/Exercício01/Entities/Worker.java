package academy.nelioalves.cursojava.domain.Enumeração.Exercício01.Entities;

import academy.nelioalves.cursojava.domain.Enumeração.Exercício01.Enum.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<Hour_Contract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(Hour_Contract contract) {
        contracts.add(contract);
    }

    public void removeContract (Hour_Contract contract) {
        contracts.remove(contract);
    }

    public double income ( int year, int month) {
        double sum = baseSalary;
        Calendar calendar = Calendar.getInstance();

        for (Hour_Contract contract : contracts) {
            calendar.setTime(contract.getDate());

            int contract_year = calendar.get(Calendar.YEAR);
            int contract_month = 1 + calendar.get(Calendar.MONTH);

            if (year == contract_year && month == contract_month) {
                sum += contract.totalValue();
            }
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Hour_Contract> getContracts() {
        return contracts;
    }
}
