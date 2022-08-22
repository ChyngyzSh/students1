package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.repositories.TeacherRepo;
import kg.megacom.students1.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacher.setId(teacher.getId());
        teacher.setName(teacher.getName());
        teacher.setSurname(teacher.getSurname());
        teacher.setTitle(teacher.getTitle());
        teacherRepo.save(teacher);

//        Teacher newTeacher =  new Teacher();
//        newTeacher.setId(teacher.getId());
//        newTeacher.setName(teacher.getName());
//        newTeacher.setSurname(teacher.getSurname());
//        newTeacher.setTitle(teacher.getTitle());
//        teacherRepo.save(newTeacher);
        return teacher;
    }
}
