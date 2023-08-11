import java.util.*;

class V2Radiator {
    private String info = "V2Radiator";
    V2Radiator v3 = new V2Radiator();
    V2Radiator(){

    }
    V2Radiator(ArrayList list){
        for (int count = 0; count < 5; count++){
            list.add(new SimUnit(info));
        }
    }

}

class V3Radiator extends V2Radiator {
    private String info = "V2Radiator";
    V3Radiator v3 = new V3Radiator();
    V3Radiator(){

    }
    V3Radiator(ArrayList lglist){
        super(lglist);
        for (int count = 0; count < 10; count++){
            lglist.add(new SimUnit(info));
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
        System.out.println(aList);
        V2Radiator v2 = new V2Radiator(aList);
        System.out.println();
        V3Radiator v3 = new V3Radiator(aList);
        System.out.println(aList);
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
    }

    int powerUse(){
        if ("Hot Machine".equals(botType)){
            System.out.println("2");
            return 2;
        } else {
            System.out.println("4");
            return 4;
        }
    }
}