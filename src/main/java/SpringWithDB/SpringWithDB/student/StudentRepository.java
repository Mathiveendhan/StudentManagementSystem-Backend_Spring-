package SpringWithDB.SpringWithDB.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentData,Long> {

    @Query("SELECT s FROM StudentData s WHERE s.email = ?1")
    Optional<StudentData> findStudentByEmail(String email);

}
