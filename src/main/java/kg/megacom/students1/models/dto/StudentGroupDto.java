package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentGroupDto {
    Long id;
    StudentDto student;
    GroupDto group;
    Date startDate;
    Date endDate;
    StudentStatus status;
}
