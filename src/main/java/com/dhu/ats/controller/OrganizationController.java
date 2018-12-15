package com.dhu.ats.controller;

import com.dhu.ats.model.Organization;
import com.dhu.ats.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    public OrganizationService organizationService;

    @RequestMapping(value={"/organization"},method = RequestMethod.GET)
    public List<Organization> getAllOrganization(){
        return organizationService.getAllOrganization();
    }

}
