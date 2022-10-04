package Serialization;

import model.Employee;
import services.Serializer;

public class EmployeeSerializer implements Serializer<Employee> {

    //{username} {password} {fullName} {phoneNumber}

    @Override
    public String serialize(Employee employee) {
        return "%s %s %s %s".formatted(employee.username(), employee.password(),
                                        employee.fullName(), employee.phoneNumber());
    }

    @Override
    public Employee parse(String line) {
        String[] values = line.split(" ");
        long phone = Long.parseLong(values[3]);
        return new Employee(values[0], values[1], values[2], phone);
    }
}
