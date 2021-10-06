public class Main {

    public static final String[][] validMatrix = {
            {"1", "2", "3", "4"},
            {"2", "2", "0", "0"},
            {"3", "0", "3", "0"},
            {"4", "0", "0", "4"}
    };

    public static final String[][] invalidSizeMatrix = {
            {"1", "2", "1", "2"},
            {"2", "1", "2", "1"},
            {"1", "2", "1", "2"}
    };

    public static final String[][] invalidTypeMatrix = {
            {"0", "0", "0", "0"},
            {"1", "1", "a", "1"},
            {"2", "2", "2", "2"},
            {"3", "3", "3", "3"}
    };

    public static void main(String[] args) {
        MatrixCounter counter = new MatrixCounter();

        try {
            System.out.println(counter.calculate(validMatrix));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println(counter.calculate(invalidSizeMatrix));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println(counter.calculate(invalidTypeMatrix));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
