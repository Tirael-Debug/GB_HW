public class Main {
    public static void main(String[] args) {

        Course c = new Course(new Course.Barrier[]{
                new Course.Barrier("200 meters to run", true, false, false),
                new Course.Barrier("400 meters to swim", false, true, false),
                new Course.Barrier("1 meters to jump", false, false, true),
                new Course.Barrier("500 meters to run", true, false, false),
        });
        Team t = new Team("Meteor", new Player[]{
                new Player("John", 10, true, true ,true),
                new Player("Sally", 12, true, false ,true),
                new Player("Cindy", 5, true, true ,true),
                new Player("Ben", 3, false, false ,false),
        });
        c.doId(t);
        t.showResults();
    }
}
