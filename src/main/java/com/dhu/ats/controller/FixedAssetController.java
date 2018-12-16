package com.dhu.ats.controller;

import com.dhu.ats.model.FixedAsset;
import com.dhu.ats.service.FixedAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FixedAssetController {
    @Autowired
    public FixedAssetService fixedAssetService;


    @RequestMapping(value = {"/fixedasset"},method = RequestMethod.POST)
    public boolean createFixedAsset(@RequestBody FixedAsset fixedAsset){
        if(fixedAsset.getAssetName()!=null&&fixedAsset.getAssignDate()!=null&&fixedAsset.getOrgId()!=null&&fixedAsset.getState()!=null){
            int result=fixedAssetService.createFixedAsset(fixedAsset);
            if(result==0) return false;
            return true;
        }
        return false;
    }
}
