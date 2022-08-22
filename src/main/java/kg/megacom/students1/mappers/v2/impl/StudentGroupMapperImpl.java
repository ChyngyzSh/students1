package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.GroupMapper2;
import kg.megacom.students1.mappers.v2.StudentGroupMapper2;
import kg.megacom.students1.mappers.v2.StudentMapper2;
import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupMapperImpl implements StudentGroupMapper2 {
    GroupMapper2 groupMapper;
    StudentMapper2 studentMapper;

    @Override
    public StudentGroup fromDto(StudentGroupDTO studentGroupDto) {
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
    public StudentGroupDTO toDto(StudentGroup studentGroup) {
        StudentGroupDTO studentGroupDto = new StudentGroupDTO();
        studentGroupDto.setId(studentGroup.getId());
        studentGroupDto.setStudent(studentMapper.toDto(studentGroup.getStudent()));
        studentGroupDto.setGroup(groupMapper.toDto(studentGroup.getGroup()));
        studentGroupDto.setStartDate(studentGroup.getStartDate());
        studentGroupDto.setEndDate(studentGroup.getEndDate());
        studentGroupDto.setStatus(studentGroup.getStatus());
        return studentGroupDto;
    }

    @Override
    public List<StudentGroup> fromDtos(List<StudentGroupDTO> studentGroupDtos) {
        List<StudentGroup>studentGroups = new ArrayList<>();
        for (StudentGroupDTO item : studentGroupDtos) {
            StudentGroup studentGroup = fromDto(item);
            studentGroups.add(studentGroup);
        }
        return studentGroups;
    }

    @Override
    public List<StudentGroupDTO> toDtos(List<StudentGroup> studentGroups) {
        List<StudentGroupDTO>studentGroupDtos = new ArrayList<>();
        for (StudentGroup item: studentGroups) {
            StudentGroupDTO studentGroupDto = toDto(item);
            studentGroupDtos.add(studentGroupDto);
        }
        return studentGroupDtos;
    }
}
