public class Race {
    private final int distance;
    private final Car[] cars;
    private volatile boolean raceFinished;
    private String winner;

    public Race(int carCount, int distance) {
        this.distance = distance;
        this.cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(i + 1, this);
        }
    }

    public void startRace() {
        for (Car car : cars) {
            new Thread(car).start();
        }
    }

    public void waitForFinish() {
        for (Car car : cars) {
            try {
                car.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void finishRace(Car car) {
        if (!raceFinished) {
            raceFinished = true;
            winner = "Машинка #" + car.getNumber();
        }
    }

    public String getWinner() {
        return winner;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isFinished() {
        return raceFinished;
    }
}