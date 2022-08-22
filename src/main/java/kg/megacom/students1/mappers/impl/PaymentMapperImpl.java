package kg.megacom.students1.mappers.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.mappers.PaymentMapper;
import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.PaymentDto;
import kg.megacom.students1.models.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class PaymentMapperImpl implements PaymentMapper {
    GroupMapper groupMapper;
    StudentMapper studentMapper;

    @Override
    public Payment fromDto(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setGroup(groupMapper.fromDto(paymentDto.getGroup()));
        payment.setStudent(studentMapper.fromDto(paymentDto.getStudent()));
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setStatus(paymentDto.getStatus());
        return payment;
    }

    @Override
    public PaymentDto toDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setGroup(groupMapper.toDto(payment.getGroup()));
        paymentDto.setStudent(studentMapper.toDto(payment.getStudent()));
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setStatus(payment.getStatus());
        return paymentDto;
    }

    @Override
    public List<Payment> fromDtos(List<PaymentDto> paymentDtos) {
        List<Payment>payments = new ArrayList<>();
        for (PaymentDto item : paymentDtos) {
            Payment payment = fromDto(item);
            payments.add(payment);
        }
        return payments;
    }

    @Override
    public List<PaymentDto> toDtos(List<Payment> payments) {
        List<PaymentDto>paymentDtos = new ArrayList<>();
        for (Payment item : payments) {
            PaymentDto paymentDto = toDto(item);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }
}
