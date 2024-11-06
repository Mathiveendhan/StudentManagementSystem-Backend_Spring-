package SpringWithDB.SpringWithDB.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping()
    public List<StudentData> hello(){
        return studentservice.getStudent();
    }


    @PostMapping("/addStudent")
    public void registerNewStudent(@RequestBody StudentData student){
        studentservice.addNewStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentID){
        studentservice.DeleteStudent(StudentID);
    }

    @PutMapping("/updateStudent/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentID,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        studentservice.updateStudent(studentID,name,email);
    }
}
