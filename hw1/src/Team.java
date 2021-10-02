public class Team {
    private String name;

    private Player[] players;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    public void showResults() {
        System.out.println("\nTeam " + this.name + " results:");
        for (Player player : this.players) {
            if (player.isPassedCourse()) {
                System.out.println("Player " + player.getName()
                        + " №" + player.getNumber()
                        + " successfully passed the course");
            }
        }
    }

    public Player[] showTeamInfo() {
        System.out.println("Team " + this.name + " info:");
        for (Player player : this.players) {
            System.out.print("Player " + player.getName()
                    + " №" + player.getNumber());
            if (player.isRunWell()) {
                System.out.print(" Good runner");
            }
            if (player.isSwimWell()) {
                System.out.print(" Good swimmer");
            }
            if (player.isJumpWell()) {
                System.out.print(" Good jumper");
            }
            System.out.println();
        }
        return this.players;
    }
}
