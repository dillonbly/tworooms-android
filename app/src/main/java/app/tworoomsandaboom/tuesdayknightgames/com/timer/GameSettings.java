package app.tworoomsandaboom.tuesdayknightgames.com.timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Game settings.
 */
public final class GameSettings {

    private final List<RoundSettings> rounds;

    public List<RoundSettings> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    private GameSettings(Builder builder) {
        this.rounds = new ArrayList<>(builder.rounds.size());
        this.rounds.addAll(builder.rounds);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class RoundSettings {

        private final int numberOfMinutes;
        private final int numberOfHostages;

        public RoundSettings(int numberOfMinutes, int numberOfHostages) {
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

    public static class Builder {

        private Builder() {}

        private Builder(GameSettings gameSettings) {
            rounds.addAll(gameSettings.rounds);
        }

        private List<RoundSettings> rounds = new ArrayList<>();

        public Builder addRound(RoundSettings round) {
            rounds.add(round);
            return this;
        }

        public Builder setRounds(int numRounds) {
            if (numRounds < rounds.size()) {
                rounds = rounds.subList(0, numRounds);
            }
            for (int i = rounds.size(); i < numRounds; i++) {
                rounds.add(new RoundSettings(1, 1));
            }
            return this;
        }

        public GameSettings build() {
            return new GameSettings(this);
        }
    }
}
