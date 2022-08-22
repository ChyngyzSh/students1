package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.services.StudentService;
import kg.megacom.students1.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher){

        return teacherService.createTeacher(teacher);
    }
}
