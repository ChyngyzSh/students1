package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.CourseMapper2;
import kg.megacom.students1.mappers.v2.GroupMapper2;
import kg.megacom.students1.mappers.v2.TeacherMapper2;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;

import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements GroupMapper2 {
    CourseMapper2 courseMapper;
    TeacherMapper2 teacherMapper;

    @Override
    public Group fromDto(GroupDTO groupDto) {
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        group.setCourse(courseMapper.fromDto(groupDto.getCourse()));
        group.setTeacher(teacherMapper.fromDto(groupDto.getTeacher()));
        group.setStartDate(groupDto.getStartDate());
        group.setEndDate(groupDto.getEndDate());
        return group;
    }

    @Override
    public GroupDTO toDto(Group group) {
        GroupDTO groupDto = new GroupDTO();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setCourse(courseMapper.toDto(group.getCourse()));
        //groupDto.setCourse(courseMapper.toDto(group.getCourse()));
        groupDto.setTeacher(teacherMapper.toDto(group.getTeacher()));
        //groupDto.setTeacher_id(teacherMapper.toDto(group.getTeacher()));
        groupDto.setStartDate(group.getStartDate());
        groupDto.setEndDate(group.getEndDate());
        return groupDto;
    }
    @Override
    public List<Group> fromDtos(List<GroupDTO> groupDtos) {
        List<Group>groups = new ArrayList<>();
        for (GroupDTO item : groupDtos) {
            Group group = fromDto(item);
            groups.add(group);
        }
        return groups;
    }

    @Override
    public List<GroupDTO> toDtos(List<Group> groups) {
        List<GroupDTO>groupDtos = new ArrayList<>();
        for (Group item : groups) {
            GroupDTO groupDto = toDto(item);
            groupDtos.add(groupDto);
        }
        return groupDtos;
    }
}
