package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDTO;

import java.util.List;

public interface LessonMapper2 {
    Lesson fromDto(LessonDTO lessonDto);
    LessonDTO toDto(Lesson lesson);

    List<Lesson> fromDtos(List<LessonDTO>lessonDtos);
    List<LessonDTO> toDtos(List<Lesson>lessons);
}
