package kg.megacom.students1.repositories;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    //Student update(Student student);
    //List<Student> findStudentById(Long id);
}
