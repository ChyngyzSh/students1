package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.CourseMapper2;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseMapperImpl implements CourseMapper2 {
    @Override
    public Course fromDto(CourseDTO courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setPrice(courseDto.getPrice());
        course.setDuration(courseDto.getDuration());
        return course;
    }

    @Override
    public CourseDTO toDto(Course course) {
        CourseDTO courseDto = new CourseDTO();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setPrice(course.getPrice());
        courseDto.setDuration(course.getDuration());
        return courseDto;
    }

    @Override
    public List<Course> fromDtos(List<CourseDTO> courseDtos) {
        List<Course> courses = new ArrayList<>();
        for (CourseDTO item: courseDtos) {
            Course course = fromDto(item);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<CourseDTO> toDtos(List<Course> courses) {
        List<CourseDTO> courseDtos = new ArrayList<>();
        for (Course item: courses) {
            CourseDTO courseDto = toDto(item);
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }
}
