package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.services.StudentService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }

    @GetMapping("/all")
    public List<StudentDTO> findAll(){
        return studentService.findAll();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }
}
