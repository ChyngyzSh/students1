package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDTO;
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
public class CourseMapper {
    private final ModelMapper modelMapper;

    public Course toEntity(CourseDTO courseDTO){
        return Objects.isNull(courseDTO) ? null: modelMapper.map(courseDTO, Course.class);
    }

    public CourseDTO toDTO(Course course){
        return Objects.isNull(course) ? null : modelMapper.map(course, CourseDTO.class);
    }
    public List<CourseDTO> toDTOList(List<Course>courseList){
        return courseList.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    public List<Course> toEntityList(List<CourseDTO>courseDTOList){
        return courseDTOList.stream()
                .map(courseDTO -> modelMapper.map(courseDTO, Course.class))
                .collect(Collectors.toList());
    }
}
