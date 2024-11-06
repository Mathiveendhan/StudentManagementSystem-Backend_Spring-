package SpringWithDB.SpringWithDB.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentData>getStudent(){
        return studentRepository.findAll();
    }


    public void addNewStudent(StudentData student){
        Optional<StudentData> studentEmail=studentRepository.findStudentByEmail(student.getEmail());

        if(studentEmail.isPresent()){
            throw new IllegalStateException("Email present already");
        }
        studentRepository.save(student);
    }

    public void DeleteStudent(Long studentID) {
        boolean exist=studentRepository.existsById(studentID);

        if(!exist){
            throw new IllegalThreadStateException("Student id"+ studentID+"is doesn't exist");
        }
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        StudentData student=studentRepository.findById(studentID).orElseThrow(()->new IllegalStateException("Student id"+ studentID+"is doesn't exist"));

        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<StudentData> studentOptional=studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already exist");
            }
            student.setName(email);
        }
    }
}
