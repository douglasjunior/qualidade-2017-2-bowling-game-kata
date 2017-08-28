package br.grupointegrado.bowlingGame;

/**
 *
 * @author dougl
 */
public class TenthFrame extends Frame {

    private int rollC = 0;

    public int getRollC() {
        return rollC;
    }

    public void setRollC(int rollC) {
        this.rollC = rollC;
    }

    @Override
    public int frameScore() {
        return super.frameScore() + getRollC();
    }

    @Override
    public int totalScore() {
        return frameScore();
    }

    @Override
    public int bonusScore() {
        return 0;
    }

    @Override
    public String toString() {
        return "TenthFrame{"
                + "rollA=" + getRollA()
                + ", rollB=" + getRollB()
                + ", rollC=" + getRollC()
                + "}";
    }

}
