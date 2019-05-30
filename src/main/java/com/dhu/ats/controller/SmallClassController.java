package com.dhu.ats.controller;

import com.dhu.ats.annotation.UserLoginToken;
import com.dhu.ats.model.SmallClass;
import com.dhu.ats.service.FixedAssetService;
import com.dhu.ats.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@UserLoginToken
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

    @RequestMapping(value = {"/smallclass"}, method = RequestMethod.GET)
    public String checkSmallClassExist(@RequestParam("smallClassName") String smallClassName){

        int result=smallClassService.checkSmallClassExist(smallClassName);
        if(result==0) return "no";
        return "yes";
    }


    @RequestMapping(value={"/smallclass"},method= RequestMethod.PUT)
    public boolean updateSmallClass(@RequestBody SmallClass smallClass){
        int results=smallClassService.updateSmallClass(smallClass);
        if(results==0) return false;
        return true;
    }

    @RequestMapping(value = {"/smallclass/{smallClassId}"},method = RequestMethod.DELETE)
    public boolean deleteSmallClassById(@PathVariable(name = "smallClassId")int smallClassId){

        fixedAssetService.deleteFixedAssetBySmallClassId(smallClassId);
        int result= smallClassService.deleteSmallClassById(smallClassId);
        if(result==0) return false;
        return true;
    }
}
