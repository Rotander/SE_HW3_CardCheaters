package ru.hse;

import java.util.Random;

/**
 * Person who take a card from deck.
 */
class Player extends Thread {
    /**
     * Object to sync.
     */
    static final Object sync = 5;
    /**
     * Sum of the values of all cards taken by the player.
     */
    private int balance = 0;

    /**
     * Randomizer.
     */
    private static final Random random = new Random();

    /**
     * @return random object
     */
    static Random getRandom() {
        return random;
    }

    /**
     * Take a card from the deck.
     *
     * @return card value
     */
    static int getCard() {
        return getRandom().nextInt(10) + 1;
    }

    /**
     * @return time to relax
     */
    static int getTime() {
        return getRandom().nextInt(101) + 100;
    }

    /**
     * Lulling the current thread.
     *
     * @param time time to sleep
     */
    static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            takeCard();
        }
    }

    /**
     * @return balance
     */
    int getBalance() {
        return balance;
    }

    void increaseBalance(int value) {
        balance += value;
    }

    /**
     * @param value number of points that are stolen
     * @return result points that stole
     */
    int balanceTheft(int value) {
        if (balance - value >= 0) {
            balance -= value;
        } else {
            value = balance;
            balance = 0;
        }
        return value;
    }

    /**
     * Increase of the balance for the value of the card.
     */
    void takeCard() {
        synchronized (sync) {
            increaseBalance(getCard());
        }
        sleep(getTime());
    }
}
