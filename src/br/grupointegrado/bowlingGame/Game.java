package br.grupointegrado.bowlingGame;

/**
 *
 * @author dougl
 */
public class Game {

    private Frame[] frames = new Frame[10];
    private int currentFrame = 0;
    private int frameRoll = 0;

    public void roll(int pins) {
        boolean isTenthFrame = currentFrame == 9;
        if (frames[currentFrame] == null) {
            // primeira jogada do frame
            frames[currentFrame] = isTenthFrame ? new TenthFrame() : new Frame();
            frames[currentFrame].setRollA(pins);
            frameRoll = 1;
            if (currentFrame > 0) {
                frames[currentFrame - 1].setNextFrame(frames[currentFrame]);
            }
            if (!isTenthFrame && pins == 10) {
                currentFrame++;
            }
        } else if (frameRoll == 1) {
            // segunda jogada do frame
            frames[currentFrame].setRollB(pins);
            frameRoll = 2;
            if (!isTenthFrame) {
                currentFrame++;
            }
        } else if (frameRoll == 2 && isTenthFrame) {
            // terceira jogada quando for décimo frame
            ((TenthFrame) frames[currentFrame]).setRollC(pins);
            frameRoll = 2;
        }
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.totalScore();
        }
        return score;
    }
}
