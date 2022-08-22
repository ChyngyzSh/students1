package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.StudentMapper2;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentMapperImpl implements StudentMapper2 {
    @Override
    public Student fromDto(StudentDTO studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setTitle(studentDto.getTitle());
        return student;
    }

    @Override
    public StudentDTO toDto(Student student) {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setTitle(student.getTitle());
        return studentDto;
    }

    @Override
    public List<Student> fromDtos(List<StudentDTO> studentDtos) {
        List<Student>students = new ArrayList<>();
        for (StudentDTO item : studentDtos) {
            Student student = fromDto(item);
            students.add(student);
        }
        return students;
    }

    @Override
    public List<StudentDTO> toDtos(List<Student> students) {
        List<StudentDTO>studentDtos = new ArrayList<>();
        for (Student item: students) {
            StudentDTO studentDto = toDto(item);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }
}
