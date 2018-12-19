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
        if(fixedAsset.getAssetName()!=null&&fixedAsset.getAssignDate()!=null&&fixedAsset.getState()!=null&&fixedAsset.getSmallClassId()!=null){
            int result=fixedAssetService.createFixedAsset(fixedAsset);
            if(result==0) return false;
            return true;
        }
        return false;
    }

    @RequestMapping(value = {"/fixedasset"},method = RequestMethod.PUT)
    public boolean updateFixedAsset(@RequestBody FixedAsset fixedAsset){
        int results=fixedAssetService.updateFixedAsset(fixedAsset);
        if(results==0) return false;
        return true;
    }

    @RequestMapping(value = {"/fixedasset"},method = RequestMethod.PATCH)
    public boolean updateFixedAssetBySelect(@RequestBody FixedAsset fixedAsset){
        int results=fixedAssetService.updateFixedAssetBySelect(fixedAsset);
        if(results==0) return false;
        return true;
    }





    @RequestMapping(value = {"/fixedasset/{assetId}"},method = RequestMethod.DELETE)
    public boolean deleteFixedAssetById(@PathVariable(name = "assetId") int assetId){
        int result = fixedAssetService.deleteFixedAssetById(assetId);
        if(result==0) return false;
        return true;
    }

    @RequestMapping(value = {"/smallclass/{smallClassId}/fixedasset"},method = RequestMethod.GET)
    public List<FixedAsset> getFixedAssetBySmallClassId(@PathVariable(name = "smallClassId") int smallClassId){
        return fixedAssetService.getFixedAssetBySmallClassId(smallClassId);
    }
}
