package com.abc;

import java.util.Scanner;

import com.abc.modal.Employee;
import com.abc.service.CredentialService;

public class EmployeeManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int departmentId;
		final String company = "abc";
		final String[] departments = { "tech", "admin", "hr", "legal" };
		Scanner sc = new Scanner(System.in);

		System.out.println("***************Welcome to Password Management Systems ************\n");
		System.out.println("Please enter your first Name\n");
		String firstName = sc.nextLine();
		System.out.println("Enter enter your last Name\n");
		String lastName = sc.nextLine();
		System.out.println("Enter your department from below list.\n" + "1. Technical.\n" + "2. Admin.\n"
				+ "3. Human Resource.\n" + "4. Legal .\n" + "--> Enter 0 to Exit.\n");
		System.out.println();
		departmentId = sc.nextInt();
		if (departmentId < 1 || departmentId > 4) {
			System.out.println("\nPlease enter valid option");
		} else {
			Employee employee = new Employee(firstName, lastName);
			CredentialService credentialService = new CredentialService();
			credentialService.showCredentials(employee, company, departments[departmentId - 1]);
		}
		System.out.println("\nHave a nice day!!!");
		sc.close();
	}
}
