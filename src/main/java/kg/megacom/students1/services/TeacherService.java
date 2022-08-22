package kg.megacom.students1.services;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;

public interface TeacherService {
    TeacherDTO createTeacher(Teacher teacher);
}
