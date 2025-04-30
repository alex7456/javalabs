public class CarRace {
    public static void main(String[] args) {
        Race race = new Race(5, 100);
        System.out.println("Подготовка к гонке!");
        System.out.println("Участники на старте...");

        race.startRace();
        race.waitForFinish();

        System.out.println("Гонка завершена! Победитель: " + race.getWinner());
    }
}