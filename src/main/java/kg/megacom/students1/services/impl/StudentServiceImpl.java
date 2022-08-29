package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDTO;
import kg.megacom.students1.services.StudentService;
import kg.megacom.students1.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return studentRepo.save(student);
    }

    @Override
    public Student update2(Long id, String title) {

        studentRepo.update(id, title);
        return studentRepo.findById(id).get();
    }

    @Override
    public Student update3(Long id, String title) {
        Optional<Student> student = studentRepo.findById(id);
        student.get().setTitle(title);
        return studentRepo.save(student.get());
    }

    @Override
    public void delete(Long id) {
        studentRepo.delete(studentRepo.findById(id).get()); // 1-version
    }

    @Override
    public Student delete2(Long id) { // 2-version
        Student student = studentRepo.findById(id).get();
        student.setDeleted(true);
        studentRepo.save(student);
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findDeleted(){
        return  studentRepo.findAllByIsDeletedIsTrue();
    }

    @Override
    public Student findByID(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow();
    }


}

//        Student newStudent =  new Student();
//        newStudent.setId(student.getId());
//        newStudent.setName(student.getName());
//        newStudent.setSurname(student.getSurname());
//        newStudent.setTitle(student.getTitle());
//        studentRepo.save(newStudent);
