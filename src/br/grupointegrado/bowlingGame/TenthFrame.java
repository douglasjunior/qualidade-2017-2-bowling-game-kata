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
    public String toString() {
        return "Frame{"
                + "rollA=" + getRollA()
                + ", rollB=" + getRollB()
                + ", rollC=" + getRollC()
                + "}";
    }

}
