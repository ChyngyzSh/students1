package kg.megacom.students1.services;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(Course course);

    List<Course> findAll();

    Course fyndById(Long id);
}
