import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    // CHANGE THIS TO YOUR DATABASE PATH
    private String db_name = "/home/user/class/mc833/mc833-lab1/curriculum.db";

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:" + db_name;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private String getString(String email, String sql, String column) {
        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            // loop through the result set
            StringBuilder result = new StringBuilder();
            result.append(column + ":\n");
            while (rs.next()) {
                result.append(rs.getString(column) + "; ");
            }
            result.append("\n");
            return result.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public void addProfileExperienceQuery(String email, String experience) {
        String sql = "INSERT INTO Experiences VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, experience);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAllFromCourseQuery(String course) {
        String sql = "SELECT Name, FamilyName FROM Profile WHERE Major = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course);
            ResultSet rs = pstmt.executeQuery();

            StringBuilder result = new StringBuilder();
            result.append("All persons from course:\n");
            while (rs.next()) {
                result.append(rs.getString("Name") + " ");
                result.append(rs.getString("FamilyName") + "; ");
            }
            return result.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String getAbilitiesFromCityQuery(String city) {
        String sql = "SELECT Ability FROM (Profile NATURAL JOIN Abilities) WHERE City = ?";

        return getString(city, sql, "Ability");
    }

    public String getExperienceFromEmailQuery(String email) {
        String sql = "SELECT Experience FROM Experiences WHERE Email = ?";
        return getString(email, sql, "Experience");
    }

    public String getAbilitiesFromEmailQuery(String email) {
        String sql = "SELECT Ability FROM Abilities WHERE Email = ?";
        return getString(email, sql, "Ability");
    }

    public String getProfileFromEmailQuery(String email) {
        String sql = "SELECT * FROM Profile WHERE Email = ?";
        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            // loop through the result set
            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                result.append("Email: " + rs.getString("Email") + " ");
                result.append("Nome: " + rs.getString("Name") + " ");
                result.append("Sobrenome: " + rs.getString("FamilyName") + " ");
                result.append("Cidade: " + rs.getString("City") + " ");
                result.append("Foto: " + rs.getString("PhotoURL") + " ");
                result.append("Curso: " + rs.getString("Major") + "\n");
            }
            return result.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String getAllQuery() {
        String sql = "SELECT email FROM Profile";
        List<String> emails = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set

            while (rs.next()) {
                emails.add(rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        StringBuilder result = new StringBuilder();
        for (String email : emails) {
            result.append(getProfileFromEmailQuery(email));
            result.append(getAbilitiesFromEmailQuery(email));
            result.append(getExperienceFromEmailQuery(email));
        }
        return result.toString();
    }

    public String getInfoFromEmailQuery(String email) {
        StringBuilder result = new StringBuilder();
        result.append(getProfileFromEmailQuery(email));
        result.append(getAbilitiesFromEmailQuery(email));
        result.append(getExperienceFromEmailQuery(email));
        return result.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBCUtil db = new JDBCUtil();
        System.out.println(db.getAllFromCourseQuery("ciencia da computacao"));
        System.out.println(db.getAbilitiesFromCityQuery("goiania"));
//        db.addProfileExperienceQuery("rafael@gmail.com", "intellij");
        System.out.println(db.getExperienceFromEmailQuery("rafael@gmail.com"));
        System.out.println(db.getAllQuery());
        System.out.println(db.getInfoFromEmailQuery("joaovitor@gmail.com"));
    }
}
