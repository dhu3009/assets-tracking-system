package com.dhu.ats.controller;

import com.dhu.ats.annotation.UserLoginToken;
import com.dhu.ats.model.LargeClass;
import com.dhu.ats.model.SmallClass;
import com.dhu.ats.service.FixedAssetService;
import com.dhu.ats.service.LargeClassService;
import com.dhu.ats.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@UserLoginToken
@RestController
public class LargeClassController {
    @Autowired
    public LargeClassService largeClassService;

    @Autowired
    public SmallClassService smallClassService;

    @Autowired
    public FixedAssetService fixedAssetService;


//    @RequestMapping(value = {"/largeclass"}, method = RequestMethod.GET)
//    public List<LargeClass> getAllLargeClass() {
//        return largeClassService.getAllLargeClass();
//    }


    @RequestMapping(value = {"/largeclass"}, method = RequestMethod.GET)
    public String checkLargeClassExist(@RequestParam("largeClassName") String largeClassName){

        int result=largeClassService.checkLargeClassExist(largeClassName);
        if(result==0) return "no";
        return "yes";
    }


    @RequestMapping(value = {"/largeclass"}, method = RequestMethod.POST)
    public boolean createLargeClass(@RequestBody LargeClass largeClass) {
        if (largeClass.getLargeClassName() != null) {
            int result = largeClassService.createLargeClass(largeClass);
            if (result == 0) return false;
            return true;
        }
        return false;
    }

    @RequestMapping(value = {"/largeclass"}, method = RequestMethod.PUT)
    public boolean updateLargeClass(@RequestBody LargeClass largeClass){
       int results = largeClassService.updateLargeClass(largeClass);
       if(results==0) return false;
       return  true;
    }


    @RequestMapping(value = {"/class"}, method = RequestMethod.GET)
    public List<LargeClass> getAllLargeClassAndSmallClassAndFixedAsset() {
        List<LargeClass> largeClasses = largeClassService.getAllLargeClass();
        for (LargeClass largeClass :
                largeClasses) {
            List<SmallClass> smallClasses = smallClassService.getSmallClassByLargeClassId(largeClass.getLargeClassId());
            largeClass.setSmallClasses(smallClasses);
        }

        return largeClasses;
    }

    @RequestMapping(value = {"/largeclass/{largeClassId}"}, method = RequestMethod.DELETE)
    public boolean deleteLargeClassById(@PathVariable(name = "largeClassId") int largeClassId) {
        LargeClass largeClass = largeClassService.getLargeClassById(largeClassId);


        List<SmallClass> smallClasses = smallClassService.getSmallClassByLargeClassId(largeClass.getLargeClassId());
        for (SmallClass smallclass : smallClasses
        ) {
            fixedAssetService.deleteFixedAssetBySmallClassId(smallclass.getSmallClassId());
            smallClassService.deleteSmallClassById(smallclass.getSmallClassId());
        }
        int result = largeClassService.deleteLargeClassById(largeClassId);
        if (result == 0) return false;
        return true;
    }

}

