// Implementing the remote interface
public class Implementation implements RemoteInterface {

    public String getAllFromCourse(String course) {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        String res = db.getAllFromCourseQuery(course);
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
        return res;
    }
    public String getAbilitiesFromCity(String city) {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        String res = db.getAbilitiesFromCityQuery(city);
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
        return res;
    }
    public void addProfileExperience(String email, String experience) {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        db.addProfileExperienceQuery(email, experience);
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
    }
    public String getExperienceFromEmail(String email) {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        String res = db.getExperienceFromEmailQuery(email);
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
        return res;
    }
    public String getAll() {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        String res = db.getAllQuery();
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
        return res;
    }
    public String getInfoFromEmail(String email) {
        double t3 = System.currentTimeMillis();
        JDBCUtil db = new JDBCUtil();
        String res = db.getInfoFromEmailQuery(email);
        double t4 = System.currentTimeMillis();
        System.out.println("" + t3 + " " + t4);
        return res;
    }
}