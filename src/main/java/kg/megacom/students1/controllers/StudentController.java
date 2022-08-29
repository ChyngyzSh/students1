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

    @GetMapping("/allDeleted")
    public List<Student> findAllDeleted(){
        return studentService.findDeleted();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }
    @PutMapping("/update2")
    public Student updateByID(@RequestParam Long id, @RequestParam String title){
        return studentService.update2(id, title);
    }

    @PutMapping("/update3")
    public Student updateByID2(@RequestParam Long id, @RequestParam String title){
        return studentService.update3(id, title);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam Long id){
        studentService.delete(id);
    }
    @DeleteMapping("/delete2")
    public Student delete2 (@RequestParam Long id){
        return studentService.delete2(id);
    }



}
