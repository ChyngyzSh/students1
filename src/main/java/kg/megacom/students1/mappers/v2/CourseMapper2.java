package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDTO;

import java.util.List;

public interface CourseMapper2 {
    Course fromDto(CourseDTO courseDto);
    CourseDTO toDto(Course course);

    List<Course> fromDtos(List<CourseDTO>courseDtos);
    List<CourseDTO> toDtos(List<Course>courses);

}
/*
    Author fromDto(AuthorDto authorDto);
    AuthorDto toDto(Author author);

    List<Author>fromDtos (List<AuthorDto>authorDtos);

    List<AuthorDto>toDtos (List<Author>authors);
 */