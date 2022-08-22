package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Mapper
@RequiredArgsConstructor
public class GroupMapper {
    private final ModelMapper modelMapper;
    public Group toEntity(GroupDTO groupDTO){
        return Objects.isNull(groupDTO) ? null: modelMapper.map(groupDTO, Group.class);
    }

    public GroupDTO toDTO(Group group){
        return Objects.isNull(group) ? null : modelMapper.map(group, GroupDTO.class);
    }
    public List<GroupDTO> toDTOList(List<Group>groupList){
        return groupList.stream()
                .map(group -> modelMapper.map(group, GroupDTO.class))
                .collect(Collectors.toList());
    }
    public List<Group> toEntityList(List<GroupDTO>groupDTOList){
        return groupDTOList.stream()
                .map(groupDTO -> modelMapper.map(groupDTO, Group.class))
                .collect(Collectors.toList());
    }
}
