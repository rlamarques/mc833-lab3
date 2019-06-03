import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface RemoteInterface extends Remote {
    void listAllFromCourse() throws RemoteException;
    void listAbilitiesFromCity() throws RemoteException;
    void addProfileExperience() throws RemoteException;
    void getExperienceFromEmail() throws RemoteException;
    void listAll() throws RemoteException;
    void getInfoFromEmail() throws RemoteException;
}