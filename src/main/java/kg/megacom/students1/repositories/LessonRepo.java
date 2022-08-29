package kg.megacom.students1.repositories;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByGroupOrderById(Group group);
}
