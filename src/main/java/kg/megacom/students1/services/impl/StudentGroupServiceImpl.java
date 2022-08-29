package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentGroupMapper;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDTO;
import kg.megacom.students1.models.enums.StudentStatus;
import kg.megacom.students1.repositories.StudentGroupRepo;
import kg.megacom.students1.services.GroupService;
import kg.megacom.students1.services.PaymentService;
import kg.megacom.students1.services.StudentGroupService;
import kg.megacom.students1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepo studentGroupRepo;
    private final StudentService studentService;
    private final GroupService groupService;
    private final PaymentService paymentService;
    @Autowired
    StudentGroupMapper studentGroupMapper;

    public StudentGroupServiceImpl(StudentGroupRepo studentGroupRepo, StudentService studentService, GroupService groupService, PaymentService paymentService) {
        this.studentGroupRepo = studentGroupRepo;
        this.studentService = studentService;
        this.groupService = groupService;
        this.paymentService = paymentService;
    }

    @Override
    public StudentGroupDTO create(StudentGroup studentGroup) {
        studentGroupRepo.save(studentGroup);
        return studentGroupMapper.toDTO(studentGroup);
    }
    @Override
    public ResponseEntity create2(Date startDate, Date endDate, Long studentId, Long groupId) {
        try {
            Student student = studentService.findByID(studentId);

            if(student.isDeleted()) {
                return ResponseEntity.ok("Student is deleted");
            }
            StudentGroup studentGroup = new StudentGroup();
            //studentGroup.setStudent(studentRepo.findById(studentId).get());
            studentGroup.setStudent(studentService.findByID(studentId));
            //studentGroup.setGroup(groupRepo.findById(groupId).get());
            studentGroup.setGroup(groupService.findByID(groupId));
            studentGroup.setStartDate(startDate);
            studentGroup.setEndDate(endDate);
            studentGroup.setStatus(StudentStatus.STUDIES);
            return ResponseEntity.ok(studentGroupRepo.save(studentGroup));
        }catch (Exception e){
            return ResponseEntity.ok("Student doesn't exists");
        }
    }

    @Override
    public StudentGroup create3(Long studentId, Long groupId) {
        Student student3 = studentService.findByID(studentId);
        Group group3 = groupService.findByID(groupId);

        if(group3.getEndDate().compareTo(new Date()) <= 0)
            throw new RuntimeException("Группа уже завершила обучение");

        StudentGroup studentGroup3 = studentGroupRepo.findByStudentAndGroup(student3, group3);

        if(studentGroup3 == null){
            studentGroup3 = new StudentGroup();
            studentGroup3.setStudent(student3);
            studentGroup3.setGroup(group3);
            studentGroup3.setStartDate(new Date());
            studentGroup3.setStatus(StudentStatus.STUDIES);

            studentGroup3=studentGroupRepo.save(studentGroup3);

            List<Payment>payments = paymentService.setPayment(student3, group3);
            System.out.println(payments);
        }else {
            if(studentGroup3.getStatus().equals(StudentStatus.STUDIES))
                throw  new RuntimeException("Студент уже в группе");
            else {
                studentGroup3.setStatus(StudentStatus.STUDIES);
                studentGroupRepo.save(studentGroup3);
            }
        }
        return studentGroup3;
    }
}
