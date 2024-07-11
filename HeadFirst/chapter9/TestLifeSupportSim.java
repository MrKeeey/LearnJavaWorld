import java.util.*;

class V2Radiator {
    V2Radiator(ArrayList list){
        for (int count = 0; count < 5; count++){
            list.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator {
    V3Radiator(ArrayList lglist){
        for (int count = 0; count < 10; count++){
            lglist.add(new SimUnit("V3Radiator"));
        }
    }
}

class RetentionBot {
    RetentionBot(ArrayList rlist){
        rlist.add(new SimUnit("Hot Machine"));
    }
}

public class TestLifeSupportSim {
    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        for (int count = 0; count < 20; count++){
            RetentionBot ret = new RetentionBot(aList);
        }
        System.out.println(aList);
    }
}

class SimUnit {
    String botType;
    SimUnit(String type){
        botType = type;
        powerUse();
    }

    int powerUse(){
        if ("Hot Machine".equals(botType)){
            return 2;
        } else {
            return 4;
        }
    }

    public String toString(){
        return botType;
    }
}