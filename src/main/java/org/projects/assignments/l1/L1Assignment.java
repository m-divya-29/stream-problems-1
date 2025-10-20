package org.projects.assignments.l1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.projects.assignments.models.Employee;

public class L1Assignment {

	/**
	 * 1. Sum of All Numbers in a List Example: Given a list of integers, calculate
	 * the sum of all numbers. Example: Numbers: [1, 2, 3, 4, 5] Output: 15
	 * Explanation: 1 + 2 + 3 + 4 + 5 = 15
	 */
	public int sumOfNumbers(List<Integer> numbers) {
		// write code here using Java Streams API

		int sum = numbers.stream().mapToInt(Integer::valueOf).sum();

		int sumByReduce = numbers.stream().reduce(0, (a, b) -> {
			return a + b;
		}).intValue();

		return sumByReduce;
	}

	/**
	 * 2. Find Maximum Number in a List
	 * 
	 * Example: Given a list of integers, find the maximum number.
	 * 
	 * Example: Numbers: [10, 5, 20, 8, 15]
	 * 
	 * Output: 20 Explanation: 20 is the largest number in the list.
	 */
	public int findMaxNumber(List<Integer> numbers) {
		// write code here using Java Streams API

		OptionalInt max = numbers.stream().mapToInt(Integer::valueOf).max();

		return max.orElse(-1);
	}

	/**
	 * 3. Filter Even Numbers from a List
	 * 
	 * Example: Given a list of integers, return only the even numbers.
	 * 
	 * Example: Numbers: [1, 2, 3, 4, 5, 6, 7, 8]
	 * 
	 * Output: [2, 4, 6, 8] Explanation: Only numbers divisible by 2 are returned.
	 */
	public List<Integer> filterEvenNumbers(List<Integer> numbers) {
		// write code here using Java Streams API

		List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).toList();

