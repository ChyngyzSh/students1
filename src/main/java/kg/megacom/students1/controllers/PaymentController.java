package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDTO;
import kg.megacom.students1.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public PaymentDTO createPayment(@RequestBody Payment payment){
        return paymentService.create(payment);
    }


//    @PostMapping("/create2")
//    public ResponseEntity createPayment2(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd")Date paymentDate
//            , @RequestParam Long studentId, @RequestParam Long groupId){
//        return paymentService.create2(paymentDate, studentId, groupId);
//    }

    @PostMapping("/create2")
    public ResponseEntity createPayment2(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd")Date paymentDate
            , @RequestParam Long studentId, @RequestParam Long groupId, @RequestParam double installment){
        return paymentService.create2(paymentDate, studentId, groupId, installment);
    }

//    @PostMapping("/create3")
//    public ResponseEntity createPayment3(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd")Date paymentDate
//            , @RequestParam Long studentId, @RequestParam Long groupId, @RequestParam double installment){
//        return paymentService.create3(paymentDate, studentId, groupId, installment);
//    }
}
/*
public ResponseEntity createGroup(@RequestParam  Date startDate
            , @RequestParam Date endDate
            , @RequestParam Long studentId, @RequestParam Long groupId){
        return studentGroupService.create2(startDate,endDate, studentId, groupId);
    }

    GroupDTO group;
    StudentDTO student;
    Date paymentDate;
 */