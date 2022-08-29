package kg.megacom.students1.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String title;
//    @Column(name = "debt")
//    double debt=0;
    @Column(name = "is_deleted", columnDefinition = "boolean default false" )
    private boolean isDeleted; // if true  - запись удалена, применяется при работе с настоящими БД
}
