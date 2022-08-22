package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.StudentStatus;
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
public class StudentGroupDTO {
    Long id;
    StudentDTO student;
    GroupDTO group;
    Date startDate;
    Date endDate;
    StudentStatus status;
}
