package org.projects.assignments.l2;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.projects.assignments.models.Employee;
import org.testng.annotations.Test;

public class L2AssignmentTest {
    L2Assignment l2Assignment = new L2Assignment();

    /*
    Tests for findEmployeesWithNthHighestUniqueSalary
     */
    @Test
    public void testFindEmployeesWithNthHighestUniqueSalary() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0)
        };
        Double expected = 70000.0; // 3rd highest unique salary
        Double result = l2Assignment.findEmployeesWithNthHighestUniqueSalary(employees, 3);
        assertEquals(result, expected);
    }

    @Test
    public void testFindEmployeesWithNthHighestUniqueSalaryNoThird() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0)
        };
        Double expected = -1.0; // No 4th highest unique salary
        Double result = l2Assignment.findEmployeesWithNthHighestUniqueSalary(employees, 4);
        assertEquals(result, expected);
    }

    @Test
    public void testFindEmployeesWithNthHighestUniqueSalarySingleEmployee() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0)
        };
        Double expected = -1.0; // No 2nd highest unique salary
        Double result = l2Assignment.findEmployeesWithNthHighestUniqueSalary(employees, 2);
        assertEquals(result, expected);
    }

    @Test
    public void testFindEmployeesWithNthHighestUniqueSalaryAllSameSalary() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 60000.0),
                new Employee("Charlie", "HR", 60000.0)
        };
        Double expected = -1.0; // No 2nd highest unique salary
        Double result = l2Assignment.findEmployeesWithNthHighestUniqueSalary(employees, 2);
        assertEquals(result, expected);
    }

    @Test
    public void testFindEmployeesWithNthHighestUniqueSalaryNegativeSalaries() {
        Employee[] employees = {
                new Employee("Alice", "HR", -60000.0),
                new Employee("Bob", "IT", -80000.0),
                new Employee("Charlie", "HR", -70000.0)
        };
        Double expected = -70000.0; // 2nd highest unique salary
        Double result = l2Assignment.findEmployeesWithNthHighestUniqueSalary(employees, 2);
        assertEquals(result, expected);
    }

    /*
    Tests for convertListOfObjectsToMap
     */
    @Test
    public void testConvertListOfObjectsToMap() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0)
        };
        String expected = "{HR=[Alice, Charlie], IT=[Bob, David], Finance=[Eve]}";
        String result = l2Assignment.convertListOfObjectsToMap(employees).toString();
        assertEquals(result, expected);
    }

    @Test
    public void testConvertListOfObjectsToMapSingleEmployee() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0)
        };
        String expected = "{HR=[Alice]}";
        String result = l2Assignment.convertListOfObjectsToMap(employees).toString();
        assertEquals(result, expected);
    }


    /*
    Tests for findAllDuplicateElementsInList
     */
    @Test
    public void testFindAllDuplicateElementsInList() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 3, 2, 1);
        List<Integer> expected = List.of(1, 2, 3);
        List<Integer> result = l2Assignment.findAllDuplicateElementsInList(input);
        assertEquals(result, expected);

    }

    @Test
    public void testFindAllDuplicateElementsInListNoDuplicates() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        List<Integer> expected = List.of();
        List<Integer> result = l2Assignment.findAllDuplicateElementsInList(input);
        assertEquals(result, expected);
    }

    @Test
    public void testFindAllDuplicateElementsInListAllDuplicates() {
        List<Integer> input = List.of(1, 1, 1, 1);
        List<Integer> expected = List.of(1);
        List<Integer> result = l2Assignment.findAllDuplicateElementsInList(input);
        assertEquals(result, expected);
    }

    /*
    Tests for groupByMultipleFields
     */

    @Test
    public void testGroupByMultipleFields() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0),
                new Employee("Frank", "IT", 80000.0)
        };
        String expected = "{HR={60000.0=[Alice], 70000.0=[Charlie]}, IT={80000.0=[Bob, Frank], 90000.0=[David]}, Finance={80000.0=[Eve]}}";
        String result = l2Assignment.groupByMultipleFields(employees).toString();
        assertEquals(result, expected);
    }

    @Test
    public void testGroupByMultipleFieldsSingleEmployee() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0)
        };
        String expected = "{HR={60000.0=[Alice]}}";
        String result = l2Assignment.groupByMultipleFields(employees).toString();
        assertEquals(result, expected);
    }


    /*
     Tests for findLongestStringInEachGroup
     */
    
    @Test
    public void testFindLongestStringInEachGroup() {
        List<String> input = List.of("apple", "banana", "pear", "kiwi", "grapefruit", "blueberry");
        Map<Character, String> expected = Map.of(
                'a', "banana",
                'b', "blueberry",
                'g', "grapefruit",
                'k', "kiwi",
                'p', "pear"
        );
        Map<Character, String> result = l2Assignment.findLongestStringInEachGroup(input);
        assertEquals(result, expected);
    }
    
    @Test
    public void testFindLongestStringInEachGroupSingleCharacter() {
        List<String> input = List.of("a", "b", "c", "d");
        Map<Character, String> expected = Map.of(
                'a', "a",
                'b', "b",
                'c', "c",
                'd', "d"
        );
        Map<Character, String> result = l2Assignment.findLongestStringInEachGroup(input);
        assertEquals(result, expected);
    }

    /*
    Tests for calculateRunningAverage
     */
    @Test
    public void testCalculateRunningAverage() {
        List<Integer> input = List.of(10, 20, 30, 40, 50);
        List<Double> expected = List.of(10.0, 15.0, 20.0, 25.0, 30.0);
        List<Double> result = l2Assignment.calculateRunningAverage(input);
        assertEquals(result, expected);
    }
    @Test
    public void testCalculateRunningAverageSingleElement() {
        List<Integer> input = List.of(10);
        List<Double> expected = List.of(10.0);
        List<Double> result = l2Assignment.calculateRunningAverage(input);
        assertEquals(result, expected);
    }

    @Test
    public void testCalculateRunningAverageEmptyList() {
        List<Integer> input = List.of();
        List<Double> expected = List.of();
        List<Double> result = l2Assignment.calculateRunningAverage(input);
        assertEquals(result, expected);
    }

    /*
    Tests for countEmployeesByDepartment
     */
    @Test
    public void testCountEmployeesByDepartment() {
List<Employee> employees = List.of(
        new Employee("Alice", "HR", 60000.0),
        new Employee("Bob", "IT", 80000.0),
        new Employee("Charlie", "HR", 70000.0),
        new Employee("David", "IT", 90000.0),
        new Employee("Eve", "Finance", 80000.0)
);
        Map<String, Double> expected = Map.of(
                "HR", 2.0,
                "IT", 2.0,
                "Finance", 1.0
        );
        Map<String, Double> result = l2Assignment.countEmployeesByDepartment(employees);
        assertEquals(result, expected);
    }

    @Test
    public void testCountEmployeesByDepartmentSingleEmployee() {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 60000.0)
        );
        Map<String, Double> expected = Map.of(
                "HR", 1.0
        );
        Map<String, Double> result = l2Assignment.countEmployeesByDepartment(employees);
        assertEquals(result, expected);
    }

    /*
    Tests for findElementsThatAppearExactlyOnceInList
     */
    @Test
    public void testFindElementsThatAppearExactlyOnceInList() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 3, 2, 1);
        List<Integer> expected = List.of(4, 5);
        List<Integer> result = l2Assignment.findElementsThatAppearExactlyOnceInList(input);
        assertEquals(result, expected);
    }
    @Test
    public void testFindElementsThatAppearExactlyOnceInListNoUnique() {
        List<Integer> input = List.of(1, 1, 2, 2, 3, 3);
        List<Integer> expected = List.of();
        List<Integer> result = l2Assignment.findElementsThatAppearExactlyOnceInList(input);
        assertEquals(result, expected);
    }


    /*
    Tests for createHierarchicalMapFromFlatList
     */
    @Test
    public void testCreateHierarchicalMapFromFlatList() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0)
        };

        Map<String, Map<String, List<Employee>>> expected = Map.of(
                "HR", Map.of(
                        "employees", List.of(new Employee("Alice", "HR", 60000.0), new Employee("Charlie", "HR", 70000.0)),
                        "totalSalary", List.of(new Employee("Alice", "HR", 60000.0), new Employee("Charlie", "HR", 70000.0))
                ),
                "IT", Map.of(
                        "employees", List.of(new Employee("Bob", "IT", 80000.0), new Employee("David", "IT", 90000.0)),
                        "totalSalary", List.of(new Employee("Bob", "IT", 80000.0), new Employee("David", "IT", 90000.0))
                ),
                "Finance", Map.of(
                        "employees", List.of(new Employee("Eve", "Finance", 80000.0)),
                        "totalSalary", List.of(new Employee("Eve", "Finance", 80000.0))
                )
        );
        Map<String, Map<String, List<Employee>>> result = l2Assignment.createHierarchicalMapFromFlatList(employees);
        assertEquals(result, expected);
    }

    @Test
    public void testCreateHierarchicalMapFromFlatListSingleEmployee() {
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0)
        };

        Map<String, Map<String, List<Employee>>>  expected = Map.of(
                "HR", Map.of(
                        "employees", List.of(new Employee("Alice", "HR", 60000.0)),
                        "totalSalary", List.of(new Employee("Alice", "HR", 60000.0))
                )
        );
        Map<String, Map<String, List<Employee>>> result = l2Assignment.createHierarchicalMapFromFlatList(employees);
        assertEquals(result, expected);
    }

    /*
    Tests for findTopNEmployeesBySalaryInEachDepartment
     */
    @Test
    public void testFindTopNEmployeesBySalaryInEachDepartment() {
        int N = 2;
        Employee[] employees = {
                new Employee("Alice", "HR", 60000.0),
                new Employee("Bob", "IT", 80000.0),
                new Employee("Charlie", "HR", 70000.0),
                new Employee("David", "IT", 90000.0),
                new Employee("Eve", "Finance", 80000.0),
                new Employee("Frank", "IT", 85000.0)
        };
        Map<String, List<String>> expected = Map.of(
                "HR", List.of("Charlie", "Alice"),
                "IT", List.of("David", "Frank"),
                "Finance", List.of("Eve")
        );
        Map<String, List<String>> result = l2Assignment.findTopNEmployeesBySalaryInEachDepartment(List.of(employees), N);
        assertEquals(result, expected);
    }
    @Test
    public void testFindTopNEmployeesBySalaryInEachDepartmentSingleEmployee() {
        int N = 2;
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 60000.0)
        );
        Map<String, List<String>> expected = Map.of(
                "HR", List.of("Alice")
        );
        Map<String, List<String>> result = l2Assignment.findTopNEmployeesBySalaryInEachDepartment(employees, N);
        assertEquals(result, expected);
    }

}

