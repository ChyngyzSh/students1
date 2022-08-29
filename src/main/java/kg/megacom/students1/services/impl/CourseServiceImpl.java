package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.CourseMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDTO;
import kg.megacom.students1.repositories.CourseRepo;
import kg.megacom.students1.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO createCourse(Course course) {

        courseRepo.save(course);
        return courseMapper.toDTO(course);
//        Course newCourse = new Course();
//        newCourse.setId(course.getId());
//        newCourse.setTitle(course.getTitle());
//        newCourse.setDuration(course.getDuration());
//        newCourse.setPrice(course.getPrice());
//        courseRepo.save(newCourse);

    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course fyndById(Long id) {
        return courseRepo.findById(id).orElseThrow();
    }
}
