package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;

import java.util.List;

public interface GroupService {
    Group createGroup(Group group);

    List<Group> findAll();
}
