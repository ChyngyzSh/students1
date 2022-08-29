package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.PaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface PaymentService {
    PaymentDTO create(Payment payment);

    ResponseEntity create2(Date paymentDate, Long studentId, Long groupId, double installment);
    //ResponseEntity create3(Date paymentDate, Long studentId, Long groupId, double installment);

    List<Payment> setPayment(Student student, Group group);
}
