package com.dhu.ats.service;

import com.dhu.ats.mapper.OrganizationMapper;
import com.dhu.ats.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    public OrganizationMapper organizationMapper;

    public List<Organization> getAllOrganization(){
        return organizationMapper.getAllOrganization();
    }

}
