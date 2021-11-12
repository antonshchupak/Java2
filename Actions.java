package lesson1;

public interface Actions extends Participant {
    boolean run(int distance);
    boolean jump(int height);
}
