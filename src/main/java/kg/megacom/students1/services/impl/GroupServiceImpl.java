package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepo groupRepo;

    @Override
    public Group createGroup(Group group) {
        group.setId(group.getId());
        group.setName(group.getName());
        group.setCourse(group.getCourse());
        group.setTeacher(group.getTeacher());
        group.setStartDate(group.getStartDate());
        group.setEndDate(group.getEndDate());
        groupRepo.save(group);

//        Group newGroup = new Group();
//        Course course=new Course();
//        newGroup.setId(group.getId());
//        newGroup.setName(group.getName());
//        newGroup.setCourse(group.getCourse());
//        newGroup.setTeacher(group.getTeacher());
//        newGroup.setStartDate(group.getStartDate());
//        newGroup.setEndDate(group.getEndDate());
//        groupRepo.save(newGroup);
        return group;
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }


}
