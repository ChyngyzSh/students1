package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.LessonDTO;
import kg.megacom.students1.models.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Mapper
@RequiredArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;
    public Payment toEntity(PaymentDTO paymentDTO){
        return Objects.isNull(paymentDTO) ? null: modelMapper.map(paymentDTO, Payment.class);
    }

    public PaymentDTO toDTO(Payment payment){
        return Objects.isNull(payment) ? null : modelMapper.map(payment, PaymentDTO.class);
    }
    public List<PaymentDTO> toDTOList(List<Payment>paymentList){
        return paymentList.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }
    public List<Payment> toEntityList(List<PaymentDTO>paymentDTOList){
        return paymentDTOList.stream()
                .map(paymentDTO -> modelMapper.map(paymentDTO, Payment.class))
                .collect(Collectors.toList());
    }
}
