import java.util.ArrayList;
import java.util.List;

public class Students {
    private List<Student> studentsList = new ArrayList<>();

    public Students(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Students() {
    }

    public List<Student> getStudentsList() {
        return this.studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentsList=" + studentsList +
                '}';
    }
}
