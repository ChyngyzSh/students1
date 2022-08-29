package kg.megacom.students1.services;

import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface StudentGroupService {
    StudentGroupDTO create(StudentGroup studentGroup);

    ResponseEntity create2(Date startDate, Date endDate, Long studentId, Long groupId);

    StudentGroup create3(Long studentId, Long groupId);

}
