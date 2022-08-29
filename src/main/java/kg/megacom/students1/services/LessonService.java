package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDTO;

import java.util.List;

public interface LessonService {
    LessonDTO createLesson(Lesson lesson);

    List<Lesson> saveAll(List<Lesson> lessons);

    List<Lesson>findLessonByGroup(Group group);
}
