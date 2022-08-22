package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;

import java.util.List;

public interface CourseMapper {
    Course fromDto(CourseDto courseDto);
    CourseDto toDto(Course course);

    List<Course> fromDtos(List<CourseDto>courseDtos);
    List<CourseDto> toDtos(List<Course>courses);

}
/*
    Author fromDto(AuthorDto authorDto);
    AuthorDto toDto(Author author);

    List<Author>fromDtos (List<AuthorDto>authorDtos);

    List<AuthorDto>toDtos (List<Author>authors);
 */