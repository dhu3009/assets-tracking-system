package com.dhu.ats.service;

import com.dhu.ats.mapper.OrganizationMapper;
import com.dhu.ats.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    public OrganizationMapper organizationMapper;

//    public List<Organization> getAllOrganization(){
//        return organizationMapper.getAllOrganization();
//    }

    public List<Organization> getOrganizationByLayer(int layer){
        return organizationMapper.getOrganizationByLayer(layer);
    }

    public List<Organization> getOrganizationByLayerAndParentCondition(int layer,int parentLeft,int parentRight){
        return organizationMapper.getOrganizationByLayerAndParentCondition(layer,parentLeft,parentRight);
    }
}
