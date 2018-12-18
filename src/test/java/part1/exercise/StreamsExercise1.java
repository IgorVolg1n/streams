package part1.exercise;

import data.Employee;
import data.JobHistoryEntry;
import data.Person;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static data.Generator.generateEmployeeList;

public class StreamsExercise1 {
    // https://youtu.be/kxgo7Y4cdA8 Сергей Куксенко и Алексей Шипилёв — Через тернии к лямбдам, часть 1
    // https://youtu.be/JRBWBJ6S4aU Сергей Куксенко и Алексей Шипилёв — Через тернии к лямбдам, часть 2

    // https://youtu.be/O8oN4KSZEXE Сергей Куксенко — Stream API, часть 1
    // https://youtu.be/i0Jr2l3jrDA Сергей Куксенко — Stream API, часть 2

    @Test
    public void getAllEpamEmployees() {
        List<Employee> epamEmployees = generateEmployeeList();// TODO all persons with experience in epam
        Integer n = 0;
        for (Employee epamEmployee : epamEmployees) {
            n++;
            System.out.println(n.toString() + " " + epamEmployee + "\n");
        }
        System.out.println("=================================================");
        List<Employee> epamers = epamEmployees.stream()
                .filter(employee ->
                {
                    List<String> collected = employee.getJobHistory().stream()
                            .map(JobHistoryEntry::getEmployer)
                            .collect(Collectors.toList());
                    return collected.contains("epam");
                }).collect(Collectors.toList());
        n = 0;
        for (Employee epamer : epamers) {
            n++;
            System.out.println(n.toString() + " " + epamer + "\n");
        }
    }

    @Test
    public void getEmployeesStartedFromEpam() {
        List<Person> epamEmployees = null;// TODO all persons with first experience in epam
        throw new UnsupportedOperationException();
    }

    @Test
    public void sumEpamDurations() {
        final List<Employee> employees = generateEmployeeList();

        int expected = 0;

        for (Employee e : employees) {
            for (JobHistoryEntry j : e.getJobHistory()) {
                if (j.getEmployer().equals("epam")) {
                    expected += j.getDuration();
                }
            }
        }

        // TODO
        throw new UnsupportedOperationException();

        // int result = ???
        // assertEquals(expected, result);
    }

}
