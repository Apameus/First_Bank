package org.first_bank.serialization;

import org.first_bank.model.CreditCard;
import org.first_bank.model.Employee;

import java.util.Random;

public class RandomModelGenerator {
    private static final Random random = new Random();

    // EMPLOYEE
    public static Employee crateRandomEmployee(){
        String username = randomString();
        String password = randomString();
        String fullName = randomFullName();
        long phoneNumber = random.nextLong(0, 999999999);
        return new Employee(username, password, fullName, phoneNumber);
    }

    private static String randomFullName() {
        String firstName = randomString().replace(" ", "_");
        String lastName = randomString().replace(" ", "_");
        return firstName + " " + lastName;
    }

    private static String randomString(){
        byte[] bytes = new byte[random.nextInt(50,100)];
        random.nextBytes(bytes);
        return new String(bytes);
    }

    // CREDIT_CARD
    public static CreditCard createRandomCreditCard(){
        int number = random.nextInt(1111_1111, 9999_9999);
        int pin = random.nextInt(1111, 9999);
        double balance = random.nextDouble();
        Boolean active = random.nextBoolean();
        return new CreditCard(Integer.toString(number), Integer.toString(pin), balance, active);
    }

}
