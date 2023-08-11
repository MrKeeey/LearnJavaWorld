import java.util.*;

class V2Radiator {
    public String infov2 = "V2Radiator";

    V2Radiator(ArrayList list){
        for (int count = 0; count < 5; count++){
            this.infov2 = infov2;
            list.add(new SimUnit(infov2));
        }
    }
    @Override
    public String toString(){
        return infov2 + " ";
    }
}

class V3Radiator extends V2Radiator {
    public String info = "V3Radiator";
    /*V3Radiator v3 = new V3Radiator();
    V3Radiator(){

    }*/
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
        System.out.println(aList);
        V3Radiator v3 = new V3Radiator(aList);
        System.out.println(aList);
        for (int count = 0; count < 20; count++){
            RetentionBot ret = new RetentionBot(aList);
        }
        for (Object al : aList) {
            System.out.print(al + " ");
        }
    }
    public String toString(){
        return "123";
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