package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import employee.Employee;

class TestEmployee {

	@BeforeAll
	public static void info() {
		System.out.println("Employee version: " + Employee.version());
	}
	
	@Test
	void testNoBonus() {
		int yearOfHiring = 2022;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(0, employee.bonus(yearOfCalculation));

	}

}
