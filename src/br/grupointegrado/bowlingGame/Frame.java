package br.grupointegrado.bowlingGame;

/**
 *
 * @author dougl
 */
public class Frame {

    private Frame nextFrame;

    private int rollA = 0;
    private int rollB = 0;

    public int getRollA() {
        return rollA;
    }

    public void setRollA(int rollA) {
        this.rollA = rollA;
    }

    public int getRollB() {
        return rollB;
    }

    public void setRollB(int rollB) {
        this.rollB = rollB;
    }

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public boolean isStrike() {
        return rollA == 10;
    }

    public boolean isSpare() {
        return !isStrike() && frameScore() == 10;
    }

    public int frameScore() {
        return rollA + rollB;
    }

    public int totalScore() {
        return frameScore() + bonusScore();
    }

    public int bonusScore() {
        int bonus = 0;
        if (isStrike()) {
            if (nextFrame instanceof TenthFrame) {
                bonus += nextFrame.getRollA() + nextFrame.getRollB();
            } else if (nextFrame.isStrike()) {
                bonus += nextFrame.getRollA();
                bonus += nextFrame.getNextFrame().getRollA();
            } else {
                bonus += nextFrame.frameScore();
            }
        } else if (isSpare()) {
            bonus += nextFrame.getRollA();
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Frame{" + "rollA=" + rollA
                + ", rollB=" + rollB + '}';
    }
}
