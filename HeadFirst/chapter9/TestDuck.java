package HeadFirst.chapter9;

class Duck {
    int pounds = 6;
    float floatability = 2.1F;
    String name = "Generic";
    long[] feathers = {1,2,3,4,5,6,7};
    boolean canFly = true;
    int maxSpeed = 25;

    public Duck(){
        System.out.println("type 1 duck");
    }

    public Duck(boolean fly){
        canFly = fly;
        System.out.println("type 2 duck");
    }

    public Duck(String n, long[] f){
        name = n;
        feathers = f;
        System.out.println("type 3 duck");
    }

    public Duck(int w, float f){
        pounds = w;
        floatability = f;
        System.out.println("type 4 duck");
    }

    public Duck(float density, int max){
        floatability = density;
        maxSpeed = max;
        System.out.println("type 5 duck");
    }
}

public class TestDuck {
    public static void main(String[] args) {
        int weight = 8;
        float density = 2.3F;
        String name = "Donald";
        long[] feathers = {1,2,3,4,5,6};
        boolean canFly = true;
        int airspeed = 22;

        Duck[] d = new Duck[7];

        d[0] = new Duck();                              //1
        d[1] = new Duck(density, weight);               //5
        d[2] = new Duck(name, feathers);                //3
        d[3] = new Duck(canFly);                        //2
        d[4] = new Duck(3.3F, airspeed);         //5
        d[5] = new Duck(false);                     //2
        d[6] = new Duck(airspeed, density);             //4
    }
}
