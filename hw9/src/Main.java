import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Course> uniqueCourses(List<Student> students) {
        if (!students.isEmpty()) {
            return students.stream()
                .map(Student::getAllCourses)
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static List<Student> mostInquisitiveStudents(List<Student> students) {
        if (!students.isEmpty()) {
            return students.stream()
                    .sorted((s1, s2) -> Integer.compare(s2.getAllCourses().size(), s1.getAllCourses().size()))
                    .limit(3)
                    .toList();
        }
        return new ArrayList<>();
    }

    private static List<Student> studentsOfTheCourse(List<Student> students, Course course) {
        if (!students.isEmpty() || Objects.isNull(course)) {
            return students.stream()
                    .filter(student -> student.getAllCourses().stream()
                    .filter(course1 -> course1.getTitle().equals(course.getTitle())).toList().size() > 0)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new HwStudent("Boris", Arrays.asList(
                new HwCourse("Math for beginners"),
                new HwCourse("Biology"),
                new HwCourse("Physics theory")
        )));
        students.add(new HwStudent("Alex", Arrays.asList(
                new HwCourse("Biology"),
                new HwCourse("Experimental Chemistry"),
                new HwCourse("IT for Dummies")
        )));
        students.add(new HwStudent("Mya", Arrays.asList(
                new HwCourse("Math for beginners"),
                new HwCourse("Physics theory")
        )));
        students.add(new HwStudent("Bob", Collections.singletonList(
                new HwCourse("Physics theory")
        )));
        students.add(new HwStudent("Ally", Arrays.asList(
                new HwCourse("IT for Dummies"),
                new HwCourse("Physics theory"),
                new HwCourse("Experimental Chemistry"),
                new HwCourse("Biology")
        )));


        System.out.println("\nTask1:");
        System.out.println(uniqueCourses(students).stream()
                .map(Course::getTitle)
                .collect(Collectors.joining(", ", "Unique courses: ", "")));

        System.out.println("\nTask2:");
        System.out.println(mostInquisitiveStudents(students).stream()
                .map(student -> student.getName() + ": " + student.getAllCourses().size())
                .collect(Collectors.joining(" courses, ", "The most inquisitive students: ", " courses")));

        System.out.println("\nTask3:");
        System.out.println(studentsOfTheCourse(students, new HwCourse("Biology")).stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ", "Biology course group: ", "")));
    }
}
