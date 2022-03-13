package com.abc.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.abc.modal.Employee;

public class CredentialService {

	public String generateEmailAddress(Employee employee, String company, String department) {
		String email = (new StringBuilder()).append(employee.getFirstName().toLowerCase())
				.append(employee.getLastName().toLowerCase()).append("@").append(department).append(".").append(company)
				.append(".com").toString();
		return email;
	}

	public void showCredentials(Employee employee, String company, String department) {
		String password = generateSecurePassword();
		String gmailAddress = generateEmailAddress(employee, company, department);
		System.out.println("\nDear " + employee.getFirstName() + " your generated credentials are as follows ");
		System.out.println("\nEmail        ---> " + gmailAddress);
		System.out.println("\nPassword     ---> " + password);
	}

	public static String generateSecurePassword() {

		// generate a string having 2 numbers, 2 upper case letters, and 2 lower case
		// letters , 2 special chars
		Stream<Character> demoPassword = Stream.concat(getRandomNumbers(2), Stream.concat(getRandomAlphabets(2, false),
				Stream.concat(getRandomAlphabets(2, true), getRandomSpecialChars(2))));

		List<Character> listOfChar = demoPassword.collect(Collectors.toList());

		String password = listOfChar.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();

		return password;
	}

	// create getRandomSpecialChars() method that returns a Stream of special chars
	// of the specified length
	public static Stream<Character> getRandomSpecialChars(int length) {

		Stream<Character> specialCharsStream;
		Random random = new SecureRandom();
		// 33-45 - decimal values of special characters
		IntStream specialChars = random.ints(length, 33, 45);
		specialCharsStream = specialChars.mapToObj(data -> (char) data);
		return specialCharsStream;
	}

	// create getRandomNumbers() method that returns a Stream of numbers of the
	// specified length
	public static Stream<Character> getRandomNumbers(int length) {
		Stream<Character> numberStream;
		Random random = new SecureRandom();
		// 48-57 - decimal values of numbers(0-9)
		IntStream numberIntStream = random.ints(length, 48, 57);
		numberStream = numberIntStream.mapToObj(data -> (char) data);
		return numberStream;
	}

	// returns either a stream of upper case chars or stream of lower case chars
	// based on boolean value
	public static Stream<Character> getRandomAlphabets(int length, boolean check) {

		Stream<Character> lowerUpperStream;

		if (check == true) {
			Random random = new SecureRandom();
			IntStream lCaseStream = random.ints(length, 'a', 'z');
			lowerUpperStream = lCaseStream.mapToObj(data -> (char) data);
		} else {
			Random random = new SecureRandom();
			IntStream uCaseStream = random.ints(length, 'A', 'Z');
			lowerUpperStream = uCaseStream.mapToObj(data -> (char) data);
		}
		return lowerUpperStream;
	}
}
