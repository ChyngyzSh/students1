package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;

import java.util.List;

public interface StudentMapper2 {

    Student fromDto(StudentDTO studentDto);
    StudentDTO toDto(Student student);

    List<Student> fromDtos(List<StudentDTO>studentDtos);
    List<StudentDTO> toDtos(List<Student>students);
}
