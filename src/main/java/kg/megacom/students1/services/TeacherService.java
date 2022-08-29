package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    TeacherDTO createTeacher(Teacher teacher);

    Teacher update(Long id, String title);

    void delete(Long id);

    List<TeacherDTO> findAll();

    Teacher fyndById(Long id);
}
