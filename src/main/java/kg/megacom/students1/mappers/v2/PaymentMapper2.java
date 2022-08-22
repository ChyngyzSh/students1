package kg.megacom.students1.mappers.v2;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDTO;

import java.util.List;

public interface PaymentMapper2 {
    Payment fromDto(PaymentDTO paymentDto);
    PaymentDTO toDto(Payment payment);

    List<Payment> fromDtos(List<PaymentDTO>paymentDtos);
    List<PaymentDTO> toDtos(List<Payment>payments);
}
