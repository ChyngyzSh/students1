package kg.megacom.students1.controllers;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    GroupMapper groupMapper;

    @GetMapping("/findAll")
    public List<Group> findAll(){
        return groupService.findAll();
    }
    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }

    @PostMapping("/create/v2")
    public Group createGroupV2(@RequestBody GroupDto groupDto){
        return groupService.createGroup(groupMapper.fromDto(groupDto));
    }




}
