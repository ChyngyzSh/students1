package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDTO;
import kg.megacom.students1.models.requests.GroupRequest;
import kg.megacom.students1.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/all")
    public List<Group> findAll(){
        return groupService.findAll();
    }

    @PostMapping("/createGroup")
    public GroupDTO createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }


    @PostMapping("/create")
    public Group createGroup(@RequestBody GroupRequest groupRequest){
        return groupService.create(groupRequest);
    }



}
