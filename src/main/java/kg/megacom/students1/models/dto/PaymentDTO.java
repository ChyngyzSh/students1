package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDTO {
    Long id;
    Date paymentDate;
    StudentDTO student;
    double installment;
    //double debt;
    GroupDTO group;
    PaymentStatus status;
}
