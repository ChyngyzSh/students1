package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.GroupDTO;
import kg.megacom.students1.models.enums.Day;
import kg.megacom.students1.models.requests.GroupRequest;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.services.CourseService;
import kg.megacom.students1.services.GroupService;
import kg.megacom.students1.services.LessonService;
import kg.megacom.students1.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
//    @Autowired
//    GroupRepo groupRepo;
    private final GroupRepo groupRepo;

    private final GroupMapper groupMapper;
    private final CourseService courseService;
    private final LessonService lessonService;
    private final TeacherService teacherService;

    public GroupServiceImpl(GroupRepo groupRepo, GroupMapper groupMapper, CourseService courseService, LessonService lessonService, TeacherService teacherService) {
        this.groupRepo = groupRepo;
        this.groupMapper = groupMapper;
        this.courseService = courseService;
        this.lessonService = lessonService;
        this.teacherService = teacherService;
    }

    @Override
    public GroupDTO createGroup(Group group) {

        groupRepo.save(group);
        return groupMapper.toDTO(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    private List<Date>getLessonsDates(List<Day>days, int duration, Date startDate){
        List<Date> dates =new ArrayList<>();
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(startDate);

        for(int i=0; i<duration; ){
            long count=days
                    .stream()
                    .map(x->x.getDayValue())
                    .filter(x-> x == calendar.get(Calendar.DAY_OF_WEEK))
                    .count();
            if(count ==1){
                i++;
                dates.add(calendar.getTime());

            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
            //System.out.println(calendar);
        }
        return dates;
    }
    @Override
    public Group create(GroupRequest groupRequest) {
        //GroupRequest(groupTitle=Java 18:00, courseId=1, startDate=Thu Sep 01 06:00:00 ALMT 2022, days=[MONDAY, WEDNESDAY, FRIDAY])

        // Найти курс по ID
        // duration не должен быть пустой или меньше или равно 0
        // Получить список дат уроков
        // insert into groups
        // insert into lessons
        Course course = courseService.fyndById(groupRequest.getCourseId());
        Teacher teacher = teacherService.fyndById(groupRequest.getTeacherId());


        if (course.getDuration() <= 0) {
            throw new RuntimeException("Длительность курса не может быть меньше или равно 0");
        }
        List<Date>lessonsDates =getLessonsDates(groupRequest.getDays(),course.getDuration(),groupRequest.getStartDate());
//1-вариант
//        Date maxDate1 = lessonsDates
//                .stream()
//                .max((a,b) -> a.compareTo(b))
//                .get();

        Date maxDate1 = lessonsDates
                .stream()
                .max(Date::compareTo)
                .get();

//2-вариант
        Date maxDate2 = lessonsDates.get(course.getDuration()-1);
        Date maxDate3 = lessonsDates.get(lessonsDates.size()-1);
        Date minDate = lessonsDates.get(0);
        System.out.println(maxDate1);
        System.out.println(maxDate2);

        Group group = new Group();
        group.setCourse(course);
        group.setTeacher(teacher);
        group.setName(groupRequest.getGroupTitle());
        //group.setStartDate(groupRequest.getStartDate());
        group.setStartDate(minDate);
        group.setEndDate(maxDate1);

        group=groupRepo.save(group);

        Group finalGroup = group;
        List<Lesson>lessonList=lessonsDates
                .stream()
                .map(x ->{
                    Lesson lesson = new Lesson();
                    lesson.setDay(x);
                    lesson.setGroup(finalGroup);
                    return lesson;
                })
                .collect(Collectors.toList());
        lessonService.saveAll(lessonList);
        return group;
    }

    @Override
    public Group findByID(Long groupId) {
        return groupRepo.findById(groupId).orElseThrow();
    }


}
