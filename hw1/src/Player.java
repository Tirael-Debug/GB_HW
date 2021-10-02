public class Player {
    // Имя игрока
    private final String name;
    // Номер игрока
    private final int number;
    // Призак хороших навыков бега
    private final boolean isRunWell;
    // Призак хороших навыков плавания
    private final boolean isSwimWell;
    // Призак хороших навыков прыжков
    private final boolean isJumpWell;
    // Признак прохождения дистанции
    private boolean isPassedCourse;

    public Player(String name, int number, boolean isRunWell, boolean isSwimWell, boolean isJumpWell) {
        this.name = name;
        this.number = number;
        this.isRunWell = isRunWell;
        this.isSwimWell = isSwimWell;
        this.isJumpWell = isJumpWell;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isRunWell() {
        return isRunWell;
    }

    public boolean isSwimWell() {
        return isSwimWell;
    }

    public boolean isJumpWell() {
        return isJumpWell;
    }

    public boolean isPassedCourse() {
        return isPassedCourse;
    }

    public void setPassedCourse(boolean passedCourse) {
        isPassedCourse = passedCourse;
    }
}
