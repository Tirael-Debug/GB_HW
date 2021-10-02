public class Course {

    private Barrier[] barriers;

    static class Barrier {
        private final String name;

        private final boolean needToRun;

        private final boolean needToSwim;

        private final boolean needToJump;

        public Barrier(String name, boolean needToRun, boolean needToSwim, boolean needToJump) {
            this.name = name;
            this.needToRun = needToRun;
            this.needToSwim = needToSwim;
            this.needToJump = needToJump;
        }

    }

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    public void doId(Team team) {
        Player[] players = team.showTeamInfo();
        for (int i = 0; i < this.barriers.length; i++) {
            for (Player player : players) {
                if (i > 0 && !player.isPassedCourse()) {
                    continue;
                }
                if (this.barriers[i].needToRun) {
                    player.setPassedCourse(player.isRunWell());
                }
                if (this.barriers[i].needToSwim) {
                    player.setPassedCourse(player.isSwimWell());
                }
                if (this.barriers[i].needToJump) {
                    player.setPassedCourse(player.isJumpWell());
                }
            }
        }
    }
}
