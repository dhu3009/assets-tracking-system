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
        List<Organization> rootList = organizationService.getOrganizationByLayer(1);
        for (Organization root :
                rootList) {
            List<Organization> departments = organizationService.getOrganizationByLayerAndParentCondition(root.getLayer()+1,
                    root.getLeft(),root.getRight());
            for (Organization department :
                    departments) {
                List<Organization> personList =  organizationService.getOrganizationByLayerAndParentCondition(department.getLayer()+1,
                        department.getLeft(),department.getRight());
                department.setPersons(personList);
            }
            root.setDepartments(departments);
        }
        return rootList;
    }

}
