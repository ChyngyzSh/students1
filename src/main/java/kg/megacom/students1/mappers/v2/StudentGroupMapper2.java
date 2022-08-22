package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDTO;

import java.util.List;

public interface StudentGroupMapper2 {

    StudentGroup fromDto(StudentGroupDTO studentGroupDto);
    StudentGroupDTO toDto(StudentGroup studentGroup);

    List<StudentGroup> fromDtos(List<StudentGroupDTO>studentGroupDtos);
    List<StudentGroupDTO> toDtos(List<StudentGroup>studentGroups);
}
