package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.models.dto.StudentGroupDTO;
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
public class StudentGroupMapper {
    private final ModelMapper modelMapper;

    public StudentGroup toEntity(StudentGroupDTO studentGroupDTO){
        return Objects.isNull(studentGroupDTO) ? null: modelMapper.map(studentGroupDTO, StudentGroup.class);
    }

    public StudentGroupDTO toDTO(StudentGroup studentGroup){
        return Objects.isNull(studentGroup) ? null : modelMapper.map(studentGroup, StudentGroupDTO.class);
    }
    public List<StudentGroupDTO> toDTOList(List<StudentGroup>studentGroupList){
        return studentGroupList.stream()
                .map(studentGroup -> modelMapper.map(studentGroup, StudentGroupDTO.class))
                .collect(Collectors.toList());
    }

    public List<StudentGroup> toEntityList(List<StudentGroupDTO>studentGroupDTOList){
        return studentGroupDTOList.stream()
                .map(studentGroupDTO -> modelMapper.map(studentGroupDTO, StudentGroup.class))
                .collect(Collectors.toList());
    }

}
