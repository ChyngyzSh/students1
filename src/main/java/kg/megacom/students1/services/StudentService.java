package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    StudentDTO createStudent(Student student);

    List<StudentDTO>findAll();

    Student update(Student student);

    Student update2(Long id, String title);
    Student update3(Long id, String title);

    void delete(Long id);
    Student delete2(Long id);

    List<Student> findDeleted();

    Student findByID(Long studentId);
}
