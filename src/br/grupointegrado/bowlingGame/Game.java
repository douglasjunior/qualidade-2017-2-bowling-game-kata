package br.grupointegrado.bowlingGame;

import java.util.Arrays;

/**
 *
 * @author dougl
 */
public class Game {

    private Frame[] frames = new Frame[10];

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int frameCount = 0;
        for (int rollIndex = 0; rollIndex < rolls.length
                && frameCount < frames.length; rollIndex++) {
            int rollPins = rolls[rollIndex];
            if (frames[frameCount] == null) {
                boolean isTenthFrame = frameCount == 9;

                frames[frameCount] = isTenthFrame
                        ? new TenthFrame() : new Frame();

                frames[frameCount].setRollA(rollPins);
                if (rollPins < 10 || isTenthFrame) {
                    int nextRollPins = rolls[rollIndex + 1];
                    frames[frameCount].setRollB(nextRollPins);
                    rollIndex++;
                    if (isTenthFrame) {
                        int lastRollPins = rolls[rollIndex + 1];
                        ((TenthFrame) frames[frameCount])
                                .setRollC(lastRollPins);
                    }
                }
                frameCount++;
            }
        }
        System.out.println(Arrays.toString(frames));

        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
}
