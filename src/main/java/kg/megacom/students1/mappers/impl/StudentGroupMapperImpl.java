package kg.megacom.students1.mappers.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.mappers.StudentGroupMapper;
import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.StudentGroupDto;
import kg.megacom.students1.models.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupMapperImpl implements StudentGroupMapper {
    GroupMapper groupMapper;
    StudentMapper studentMapper;

    @Override
    public StudentGroup fromDto(StudentGroupDto studentGroupDto) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(studentGroupDto.getId());
        studentGroup.setStudent(studentMapper.fromDto(studentGroupDto.getStudent()));
        studentGroup.setGroup(groupMapper.fromDto(studentGroupDto.getGroup()));
        studentGroup.setStartDate(studentGroupDto.getStartDate());
        studentGroup.setEndDate(studentGroupDto.getEndDate());
        studentGroup.setStatus(studentGroupDto.getStatus());
        return studentGroup;
    }

    @Override
    public StudentGroupDto toDto(StudentGroup studentGroup) {
        StudentGroupDto studentGroupDto = new StudentGroupDto();
        studentGroupDto.setId(studentGroup.getId());
        studentGroupDto.setStudent(studentMapper.toDto(studentGroup.getStudent()));
        studentGroupDto.setGroup(groupMapper.toDto(studentGroup.getGroup()));
        studentGroupDto.setStartDate(studentGroup.getStartDate());
        studentGroupDto.setEndDate(studentGroup.getEndDate());
        studentGroupDto.setStatus(studentGroup.getStatus());
        return studentGroupDto;
    }

    @Override
    public List<StudentGroup> fromDtos(List<StudentGroupDto> studentGroupDtos) {
        List<StudentGroup>studentGroups = new ArrayList<>();
        for (StudentGroupDto item : studentGroupDtos) {
            StudentGroup studentGroup = fromDto(item);
            studentGroups.add(studentGroup);
        }
        return studentGroups;
    }

    @Override
    public List<StudentGroupDto> toDtos(List<StudentGroup> studentGroups) {
        List<StudentGroupDto>studentGroupDtos = new ArrayList<>();
        for (StudentGroup item: studentGroups) {
            StudentGroupDto studentGroupDto = toDto(item);
            studentGroupDtos.add(studentGroupDto);
        }
        return studentGroupDtos;
    }
}
