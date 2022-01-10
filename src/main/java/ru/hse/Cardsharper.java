package ru.hse;

/**
 * Player who can steal balance.
 */
class Cardsharper extends Player {
    /**
     * @return probability stealing the balance
     */
    private static int getProbability() {
        return getRandom().nextInt(100) + 1;
    }

    /**
     * @return numbers of points to steal
     */
    private static int getSteal() {
        return getRandom().nextInt(9);
    }

    /**
     * @return time to relax
     */
    private static int getTimeAfterTheft() {
        return getRandom().nextInt(121) + 180;
    }

    /**
     * @return index of person from whom the points will be stolen
     */
    private static int getIndexFairPlayer() {
        return getRandom().nextInt(Game.getMaxIndexFairPlayer());
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (getProbability() <= 40) {
                theft();
            } else {
                super.takeCard();
            }
        }
    }

    /**
     * Theft process.
     */
    private void theft() {
        int steal = getSteal();
        int index = getIndexFairPlayer();
        synchronized (sync) {
            increaseBalance(Game.getPlayers()[index].balanceTheft(steal));
        }
        sleep(getTimeAfterTheft());
    }
}
