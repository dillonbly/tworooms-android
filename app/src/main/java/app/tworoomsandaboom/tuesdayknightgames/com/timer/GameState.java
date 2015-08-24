package app.tworoomsandaboom.tuesdayknightgames.com.timer;

import java.util.ArrayList;
import java.util.List;

/**
 * Game settings.
 */
public final class GameState {

    private final List<Round> rounds = new ArrayList<>();

    public List<Round> getRounds() {
        return rounds;
    }

    public static final class Round {

        private final int numberOfMinutes;
        private final int numberOfHostages;

        public Round(int numberOfMinutes, int numberOfHostages) {
            this.numberOfMinutes = numberOfMinutes;
            this.numberOfHostages = numberOfHostages;
        }

        public int getNumberOfMinutes() {
            return numberOfMinutes;
        }

        public int getNumberOfHostages() {
            return numberOfHostages;
        }
    }
}
