package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.TeacherMapper;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDTO;
import kg.megacom.students1.repositories.TeacherRepo;
import kg.megacom.students1.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

//    @Autowired
//    TeacherRepo teacherRepo;
    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper) {
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }



    @Override
    public TeacherDTO createTeacher(Teacher teacher) {
        teacherRepo.save(teacher);

        return teacherMapper.toDTO(teacher);
    }
}

//        teacher.setId(teacher.getId());
//        teacher.setName(teacher.getName());
//        teacher.setSurname(teacher.getSurname());
//        teacher.setTitle(teacher.getTitle());