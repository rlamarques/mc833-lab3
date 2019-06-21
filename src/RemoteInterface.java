import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface RemoteInterface extends Remote {
    void getAllFromCourse() throws RemoteException;
    void getAbilitiesFromCity() throws RemoteException;
    void addProfileExperience() throws RemoteException;
    void getExperienceFromEmail() throws RemoteException;
    void getAll() throws RemoteException;
    void getInfoFromEmail() throws RemoteException;
}