package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.models.dto.GroupDto;

import java.util.List;

public interface GroupMapper {

    Group fromDto(GroupDto groupDto);
    GroupDto toDto(Group  group);

    List<Group> fromDtos(List<GroupDto>groupDtos);
    List<GroupDto> toDtos(List<Group>groups);
}
