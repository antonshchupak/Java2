package lesson1;

public class Main {
    public static void main(String[] args) {
    Participant[] participants = new Participant[]{
    new Cat("Bilbo", 50,1),
    new Robot("Bender", 200, 3),
    new Human("Fry", 100, 2)
    };

    Obstacle[] obstacles = new Obstacle[] {
            new Treadmill(45),
            new Wall(2),
            new Treadmill(150),
            new Wall(1),
            new Wall(3)
    };


        for (Obstacle obstacle : obstacles) {
            for (Participant participant : participants) {
                if (!participant.isStopped()) {
                    if (obstacle instanceof Wall) {
                        ((Wall) obstacle).accept((Actions) participant);
                    } else if (obstacle instanceof Treadmill) {
                        ((Treadmill) obstacle).accept((Actions) participant);
                    }
                }
            }
        }
    }
}
