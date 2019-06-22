import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface RemoteInterface extends Remote {
    String getAllFromCourse(String course) throws RemoteException;
    String getAbilitiesFromCity(String city) throws RemoteException;
    void addProfileExperience(String email, String experience) throws RemoteException;
    String getExperienceFromEmail(String email) throws RemoteException;
    String getAll() throws RemoteException;
    String getInfoFromEmail(String email) throws RemoteException;
}