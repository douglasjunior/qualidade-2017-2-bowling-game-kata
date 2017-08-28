package br.grupointegrado.bowlingGame;

/**
 *
 * @author dougl
 */
public class Frame {

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

    @Override
    public String toString() {
        return "Frame{" + "rollA=" + rollA
                + ", rollB=" + rollB + '}';
    }
}
