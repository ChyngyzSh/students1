package kg.megacom.students1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date startDate;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date endDate;


}
