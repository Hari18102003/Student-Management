import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
            this.url = properties.getProperty("db.url");
            this.user = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, roll_number, class, dob, contact_info) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getRollNumber());
            pstmt.setString(3, student.getClassName());
            pstmt.setDate(4, Date.valueOf(student.getDob()));
            pstmt.setString(5, student.getContactInfo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getString("roll_number"),
                        rs.getString("class"),
                        rs.getDate("dob").toString(),
                        rs.getString("contact_info")
                );
                student.setStudentId(rs.getInt("student_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public void updateStudent(int id, Student student) {
        String sql = "UPDATE students SET name = ?, roll_number = ?, class = ?, dob = ?, contact_info = ? WHERE student_id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getRollNumber());
            pstmt.setString(3, student.getClassName());
            pstmt.setDate(4, Date.valueOf(student.getDob()));
            pstmt.setString(5, student.getContactInfo());
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
