public class Car implements Runnable {
    private final int number;
    private final Race race;
    private int distance;

    public Car(int number, Race race) {
        this.number = number;
        this.race = race;
    }

    @Override
    public void run() {
        while (distance < race.getDistance() && !race.isFinished()) {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            distance += (int) (Math.random() * 10);
            System.out.println("Машинка #" + number + " проехала " + distance + " метров");

            if (distance >= race.getDistance()) {
                race.finishRace(this);
                System.out.println("!!! Машинка #" + number + " финишировала первой !!!");
            }

            Thread.yield();
        }
    }

    public int getNumber() {
        return number;
    }

    public void join() throws InterruptedException {
        Thread.currentThread().join();
    }
}