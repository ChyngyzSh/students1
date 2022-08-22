package kg.megacom.students1.mappers;

import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDto;

import java.util.List;

public interface StudentGroupMapper {

    StudentGroup fromDto(StudentGroupDto studentGroupDto);
    StudentGroupDto toDto(StudentGroup studentGroup);

    List<StudentGroup> fromDtos(List<StudentGroupDto>studentGroupDtos);
    List<StudentGroupDto> toDtos(List<StudentGroup>studentGroups);
}
