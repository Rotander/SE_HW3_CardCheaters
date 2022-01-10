package ru.hse;

/**
 * Main class that defines the order of the game.
 */
public class Main {
    /**
     * Game logic.
     *
     * @param args entered params
     */
    public static void main(String[] args) {
        int fairCount = Input.inputCount(1, "Введите число честных игроков: ");
        int cardsharperCount = Input.inputCount(0, "Введите число шулеров: ");

        System.out.println("Игра началась...");
        Game.start(fairCount, cardsharperCount);
        sleep();

        Game.stop();
        Game.result();
    }

    /**
     * Lulling the current thread.
     */
    private static void sleep() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так...");
        }
    }
}
