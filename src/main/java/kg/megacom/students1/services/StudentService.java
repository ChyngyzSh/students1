package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    StudentDTO createStudent(Student student);

    List<StudentDTO>findAll();

    Student update(Student student);
}
