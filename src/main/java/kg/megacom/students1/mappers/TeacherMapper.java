package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.dto.TeacherDto;

import java.util.List;

public interface TeacherMapper {
    Teacher fromDto(TeacherDto teacherDto);
    TeacherDto toDto(Teacher  teacher);

    List<Teacher> fromDtos(List<TeacherDto>teacherDtos);
    List<TeacherDto> toDtos(List<Teacher>teachers);
}
