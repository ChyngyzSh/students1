package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.CourseDTO;
import kg.megacom.students1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/all")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping("/create")
    public CourseDTO createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
}
