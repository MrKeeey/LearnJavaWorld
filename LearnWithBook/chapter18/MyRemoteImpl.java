package LearnWithBook.chapter18;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements Remote {
    protected MyRemoteImpl() throws RemoteException {   }
    public static void main(String[] args) {
        try {
            MyRemoteImpl service = new MyRemoteImpl();
            Naming.rebind("Remote Hello", service);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String sayHello() {
        return "Server says: Hello!";
    }

}
