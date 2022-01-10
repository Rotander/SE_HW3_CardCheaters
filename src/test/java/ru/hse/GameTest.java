package ru.hse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void launchStart() {
        Game.start(45, 1);
        Assertions.assertEquals(46, Game.getPlayers().length);
    }

    @Test
    void launchStop() {
        Game.start(1, 85);
        sleep();
        Game.stop();
    }

    @Test
    void launchResult() {
        Game.start(1, 85);
        sleep();
        Game.stop();
        Game.result();
    }

    @Test
    void getPlayersAndMax() {
        Game.start(1, 85);
        Assertions.assertNotNull(Game.getPlayers());
        Assertions.assertEquals(1, Game.getMaxIndexFairPlayer());
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так...");
        }
    }

}