package SpringWithDB.SpringWithDB.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name="Students")
public class StudentData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //mysql doesn't allow sequence,so ,identity is best to use,meanwhile,PostgresSQL familiar with`h sequence
    private long id;


    private String name;
    //@Transient  // (it can be used to define a variable in class,but not become an attribute in table in DB)
    private Integer age;

   //private Integer age;
    private LocalDate DOB;
    private String email;

    public StudentData() {
    }

    public StudentData(long id, String name, Integer age, LocalDate DOB, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.email = email;
    }

    public StudentData(String name, Integer age, LocalDate DOB, String email) {
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.DOB, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "studentData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                '}';
    }
}
