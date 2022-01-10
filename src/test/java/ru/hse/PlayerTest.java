package ru.hse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void getStatics() {
        Player.getCard();
        Player.getTime();
        Player.sleep(1000);
    }

    @Test
    void actionsWithBalance() {
        Player player = new Player();
        player.increaseBalance(5);
        assertEquals(5, player.getBalance());
        player.balanceTheft(4);
        assertEquals(1, player.getBalance());
        assertEquals(1, player.balanceTheft(3));
        assertEquals(0, player.getBalance());
        player.takeCard();
        assertTrue(player.getBalance() > 0);
    }
}