package com.notes.controller;

import com.notes.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/getGroupsName")
    public String[] getGroups(String account){
        return groupService.getGroupsName(account);
    }


}
