package org.first_bank.serialization;

import org.first_bank.model.Employee;
import org.first_bank.services.Serializer;

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
        String fullName = values[2] + " " + values[3];
        long phone = Long.parseLong(values[4]);
        return new Employee(values[0], values[1], fullName, phone);
    }
}
