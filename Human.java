package lesson1;

public class Human implements  Actions{
    private final String name;
    private final int maxRun;
    private final int maxJump;
    private boolean isStopped = false;

    Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
    @Override
    public boolean run(int distance) {
        if(distance <= maxRun) {
            System.out.println("Human " + name + " runs " + distance + " m.");
            return true;
        } else {
            System.out.println("Oops, something wrong with human " + name);
            isStopped = true;
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height <= maxJump) {
            System.out.println("Human " + name + " jumps " + height + " m.");
            return true;
        } else {
            System.out.println("Oops, jumping power is gone from human " + name);
            isStopped = true;
            return false;
        }
    }
    @Override
    public boolean isStopped() {
        return isStopped;
    }

}
