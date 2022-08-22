package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.mappers.LessonMapper;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDTO;
import kg.megacom.students1.repositories.LessonRepo;
import kg.megacom.students1.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonRepo lessonRepo;
    @Autowired
    LessonMapper lessonMapper;

    @Override
    public LessonDTO createLesson(Lesson lesson) {
        lessonRepo.save(lesson);
        return lessonMapper.toDTO(lesson);
    }
}
