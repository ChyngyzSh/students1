package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;
import kg.megacom.students1.services.TeacherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
//    @Autowired
//    private TeacherService teacherService;

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public TeacherDTO createTeacher(@RequestBody Teacher teacher){

        return teacherService.createTeacher(teacher);
    }
}
