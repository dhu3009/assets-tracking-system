package com.dhu.ats.controller;

import com.dhu.ats.model.FixedAsset;
import com.dhu.ats.service.FixedAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"/fixedasset/{assetId}"},method = RequestMethod.DELETE)
    public boolean deleteFixedAssetById(@PathVariable(name = "assetId") int assetId){
        int result = fixedAssetService.deleteFixedAssetById(assetId);
        if(result==0) return false;
        return true;
    }
}
