package lesson1;

public class Treadmill implements Obstacle {
    public int distance;
    public Treadmill(int distance) {
        this.distance = distance;
    }
    public void accept(Actions running) {
        running.run(distance);
    }
}
