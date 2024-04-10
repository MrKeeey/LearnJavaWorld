package HelloWorld;

public class CalculatorMmrDota2 {
    public static void main(String[] args) {
        int startMmr = 2500;
        int endMmr = 3500;
        SoloBoostMmr soloBoostMmr = new SoloBoostMmr(startMmr, endMmr);
        System.out.println(soloBoostMmr.priceMmrFor100(soloBoostMmr.getStartMmr(), soloBoostMmr.getEndMmr()));
    }
}

class SoloBoostMmr {
    private int startMmr;
    private int endMmr;

    public SoloBoostMmr(int startMmr, int endMmr) {
        this.startMmr = startMmr;
        this.endMmr = endMmr;
    }

    public int getStartMmr() {
        return startMmr;
    }

    public void setStartMmr(int startMmr) {
        this.startMmr = startMmr;
    }

    public int getEndMmr() {
        return endMmr;
    }

    public void setEndMmr(int endMmr) {
        this.endMmr = endMmr;
    }
    public int priceMmrFor100(int start, int end) {
        double price = 0;
        double soloPrice2000 = 120;
        double soloPrice2500 = 125;
        double soloPrice3000 = 130;
        double soloPrice3500 = 150;
        double soloPrice4000 = 190;
        double soloPrice4500 = 210;
        double soloPrice4750 = 300;
        double soloPrice5000 = 350;
        double soloPrice5250 = 450;
        double soloPrice5500 = 500;
        double soloPrice5750 = 900;
        double soloPrice6000 = 1100;

        for (int i = start; i < end; i++) {
            if (i >= 0 && i < 2000) price += soloPrice2000 / 100;
            if (i >= 2000 && i < 2500) price += soloPrice2500 / 100;
            if (i >= 2500 && i < 3000) price += soloPrice3000 / 100;
            if (i >= 3000 && i < 3500) price += soloPrice3500 / 100;
            if (i >= 3500 && i < 4000) price += soloPrice4000 / 100;
            if (i >= 4000 && i < 4500) price += soloPrice4500 / 100;
            if (i >= 4500 && i < 4750) price += soloPrice4750 / 100;
            if (i >= 4750 && i < 5000) price += soloPrice5000 / 100;
            if (i >= 5000 && i < 5250) price += soloPrice5250 / 100;
            if (i >= 5250 && i < 5500) price += soloPrice5500 / 100;
            if (i >= 5500 && i < 5750) price += soloPrice5750 / 100;
            if (i >= 5750 && i < 6000) price += soloPrice6000 / 100;
            System.out.println(price);
        }
        return (int) Math.round(price);
    }
}

class DuoBoostMMr extends SoloBoostMmr {

    public DuoBoostMMr(int startMmr, int endMmr) {
        super(startMmr, endMmr);
    }
}

class calibrationMrr {

}