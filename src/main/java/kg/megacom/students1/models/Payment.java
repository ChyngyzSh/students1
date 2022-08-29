package kg.megacom.students1.models;

import kg.megacom.students1.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    double installment;
    //double debt;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    @Enumerated(value = EnumType.STRING)
    PaymentStatus status;
}
