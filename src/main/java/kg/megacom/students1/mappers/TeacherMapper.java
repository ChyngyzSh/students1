package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;
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
public class TeacherMapper {
    private final ModelMapper modelMapper;

    public Teacher toEntity(TeacherDTO teacherDTO){
        return Objects.isNull(teacherDTO) ? null: modelMapper.map(teacherDTO, Teacher.class);
    }

    public TeacherDTO toDTO(Teacher teacher){
        return Objects.isNull(teacher) ? null : modelMapper.map(teacher, TeacherDTO.class);
    }

    public List<TeacherDTO> toDTOList(List<Teacher>teacherList){
        return teacherList.stream()
                .map(teacher -> modelMapper.map(teacher, TeacherDTO.class))
                .collect(Collectors.toList());
    }
    public List<Teacher> toEntityList(List<TeacherDTO>teacherDTOList){
        return teacherDTOList.stream()
                .map(teacherDTO -> modelMapper.map(teacherDTO, Teacher.class))
                .collect(Collectors.toList());
    }
}
