package kg.megacom.students1.services;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDTO;

public interface LessonService {
    LessonDTO createLesson(Lesson lesson);
}
