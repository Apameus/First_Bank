package org.first_bank.serialization;
import org.first_bank.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeSerializerTest extends RandomModelGenerator{

    EmployeeSerializer serializer = new EmployeeSerializer();

    @Test
    @DisplayName("Serialize an employee")
    void serializeAnEmployee(){
        Employee employee = RandomModelGenerator.crateRandomEmployee();
        String expectedLine = "%s %s %s %s".formatted(employee.username(), employee.password(),
                                                        employee.fullName(),employee.phoneNumber());
        Assertions.assertEquals(expectedLine, serializer.serialize(employee));
    }

    @Test
    @DisplayName("Parse an employee")
    void parseAnEmployee(){
        String line = "%s %s %s %s".formatted("Admin", "Admin", "EmployeeA A", 6934);
        Employee employee = serializer.parse(line);
        Assertions.assertEquals("Admin", employee.username());
        Assertions.assertEquals("Admin", employee.password());
        Assertions.assertEquals("EmployeeA A", employee.fullName());
        Assertions.assertEquals(6934, employee.phoneNumber());
    }

}
