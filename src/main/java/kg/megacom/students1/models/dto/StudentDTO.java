package kg.megacom.students1.models.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
    Long id;
    String name;
    String surname;
    String title;
    boolean isDeleted;
    //double debt=0;
}