		return evenNumbers;
	}

	/**
	 * 4. Convert List of Strings to Uppercase
	 * 
	 * Example: Given a list of strings, convert all strings to uppercase.
	 * 
	 * Example: Strings: ["apple", "banana", "cherry"]
	 * 
	 * Output: ["APPLE", "BANANA", "CHERRY"]
	 * 
	 * Explanation: Each string is transformed to uppercase using map operation.
	 */
	public List<String> convertToUppercase(List<String> strings) {
		// write code here using Java Streams API

		List<String> uppercase = strings.stream() //
				.map(String::toUpperCase).toList();

		return uppercase;
	}

	/**
	 * 5. Remove Duplicate Elements from a List
	 * 
	 * Example: Given a list of integers, remove all duplicate elements.
	 * 
	 * Example: Numbers: [1, 2, 2, 3, 4, 4, 5]
	 * 
	 * Output: [1, 2, 3, 4, 5] Explanation: distinct() removes duplicate elements
	 * keeping only unique values.
	 */
	public List<Integer> removeDuplicates(List<Integer> numbers) {
		// write code here using Java Streams API

		// simpler version
		// numbers.stream().distinct().toList();

		return numbers.stream().mapToInt(Integer::valueOf).distinct().boxed().toList();
	}

	/**
	 * 6. Check if All Numbers are Positive
	 * 
	 * Example: Given a list of integers, check if all numbers are positive.
	 * 
	 * Example: Numbers: [1, 2, 3, 4, 5]
	 * 
	 * Output: true
	 * 
	 * Explanation: All numbers in the list are greater than 0.
	 */
	public boolean areAllPositive(List<Integer> numbers) {
		// write code here using Java Streams API

		boolean allMatches = numbers.stream().allMatch(num -> num > 0);

		return allMatches;

	}

	/**
	 * 7. Count Strings Starting with a Specific Letter
	 * 
	 * Example: Given a list of strings, count how many start with the letter 'A'.
	 * 
	 * Example: Strings: ["Apple", "Banana", "Apricot", "Cherry", "Avocado"]
	 * 
	 * Output: 3
	 * 
	 * Explanation: "Apple", "Apricot", and "Avocado" start with 'A'.
	 */
	public long countStringsStartingWith(List<String> strings, char letter) {
		// write code here using Java Streams API

		long count = strings.stream().filter//
		(str -> str.charAt(0) == letter)//
				.count();

		return count;
	}

	/**
	 * 8. Square Each Number and Collect to List
	 * 
	 * Example: Given a list of integers, square each number.
	 * 
	 * Example: Numbers: [1, 2, 3, 4, 5]
	 * 
	 * Output: [1, 4, 9, 16, 25]
	 * 
	 * Explanation: Each number is multiplied by itself (n * n).
	 */
	public List<Integer> squareNumbers(List<Integer> numbers) {
		// write code here using Java Streams API
		return numbers.stream().map(num -> num * num).toList();
	}

	/**
	 * 9. Skip First N Elements and Collect Remaining
	 * 
	 * Example: Given a list of integers, skip the first 3 elements and return the
	 * rest.
	 * 
	 * Example: Numbers: [1, 2, 3, 4, 5, 6, 7, 8]
	 * 
	 * Output: [4, 5, 6, 7, 8]
	 * 
	 * Explanation: skip(3) skips the first 3 elements and returns remaining
	 * elements.
	 */
	public List<Integer> skipFirstN(List<Integer> numbers, int n) {
		// write code here using Java Streams API
		return numbers.stream()//
				.skip(n)//
				.toList();
	}

	/**
	 * 10. Join Strings with a Delimiter
	 * 
	 * Example: Given a list of strings, join them with a comma separator.
	 * 
	 * Example: Strings: ["Java", "Python", "JavaScript", "C++"]
	 * 
	 * Output: "Java, Python, JavaScript, C++"
	 * 
	 */
	public String joinStrings(List<String> strings, String delimiter) {
		// write code here using Java Streams API

		String joined = strings.stream().collect(Collectors.joining(delimiter));

		Optional<String> reduce = strings.stream().reduce((a, b) -> String.join(delimiter, a, b));

		return reduce.orElse("");
	}

	/**
	 * 11. Find First Element Greater Than N
	 * 
	 * Example: Given a list of integers, find the first number greater than 10.
	 * 
	 * Example: Numbers: [5, 8, 12, 3, 15, 7] Output: 12
	 * 
	 * Explanation: 12 is the first number in the list that is greater than 10.
	 */
	public Integer findFirstGreaterThan(List<Integer> numbers, int threshold) {
		// write code here using Java Streams API

		Optional<Integer> possibleFirst = numbers.stream().filter(num -> num > threshold).findFirst();

		// TIP: If you want the 3rd item in the list that is greater than threshold
		// Optional<Integer> possibleFirst = numbers.stream().filter(num -> num >
		// threshold).skip(3).findFirst();

		return possibleFirst.orElse(-1);
	}

	/**
	 * 12. Sort Strings by Length
	 * 
	 * Example: Given a list of strings, sort them by their length in ascending
	 * order.
	 * 
	 * Example: Strings: ["apple", "kiwi", "banana", "pear"]
	 * 
	 * Output: ["kiwi", "pear", "apple", "banana"] Explanation: Strings are sorted
	 * by length: kiwi(4), pear(4), apple(5), banana(6).
	 */
	public List<String> sortByLength(List<String> strings) {
		// write code here using Java Streams API

		List<String> result = strings.stream() //
				.sorted(Comparator.comparing(String::length))//
				.toList();

		return result;
	}

	/**
	 * 13. Flatten Nested List
	 * 
	 * Example: Given a list of lists, flatten it into a single list.
	 * 
	 * Example: Nested Lists: [[1, 2], [3, 4], [5, 6, 7]] Output: [1, 2, 3, 4, 5, 6,
	 * 7]
	 * 
	 * Explanation: flatMap() flattens all nested lists into one single list.
	 */
	public List<Integer> flattenList(List<List<Integer>> nestedLists) {
		// write code here using Java Streams API

		List<Integer> result = nestedLists.stream().flatMap(aList -> aList.stream()).toList();

		// naive solution
//		List<Integer> anotherResult = new ArrayList<>();
//		for(List<Integer> aList : nestedLists) {
//			for(Integer anInteger : aList) {
//				anotherResult.add(anInteger);
//			}
//		}

		return result;
	}

	/**
	 * 14. Find Average of Numbers
	 * 
	 * Example: Given a list of integers, calculate the average.
	 * 
	 * Example: Numbers: [10, 20, 30, 40, 50]
	 * 
	 * Output: 30.0 Explanation: (10 + 20 + 30 + 40 + 50) / 5 = 30.0
	 */
	public double calculateAverage(List<Integer> numbers) {
		// write code here using Java Streams API

		OptionalDouble avg = numbers.stream().mapToInt(Integer::valueOf).average();

		return avg.orElse(-1);
	}

	/**
	 * 15. Convert the List into Even and Odd Number lists
	 * 
	 * Example: Given a list of integers, partition them into even and odd.
	 * 
	 * Example: Numbers: [1, 2, 3, 4, 5, 6]
	 * 
	 * Output: {false=[1, 3, 5], true=[2, 4, 6]}
	 * 
	 */
	public Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> numbers) {
		// write code here using Java Streams API

		Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

		return result;
	}

	/**
	 * 16. Find Second Smallest Number
	 * 
	 * Example: Given a list of integers, find the second smallest number.
	 * 
	 * Example: Numbers: [10, 5, 20, 8, 15, 3] Output: 5
	 * 
	 * Explanation: After sorting: [3, 5, 8, 10, 15, 20], the second element is 5.
	 */
	public Integer findSecondSmallest(List<Integer> numbers) {
		// write code here using Java Streams API

		Optional<Integer> result = numbers.stream().sorted().skip(1).findFirst();

		return result.orElse(-1);
	}

	/**
	 * 17. Convert String Array to Map with Length
	 * 
	 * Example: Given a list of strings, create a map with string as key and its
	 * length as value.
	 * 
	 * Example: Strings: ["apple", "banana", "kiwi"]
	 * 
	 * Output: {apple=5, banana=6, kiwi=4}
	 * 
	 */
	public Map<String, Integer> stringToLengthMap(List<String> strings) {
		// write code here using Java Streams API

		Map<String, Integer> result = strings.stream() //
				.collect(//
						Collectors.toMap(String::valueOf, String::length)//
				);

		return result;
	}

	/**
	 * 18. Limit Stream to First N Elements
	 * 
	 * Example: Given a list of integers, return only the first 3 elements.
	 * 
	 * Example: Numbers: [10, 20, 30, 40, 50, 60] Output: [10, 20, 30]
	 * 
	 */
	public List<Integer> getFirstN(List<Integer> numbers, int n) {
		// write code here using Java Streams API

		List<Integer> result = numbers.stream().limit(n).toList();

		return result;
	}

	/**
	 * 19. Check if List Contains a Specific Element
	 * 
	 * Example: Given a list of strings, check if it contains "Java". Example:
	 * Strings: ["Python", "Java", "C++", "JavaScript"]
	 * 
	 * Output: true
	 */
	public boolean containsElement(List<String> strings, String element) {
		// write code here using Java Streams API

		// naive solution
		// strings.contains("Java");

		boolean result = strings.stream().anyMatch(str -> str.equals(element));

		return result;

	}

	/**
	 * 20. Group Strings by Their First Character
	 * 
	 * Example: Given a list of strings, group them by their first character.
	 * 
	 * Example: Strings: ["apple", "banana", "apricot", "cherry", "avocado"]
	 * 
	 * Output: {a=[apple, apricot, avocado],
	 */
	public Map<Character, List<String>> groupByFirstChar(List<String> strings) {
		// write code here using Java Streams API

		Map<Character, List<String>> result = strings.stream()//
				.collect(Collectors.groupingBy(str -> str.charAt(0)));

//		Map<Character, String> result2 = strings.stream()
//				.collect(Collectors.toMap(str -> str.charAt(0), String::valueOf, (a, b) -> b));
//
//		System.out.println(result2);

		return result;
	}

	/**
	 * 21. Filter Employees by Department
	 * 
	 * Example: Given a list of employees, filter all employees from the "IT"
	 * department.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000) ]
	 * 
	 * Output: [Employee("Bob", "IT", 80000), Employee("David", "IT", 90000)]
	 * Explanation: Only employees from IT department are returned.
	 */
	public List<Employee> filterByDepartment(List<Employee> employees, String department) {
		// write code here using Java Streams API

		List<Employee> filteredEmployees = employees //
				.stream() //
				.filter(emp -> emp.department().equals(department)) //
				.toList();

		return filteredEmployees;
	}

}
