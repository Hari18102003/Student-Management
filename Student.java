public class Student {
    private int studentId;
    private String name;
    private String rollNumber;
    private String className;
    private String dob;
    private String contactInfo;

    // Constructor
    public Student(String name, String rollNumber, String className, String dob, String contactInfo) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.className = className;
        this.dob = dob;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

