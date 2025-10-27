package org.projects.assignments.l2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.projects.assignments.models.Employee;
import org.projects.assignments.models.EmployeeCustomView;

public class L2Assignment {
	/*
	 * 1. Find Employees with Nth Highest unique Salary using Java Streams API.
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000) ] N = 3 Output: 70000
	 * 
	 * If there is no Nth highest unique salary, return -1.
	 */
	public Double findEmployeesWithNthHighestUniqueSalary(Employee[] employees, int N) {

		// write code here using Java Streams API
		Optional<Double> nthLargestSalary = Arrays.stream(employees)//
				.map(Employee::salary)//
				.distinct()//
				.sorted(Comparator.reverseOrder())//
				.skip(N - 1)//
				.findFirst();

		return nthLargestSalary.orElse(-1.0);
	}

	/*
	 * 2. Convert List of Objects to Map with Custom Key-Value Pairs using Java
	 * Streams API.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000) ]
	 * 
	 * Output: { "HR": ["Alice", "Charlie"], "IT": ["Bob", "David"], "Finance":
	 * ["Eve"]}
	 */
	public Map<String, List<String>> convertListOfObjectsToMap(Employee[] employees) {
		// write code here using Java Streams API

		Map<String, List<String>> collect = Arrays //
				.stream(employees) //
				.collect(//
						Collectors.groupingBy( //
								Employee::department //
								, Collectors.mapping(Employee::name, Collectors.toList()) //
						));

		return collect;
	}

	/*
	 * 3. 3. Find All Duplicate Elements in a List using Java Streams API.
	 * 
	 * Example: Input: [1, 2, 3, 4, 5, 3, 2, 1]
	 * 
	 * Output: [1, 2, 3]
	 */
	public List<Integer> findAllDuplicateElementsInList(List<Integer> numbers) {
		// write code here using Java Streams API

		// This is O(N^2) soln but it uses only streams.
		// So, it is the expected soln only in the perspective of Streams
		List<Integer> duplicates = numbers.stream().filter(num -> Collections.frequency(numbers, num) > 1)//
				.distinct()//
				.toList();

		return duplicates;
	}

	/*
	 * 4. Group by Multiple Fields using Java Streams API.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000) Employee("Frank", "IT", 80000) ]
	 * 
	 * Output: { "HR": { 60000: ["Alice"], 70000: ["Charlie"] }, "IT": { 80000:
	 * ["Bob", "Frank"], 90000: ["David"] }, "Finance": { 80000: ["Eve"] } }
	 * 
	 * 
	 * Explanation: The outer map groups employees by their department, and the
	 * inner map groups them by their salary within each department.
	 * 
	 */

	public Map<String, Map<Double, List<String>>> groupByMultipleFields(Employee[] employees) {
		// write code here using Java Streams API

		Map<String, Map<Double, List<String>>> collect = Arrays.stream(employees)
				.collect(Collectors.groupingBy(Employee::department, Collectors.mapping(e -> e, Collectors
						.groupingBy(Employee::salary, Collectors.mapping(Employee::name, Collectors.toList())))));

		return collect;
	}

	/*
	 * 5. Find Longest String in Each Group using Java Streams API.
	 * 
	 * Example: Input: ["apple", "banana", "pear", "kiwi", "grape", "blueberry"]
	 * 
	 * Output: { 'a': "banana", 'b': "blueberry", 'p': "pear", 'k': "kiwi", 'g':
	 * "grape" }
	 * 
	 * 
	 * Explanation: The map groups strings by their starting character and maps to
	 * the longest string in each group.
	 */

