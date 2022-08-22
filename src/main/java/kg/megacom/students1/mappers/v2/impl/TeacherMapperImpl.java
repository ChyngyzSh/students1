package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.TeacherMapper2;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapperImpl implements TeacherMapper2 {
    @Override
    public Teacher fromDto(TeacherDTO teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setTitle(teacherDto.getTitle());
        return teacher;
    }

    @Override
    public TeacherDTO toDto(Teacher teacher) {
        TeacherDTO teacherDto = new TeacherDTO();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setSurname(teacher.getSurname());
        teacherDto.setTitle(teacher.getTitle());
        return teacherDto;
    }

    @Override
    public List<Teacher> fromDtos(List<TeacherDTO> teacherDtos) {
        List<Teacher>teachers = new ArrayList<>();
        for (TeacherDTO item : teacherDtos) {
            Teacher teacher = fromDto(item);
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public List<TeacherDTO> toDtos(List<Teacher> teachers) {
        List<TeacherDTO>teacherDtos = new ArrayList<>();
        for (Teacher item: teachers) {
            TeacherDTO teacherDto = toDto(item);
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }
}
