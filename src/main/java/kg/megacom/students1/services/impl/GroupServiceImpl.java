package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
//    @Autowired
//    GroupRepo groupRepo;
    private final GroupRepo groupRepo;

    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepo groupRepo, GroupMapper groupMapper) {
        this.groupRepo = groupRepo;
        this.groupMapper = groupMapper;
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


}
