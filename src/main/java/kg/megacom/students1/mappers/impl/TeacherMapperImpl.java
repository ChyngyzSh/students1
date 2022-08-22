package kg.megacom.students1.mappers.impl;

import kg.megacom.students1.mappers.TeacherMapper;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapperImpl implements TeacherMapper {
    @Override
    public Teacher fromDto(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setTitle(teacherDto.getTitle());
        return teacher;
    }

    @Override
    public TeacherDto toDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setSurname(teacher.getSurname());
        teacherDto.setTitle(teacher.getTitle());
        return teacherDto;
    }

    @Override
    public List<Teacher> fromDtos(List<TeacherDto> teacherDtos) {
        List<Teacher>teachers = new ArrayList<>();
        for (TeacherDto item : teacherDtos) {
            Teacher teacher = fromDto(item);
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public List<TeacherDto> toDtos(List<Teacher> teachers) {
        List<TeacherDto>teacherDtos = new ArrayList<>();
        for (Teacher item: teachers) {
            TeacherDto teacherDto = toDto(item);
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }
}