	public Map<Character, String> findLongestStringInEachGroup(List<String> words) {
		// write code here using Java Streams API

		// using toMap()
//		Map<Character, String> collect = words.stream().collect(//
//				Collectors.toMap(//
//						word -> word.charAt(0)// key
//						, Function.identity() // value
//						, (a, b) -> a.length() > b.length() ? a : b // merge conflict resolver
//				));

		// using groupingBy()
		Map<Character, String> collect2 = words.stream()
				.collect(Collectors.groupingBy(word -> word.charAt(0),
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(String::length)),
								optionalStr -> optionalStr.orElse(""))));

		System.out.println(collect2);

		return collect2;
	}

	/*
	 * 6. Calculate Running Average of a Stream of Numbers using Java Streams API.
	 * 
	 * Example: Input: [10, 20, 30, 40, 50]
	 * 
	 * Output: [10.0, 15.0, 20.0, 25.0, 30.0]
	 * 
	 * Explanation: The output list contains the running average after each number
	 * in the input list.
	 */
	public List<Double> calculateRunningAverage(List<Integer> numbers) {
		// write code here using Java Streams API

		List<Double> result = IntStream.rangeClosed(1, numbers.size()).mapToDouble(i -> numbers.stream() //
				.mapToInt(Integer::valueOf) //
				.limit(i) //
				.average() //
				.orElse(0.0) //
		).boxed().toList();

		return result;
	}

	/*
	 * 7. Count Employees by Department using Java Streams API.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000) ]
	 * 
	 * Output: {"HR": 2, "IT": 2, "Finance": 1}
	 * 
	 * Explanation: The map contains the count of employees in each department.
	 */
	public Map<String, Double> countEmployeesByDepartment(List<Employee> employees) {
		// write code here using Java Streams API

		Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::department, //
				Collectors.collectingAndThen( //
						Collectors.counting() //
						, val -> Double.valueOf(val))));

		return collect;
	}

	/*
	 * 8. Find Elements That Appear Exactly Once in a List using Java Streams API.
	 * 
	 * Example: Input: [1, 2, 3, 4, 5, 3, 2, 1]
	 * 
	 * Output: [4, 5]
	 * 
	 * Explanation: The output list contains elements that appear exactly once in
	 * the input list.
	 */
	public List<Integer> findElementsThatAppearExactlyOnceInList(List<Integer> numbers) {
		// write code here using Java Streams API

		List<Integer> list = numbers.stream().filter(num -> Collections.frequency(numbers, num) == 1).toList();

		return list;
	}

	/*
	 * 9. Create Hierarchical Map from Flat List using Java Streams API.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000) ]
	 * 
	 * Output: { "HR": { "employees": ["Alice", "Charlie"], "totalSalary": 130000 },
	 * "IT": { "employees": ["Bob", "David"], "totalSalary": 170000 }, "Finance": {
	 * "employees": ["Eve"], "totalSalary": 80000 }
	 */
	public Map<String, EmployeeCustomView> createHierarchicalMapFromFlatList(Employee[] employees) {
		// write code here using Java Streams API

		Map<String, EmployeeCustomView> collect = Arrays.stream(employees) //
				.collect(Collectors.groupingBy(Employee::department,
						Collectors.collectingAndThen(Collectors.toList(), empList -> {

							List<String> empNameList = empList.stream().map(Employee::name).toList();
							double totalSalary = empList.stream().mapToDouble(Employee::salary).sum();

							return new EmployeeCustomView(empNameList, totalSalary);

						})));

		return collect;
	}

	/*
	 * 10. Find Top N Employees by Salary in Each Department using Java Streams API.
	 * 
	 * Example: Employees: [ Employee("Alice", "HR", 60000), Employee("Bob", "IT",
	 * 80000), Employee("Charlie", "HR", 70000), Employee("David", "IT", 90000),
	 * Employee("Eve", "Finance", 80000), Employee("Frank", "IT", 85000) ]
	 * 
	 * N = 2
	 * 
	 * Output: { "HR": ["Charlie", "Alice"], "IT": ["David", "Frank"], "Finance":
	 * ["Eve"] }
	 * 
	 * Explanation: The map contains the top N employees by salary in each
	 * department. If a department has fewer than N employees, include all of them.
	 */
	public Map<String, List<String>> findTopNEmployeesBySalaryInEachDepartment(List<Employee> employees, int N) {
		// write code here using Java Streams API

		Map<String, List<String>> collect = employees.stream().collect( //

				Collectors.groupingBy(Employee::department, //
						Collectors.collectingAndThen(Collectors.toList(), //
								list -> {
									return list.stream().sorted(Comparator.comparing(Employee::salary).reversed())
											.limit(N).map(Employee::name).toList();
								})));

		return collect;
	}
}
