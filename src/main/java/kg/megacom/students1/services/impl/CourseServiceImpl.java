package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.repositories.CourseRepo;
import kg.megacom.students1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public Course createCourse(Course course) {
        course.setId(course.getId());
        course.setTitle(course.getTitle());
        course.setDuration(course.getDuration());
        course.setPrice(course.getPrice());
        courseRepo.save(course);

//        Course newCourse = new Course();
//        newCourse.setId(course.getId());
//        newCourse.setTitle(course.getTitle());
//        newCourse.setDuration(course.getDuration());
//        newCourse.setPrice(course.getPrice());
//        courseRepo.save(newCourse);
        return course;
    }
}
