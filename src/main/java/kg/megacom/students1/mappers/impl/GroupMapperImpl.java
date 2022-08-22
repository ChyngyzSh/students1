package kg.megacom.students1.mappers.impl;

import kg.megacom.students1.mappers.CourseMapper;
import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.mappers.TeacherMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.models.dto.GroupDto;

import java.util.ArrayList;
import java.util.List;

public class GroupMapperImpl implements GroupMapper {
    CourseMapper courseMapper;
    TeacherMapper teacherMapper;

    @Override
    public Group fromDto(GroupDto groupDto) {
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
    public GroupDto toDto(Group group) {
        GroupDto groupDto = new GroupDto();
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
    public List<Group> fromDtos(List<GroupDto> groupDtos) {
        List<Group>groups = new ArrayList<>();
        for (GroupDto item : groupDtos) {
            Group group = fromDto(item);
            groups.add(group);
        }
        return groups;
    }

    @Override
    public List<GroupDto> toDtos(List<Group> groups) {
        List<GroupDto>groupDtos = new ArrayList<>();
        for (Group item : groups) {
            GroupDto groupDto = toDto(item);
            groupDtos.add(groupDto);
        }
        return groupDtos;
    }
}
