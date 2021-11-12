package lesson1;

public class Robot implements Actions{
    private final String name;
    private final int maxRun;
    private final int maxJump;
    private boolean isStopped = false;

    Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
    @Override
    public boolean run(int distance) {
        if(distance <= maxRun) {
            System.out.println("Robot " + name + " runs " + distance + " m.");
            return true;
        } else {
            System.out.println("Oops, something wrong with robot " + name);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height <= maxJump) {
            System.out.println("Robot " + name + " jumps " + height + " m.");
            return true;
        } else {
            System.out.println("Oops, jumping power is gone from robot " + name);
            isStopped = true;
            return false;
        }
    }
    @Override
    public boolean isStopped() {
        return isStopped;
    }
}
