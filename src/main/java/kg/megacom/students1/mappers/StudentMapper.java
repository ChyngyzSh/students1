package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;

import java.util.List;

public interface StudentMapper {

    Student fromDto(StudentDto studentDto);
    StudentDto toDto(Student student);

    List<Student> fromDtos(List<StudentDto>studentDtos);
    List<StudentDto> toDtos(List<Student>students);
}
