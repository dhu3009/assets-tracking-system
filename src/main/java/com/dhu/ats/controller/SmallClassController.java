package com.dhu.ats.controller;

import com.dhu.ats.model.FixedAsset;
import com.dhu.ats.model.SmallClass;
import com.dhu.ats.service.FixedAssetService;
import com.dhu.ats.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SmallClassController {
    @Autowired
    public SmallClassService smallClassService;
    @Autowired
    public FixedAssetService fixedAssetService;

    @RequestMapping(value={"/smallclass"},method= RequestMethod.POST)
    public boolean createSmallClass(@RequestBody SmallClass smallClass){
        if(smallClass.getLargeClassId()!=null&&smallClass.getSmallClassName()!=null){
            int result=smallClassService.createSmallClass(smallClass);
            if(result==0) return false;
            return true;
        }
        return false;
    }

    @RequestMapping(value = {"/smallclass/{smallClassId}"},method = RequestMethod.DELETE)
    public boolean deleteSmallClassById(@PathVariable(name = "smallClassId")int smallClassId){

        fixedAssetService.deleteFixedAssetBySmallClassId(smallClassId);
        int result= smallClassService.deleteSmallClassById(smallClassId);
        if(result==0) return false;
        return true;
    }
}
