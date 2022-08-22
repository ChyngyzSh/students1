package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;

import java.util.List;

public interface TeacherMapper2 {
    Teacher fromDto(TeacherDTO teacherDto);
    TeacherDTO toDto(Teacher  teacher);

    List<Teacher> fromDtos(List<TeacherDTO>teacherDtos);
    List<TeacherDTO> toDtos(List<Teacher>teachers);
}
