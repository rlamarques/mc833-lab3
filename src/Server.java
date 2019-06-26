import java.net.InetAddress;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.net.DatagramSocket;

public class Server extends Implementation {
    public Server() {}
    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            Implementation obj = new Implementation();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.createRegistry(5000);

            registry.bind("Profiles", stub);
            System.err.println("Server ready");


        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
