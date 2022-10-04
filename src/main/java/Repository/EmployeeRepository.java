package Repository;

import model.Employee;
import services.Repository;

import java.util.List;

public class EmployeeRepository implements Repository<Employee> {
    private final List<Employee> employeeList;

    public EmployeeRepository(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @Override
    public void save(Employee employee){
        employeeList.add(employee);
    }
    @Override
    public void delete(Employee employee){
        employeeList.remove(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee findEmployeeByUsername(String username){
        for (Employee employee : employeeList){
            if (employee.username().equals(username)){
                return employee;
            }
        }
        return null;
    }
}
