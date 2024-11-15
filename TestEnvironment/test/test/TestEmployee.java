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

	//Test Case 1
	@Test
	void testNoBonus() {
		int yearOfHiring = 2022;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(0, employee.bonus(yearOfCalculation));

	}

	//Test Case 2
	@Test
	void test50Bonus() {
		int yearOfHiring = 2021;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(salary * 0.50, employee.bonus(yearOfCalculation));

	}

	//Test Case 3
	@Test
	void test75Bonus() {
		int yearOfHiring = 2018;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(salary * 0.75, employee.bonus(yearOfCalculation));

	}

	//Test Case 4
	@Test
	void test100Bonus() {
		int yearOfHiring = 2010;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(salary, employee.bonus(yearOfCalculation));

	}

	//Test Case 5
	@Test
	void testInvalidSalary() {
		int yearOfHiring = 2010;
		int salary = -1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertThrows(RuntimeException.class, () -> employee.bonus(yearOfCalculation));

	}
	
	//Test Case 6
	@Test
	void testInvalidYearOfHiring() {
		int yearOfHiring = 1989;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertThrows(RuntimeException.class, () -> employee.bonus(yearOfCalculation));

	}
	
	//Test Case 7
	@Test
	void testInvalidYearOfCalculation() {
		int yearOfHiring = 2024;
		int salary = 1000;
		
		int yearOfCalculation = 2021;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertThrows(Exception.class, () -> employee.bonus(yearOfCalculation));

	}
	
	//Test Case 8
	@Test
	void testNullInputs() {
		Integer yearOfHiring = null;
		
		Integer salary = null;
		
		Integer yearOfCalculation = null;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertThrows(NullPointerException.class, () -> employee.bonus(yearOfCalculation));

	}

}
