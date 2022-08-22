package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.GroupDTO;
import kg.megacom.students1.models.dto.LessonDTO;
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
public class LessonMapper {

    private final ModelMapper modelMapper;
    public Lesson toEntity(LessonDTO lessonDTO){
        return Objects.isNull(lessonDTO) ? null: modelMapper.map(lessonDTO, Lesson.class);
    }

    public LessonDTO toDTO(Lesson lesson){
        return Objects.isNull(lesson) ? null : modelMapper.map(lesson, LessonDTO.class);
    }
    public List<LessonDTO> toDTOList(List<Lesson>lessonList){
        return lessonList.stream()
                .map(lesson -> modelMapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }
    public List<Lesson> toEntityList(List<LessonDTO>lessonDTOList){
        return lessonDTOList.stream()
                .map(lessonDTO -> modelMapper.map(lessonDTO, Lesson.class))
                .collect(Collectors.toList());
    }
}
