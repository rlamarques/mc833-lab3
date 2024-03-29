import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        // Getting the registry
        String serverIP = "143.106.16.49"; // or localhost if client and server on same machine.
        int serverPort = 5000;
        int query = 1;
        for(int i=0;i<21;i++) {

            try {
                double t1 = System.currentTimeMillis();
                Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
                // Looking up the registry for the remote object
                RemoteInterface stub = (RemoteInterface) registry.lookup("Profiles");

                // Calling the remote method using the obtained object
                if(query == 1) {
                    stub.getAllFromCourse("ciencia da computacao");
                }
                else if(query == 2) {
                    stub.getAbilitiesFromCity("goiania");
                }
                else if(query == 3) {
                    stub.getExperienceFromEmail("rafael@gmail.com");
                }
                else if(query == 4) {
                    stub.getAll();
                }
                else if(query == 5) {
                    stub.getInfoFromEmail("joaovitor@gmail.com");
                }
                else if(query == 6) {
                    stub.addProfileExperience("rafael@gmail.com", "Universidade Estadual de Campinas");
                }
                double t2 = System.currentTimeMillis();
//	        	System.out.println(t2);
                System.out.println("" + t1 + " " + t2);
            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}