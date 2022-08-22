package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.services.StudentService;
import kg.megacom.students1.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student createStudent(Student student) {
        //Student newStudent =  new Student();
        student.setId(student.getId());
        student.setName(student.getName());
        student.setSurname(student.getSurname());
        student.setTitle(student.getTitle());
        studentRepo.save(student);

//        Student newStudent =  new Student();
//        newStudent.setId(student.getId());
//        newStudent.setName(student.getName());
//        newStudent.setSurname(student.getSurname());
//        newStudent.setTitle(student.getTitle());
//        studentRepo.save(newStudent);

        return student;
    }
}
