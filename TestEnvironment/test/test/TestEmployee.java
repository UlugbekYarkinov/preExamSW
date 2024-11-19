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

	//Test Case 2 & 3
	@Test
	void test50Bonus() {
		int yearOfCalculation = 2024;
		int salary = 1000;
		
		Employee employee1 = new Employee(2020, salary);
		Employee employee2 = new Employee(2019, salary);
		
		assertEquals(salary * 0.50, employee1.bonus(yearOfCalculation));
		assertEquals(salary * 0.50, employee2.bonus(yearOfCalculation));
	}

	//Test Case 4 & 5
	@Test
	void test75Bonus() {
		int yearOfCalculation = 2024;
		int salary = 1000;
		
		Employee employee1 = new Employee(2018, salary);
		Employee employee2 = new Employee(2016, salary);
		
		assertEquals(salary * 0.75, employee1.bonus(yearOfCalculation));
		assertEquals(salary * 0.75, employee2.bonus(yearOfCalculation));
	}

	//Test Case 6
	@Test
	void test100Bonus() {
		int yearOfHiring = 2015;
		int salary = 1000;
		
		int yearOfCalculation = 2024;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		assertEquals(salary, employee.bonus(yearOfCalculation));

	}

	//Test Case 7
	@Test
	void testInvalidSalary() {
		int yearOfHiring = 2010;
		int salary = -1000;
				
		RuntimeException exception = assertThrows(RuntimeException.class, () -> new Employee(yearOfHiring, salary));
		assertEquals("Negative salary.", exception.getMessage());
	}
	
	//Test Case 8
	@Test
	void testInvalidYearOfHiring() {
		int yearOfHiring = 1989;
		int salary = 1000;
				
		RuntimeException exception = assertThrows(RuntimeException.class, () -> new Employee(yearOfHiring, salary));
		assertEquals("Wrong entry year.", exception.getMessage());
	}
	
	//Test Case 9
	@Test
	void testInvalidYearOfCalculation() {
		int yearOfHiring = 2024;
		int salary = 1000;
		
		int yearOfCalculation = 2021;
		
		Employee employee = new Employee(yearOfHiring, salary);
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> employee.bonus(yearOfCalculation));
		assertEquals("Wrong calculation year.", exception.getMessage());
	}

}
