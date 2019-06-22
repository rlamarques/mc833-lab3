// Implementing the remote interface
public class Implementation implements RemoteInterface {

    // Implementing the interface method
    public void getAllFromCourse() {
        System.out.println("Called getAllFromCourse method");
    }
    public String getAbilitiesFromCity(String city) {
        JDBCUtil db = new JDBCUtil();
        return db.getAbilitiesFromCityQuery(city);
    }
    public void addProfileExperience(String email, String experience) {
        JDBCUtil db = new JDBCUtil();
        db.addProfileExperienceQuery(email, experience);
    }
    public String getExperienceFromEmail(String email) {
        JDBCUtil db = new JDBCUtil();
        return db.getExperienceFromEmailQuery(email);
    }
    public String getAll() {
        JDBCUtil db = new JDBCUtil();
        return db.getAllQuery();
    }
    public String getInfoFromEmail(String email) {
        JDBCUtil db = new JDBCUtil();
        return db.getInfoFromEmailQuery(email);
    }
}