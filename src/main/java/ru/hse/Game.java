package ru.hse;

/**
 * Logic for the game.
 */
class Game {
    /**
     * Array of players.
     */
    private static Player[] players;

    /**
     * Boundary index of fair players.
     */
    private static int maxIndexFairPlayer;

    static Player[] getPlayers() {
        return players;
    }

    static int getMaxIndexFairPlayer() {
        return maxIndexFairPlayer;
    }

    /**
     * Game initialization.
     *
     * @param fairCount        count of fair players
     * @param cardsharperCount count of cardsharpers
     */
    static void start(int fairCount, int cardsharperCount) {
        players = new Player[fairCount + cardsharperCount];
        int i = 0;
        for (; i < fairCount; i++) {
            players[i] = new Player();
        }

        for (; i < fairCount + cardsharperCount; i++) {
            players[i] = new Cardsharper();
        }
        maxIndexFairPlayer = fairCount;

        for (Player player : players) {
            player.start();
        }
    }

    /**
     * Stopping the game.
     */
    static void stop() {
        for (Player player : players) {
            player.interrupt();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                System.out.println("Что-то пошло не так...");
            }
        }
    }

    /**
     * Print game results.
     */
    static void result() {
        int max = -1;
        for (int i = 0; i < players.length; i++) {
            System.out.println("Баланс " + (i + 1) + " игрока = " + players[i].getBalance());
            if (players[i].getBalance() > max) {
                max = players[i].getBalance();
            }
        }

        System.out.print("Номера победителей в игре:");
        for (int i = 0; i < players.length; i++) {
            if (players[i].getBalance() == max) {
                System.out.print(" " + (i + 1));
            }
        }
    }
}
