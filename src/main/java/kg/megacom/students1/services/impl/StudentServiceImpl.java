package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.services.StudentService;
import kg.megacom.students1.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentDTO createStudent(Student student) {

        studentRepo.save(student);
        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student>studentList=studentRepo.findAll();
        return studentMapper.toDTOList(studentList);
    }

    @Override
    public Student update(Student student) {
//        if(student.getId()== null){
//            studentRepo.save(student);
//        }else
//            studentRepo.update(student);
        //studentRepo.save(student);
        return studentRepo.save(student);
    }
}

//        Student newStudent =  new Student();
//        newStudent.setId(student.getId());
//        newStudent.setName(student.getName());
//        newStudent.setSurname(student.getSurname());
//        newStudent.setTitle(student.getTitle());
//        studentRepo.save(newStudent);
