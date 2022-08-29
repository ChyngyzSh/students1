package kg.megacom.students1.repositories;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepo extends JpaRepository<StudentGroup, Long> {

    StudentGroup findByStudentAndGroup(Student student, Group group);
}
