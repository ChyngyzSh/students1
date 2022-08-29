package kg.megacom.students1.controllers;

import kg.megacom.students1.models.StudentGroup;
import kg.megacom.students1.models.dto.StudentGroupDTO;
import kg.megacom.students1.services.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/studgroup")
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;

//    @PostMapping("/create")
//    public StudentGroup createGroup(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate
//            , @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate
//            , @RequestParam Long studentId, @RequestParam Long groupId){
//        return studentGroupService.create2(startDate,endDate, studentId, groupId);
//    }

    @PostMapping("/create")
    public ResponseEntity createGroup(@RequestParam  @DateTimeFormat(pattern= "yyyy-MM-dd")Date startDate
            , @RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd")Date endDate
            , @RequestParam Long studentId, @RequestParam Long groupId){
        return studentGroupService.create2(startDate,endDate, studentId, groupId);
    }

    @PostMapping("/add")
    public StudentGroup createGroup3(@RequestParam Long studentId, @RequestParam Long groupId){
        return studentGroupService.create3(studentId, groupId);
    }
}
