package kg.megacom.students1.mappers.v2.impl;

import kg.megacom.students1.mappers.v2.GroupMapper2;
import kg.megacom.students1.mappers.v2.PaymentMapper2;
import kg.megacom.students1.mappers.v2.StudentMapper2;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDTO;

import java.util.ArrayList;
import java.util.List;

public class PaymentMapperImpl implements PaymentMapper2 {
    GroupMapper2 groupMapper;
    StudentMapper2 studentMapper;

    @Override
    public Payment fromDto(PaymentDTO paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setGroup(groupMapper.fromDto(paymentDto.getGroup()));
        payment.setStudent(studentMapper.fromDto(paymentDto.getStudent()));
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setStatus(paymentDto.getStatus());
        return payment;
    }

    @Override
    public PaymentDTO toDto(Payment payment) {
        PaymentDTO paymentDto = new PaymentDTO();
        paymentDto.setId(payment.getId());
        paymentDto.setGroup(groupMapper.toDto(payment.getGroup()));
        paymentDto.setStudent(studentMapper.toDto(payment.getStudent()));
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setStatus(payment.getStatus());
        return paymentDto;
    }

    @Override
    public List<Payment> fromDtos(List<PaymentDTO> paymentDtos) {
        List<Payment>payments = new ArrayList<>();
        for (PaymentDTO item : paymentDtos) {
            Payment payment = fromDto(item);
            payments.add(payment);
        }
        return payments;
    }

    @Override
    public List<PaymentDTO> toDtos(List<Payment> payments) {
        List<PaymentDTO>paymentDtos = new ArrayList<>();
        for (Payment item : payments) {
            PaymentDTO paymentDto = toDto(item);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }
}
