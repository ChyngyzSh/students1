package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;

import java.util.List;

public interface GroupMapper2 {

    Group fromDto(GroupDTO groupDto);
    GroupDTO toDto(Group  group);

    List<Group> fromDtos(List<GroupDTO>groupDtos);
    List<GroupDTO> toDtos(List<Group>groups);
}
