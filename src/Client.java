import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            RemoteInterface stub = (RemoteInterface) registry.lookup("Profiles");

            // Calling the remote method using the obtained object
            System.out.println(stub.getAllFromCourse("ciencia da computacao"));
            System.out.println(stub.getAbilitiesFromCity("goiania"));
//        stub.addProfileExperience("rafael@gmail.com", "intellij");
            System.out.println(stub.getExperienceFromEmail("rafael@gmail.com"));
            System.out.println(stub.getAll());
            System.out.println(stub.getInfoFromEmail("joaovitor@gmail.com"));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}