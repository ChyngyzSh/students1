package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.models.dto.TeacherDTO;
import kg.megacom.students1.services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<TeacherDTO> findAll(){
        return teacherService.findAll();
    }

    @PutMapping("/update")
    public Teacher update(@RequestParam Long id, @RequestParam String title){
        return teacherService.update(id, title);
    }

    @DeleteMapping("/delete")
    void  delete(@RequestParam Long id){
        teacherService.delete(id);
    }
}
