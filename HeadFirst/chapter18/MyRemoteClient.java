package HeadFirst.chapter18;

import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {

        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote hello");
            String line = service.sayHello();
            System.out.println(line);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
