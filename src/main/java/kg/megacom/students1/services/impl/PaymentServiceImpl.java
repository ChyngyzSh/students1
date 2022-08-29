package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.PaymentMapper;
import kg.megacom.students1.models.*;
import kg.megacom.students1.models.dto.PaymentDTO;
import kg.megacom.students1.models.enums.PaymentStatus;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.repositories.PaymentRepo;
import kg.megacom.students1.repositories.StudentRepo;
import kg.megacom.students1.services.GroupService;
import kg.megacom.students1.services.LessonService;
import kg.megacom.students1.services.PaymentService;
import kg.megacom.students1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final LessonService lessonService;
    private final StudentService studentService;
    private final GroupService groupService;
    @Autowired
    PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepo paymentRepo, LessonService lessonService, StudentService studentService
            , GroupService groupService) {
        this.paymentRepo = paymentRepo;
        this.lessonService = lessonService;
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @Override
    public PaymentDTO create(Payment payment) {
        paymentRepo.save(payment);
        return paymentMapper.toDTO(payment);
    }

    @Override
    public ResponseEntity create2(Date paymentDate, Long studentId, Long groupId, double installment) {
        try {
            Student student2 = studentService.findByID(studentId);
            if(student2.isDeleted()){
                return ResponseEntity.ok("Student is deleted. Cannot pay");
            }
            if(installment == 0) {
                return ResponseEntity.ok("Внесите сумму для оплаты");
            }
            Payment payment = new Payment();
            payment.setPaymentDate(paymentDate);
            payment.setStudent(studentService.findByID(studentId));
            payment.setGroup(groupService.findByID(groupId));
            payment.setInstallment(installment);

            if(installment < groupService.findByID(groupId).getCourse().getPrice()){
                payment.setStatus(PaymentStatus.PARTIALLY);
            }
            else if (installment >= groupService.findByID(groupId).getCourse().getPrice()) {
                    payment.setStatus(PaymentStatus.PAID);
            }
            return ResponseEntity.ok(paymentRepo.save(payment));
        }catch (Exception e){
            return ResponseEntity.ok("Student doesn't exist. Payment cannot be done");
        }
    }

    @Override
    public List<Payment> setPayment(Student student, Group group) {
        List<Lesson>lessons = lessonService.findLessonByGroup(group);
        List<Payment> payments = new ArrayList<>();

        for(int i=0; i< lessons.size(); i++){
            if(i % group.getCourse().getPeriod() == 0){
                Payment payment = new Payment();
                payment.setStudent(student);
                payment.setGroup(group);
                payment.setPaymentDate(lessons.get(i).getDay());
                payment.setStatus(PaymentStatus.UNPAID);
                payments.add(payment);
            }
        }
        payments=paymentRepo.saveAll(payments);
        return payments;
    }


//    @Override
//    public ResponseEntity create3(Date paymentDate, Long studentId, Long groupId, double installment) {
//        try {
//            Student student = studentRepo.findById(studentId).get();
//            if(student.isDeleted()){
//                return ResponseEntity.ok("Student is deleted. Cannot pay");
//            }
//            if(installment == 0) {
//                return ResponseEntity.ok("Внесите сумму для оплаты");
//            }
//            Payment payment = new Payment();
//            payment.setPaymentDate(paymentDate);
//            payment.setStudent(studentRepo.findById(studentId).get());
//            payment.setGroup(groupRepo.findById(groupId).get());
//            payment.setInstallment(installment);
//            if(studentRepo.findById(studentId).get().getDebt()==0){
//                if(installment < groupRepo.findById(groupId).get().getCourse().getPrice()){
//                    payment.setStatus(PaymentStatus.PARTIALLY);
//                }
//            }else if (installment >= studentRepo.findById(studentId).get().getDebt()){
//                payment.setStatus(PaymentStatus.PAID);
//            }
//            else {
//                payment.setStatus(PaymentStatus.PARTIALLY);
//                studentRepo.findById(studentId).get().setDebt((groupRepo.findById(groupId).get().getCourse().getPrice() - installment));
//                studentRepo.save(student);
//                ResponseEntity.ok("остаток долга за оплату= "+ studentRepo.findById(studentId).get().getDebt());
//            }
//            return ResponseEntity.ok(paymentRepo.save(payment));
//        }catch (Exception e){
//            return ResponseEntity.ok("Student doesn't exist. Payment cannot be done");
//        }
//    }
}
