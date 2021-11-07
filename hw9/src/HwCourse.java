import java.util.Objects;

public class HwCourse implements Course{

    private final String title;

    public HwCourse(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        HwCourse comparedCourse = (HwCourse) obj;
        return Objects.equals(this.title, comparedCourse.title);
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
