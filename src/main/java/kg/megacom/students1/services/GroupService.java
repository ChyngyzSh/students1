package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    GroupDTO createGroup(Group group);

    List<Group> findAll();
}
