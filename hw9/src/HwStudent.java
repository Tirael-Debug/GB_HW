import java.util.List;

public class HwStudent implements Student{

    private final String name;

    private final List<Course> courses;

    public HwStudent(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }
}
