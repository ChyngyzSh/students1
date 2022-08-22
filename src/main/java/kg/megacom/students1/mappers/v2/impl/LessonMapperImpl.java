package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.GroupMapper2;
import kg.megacom.students1.mappers.v2.LessonMapper2;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDTO;

import java.util.ArrayList;
import java.util.List;

public class LessonMapperImpl implements LessonMapper2 {
    GroupMapper2 groupMapper;

    @Override
    public Lesson fromDto(LessonDTO lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setDay(lessonDto.getDay());
        lesson.setGroup(groupMapper.fromDto(lessonDto.getGroup()));
        return lesson;
    }

    @Override
    public LessonDTO toDto(Lesson lesson) {
        LessonDTO lessonDto = new LessonDTO();
        lessonDto.setId(lesson.getId());
        lessonDto.setDay(lesson.getDay());
        lessonDto.setGroup(groupMapper.toDto(lesson.getGroup()));
        return lessonDto;
    }

    @Override
    public List<Lesson> fromDtos(List<LessonDTO> lessonDtos) {
        List<Lesson>lessons = new ArrayList<>();
        for (LessonDTO item : lessonDtos) {
            Lesson lesson = fromDto(item);
            lessons.add(lesson);
        }
        return lessons;
    }

    @Override
    public List<LessonDTO> toDtos(List<Lesson> lessons) {
        List<LessonDTO>lessonDtos = new ArrayList<>();
        for (Lesson item: lessons) {
            LessonDTO lessonDto = toDto(item);
            lessonDtos.add(lessonDto);
        }
        return lessonDtos;
    }
}
