package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;
import kg.megacom.students1.models.requests.GroupRequest;

import java.util.List;

public interface GroupService {
    GroupDTO createGroup(Group group);

    List<Group> findAll();

    Group create(GroupRequest groupRequest);

    Group findByID(Long groupId);
}
