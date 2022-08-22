package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.LessonDTO;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.services.LessonService;
import kg.megacom.students1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/create")
    public LessonDTO createLesson(@RequestBody Lesson lesson){
        return lessonService.createLesson(lesson);
    }
}
