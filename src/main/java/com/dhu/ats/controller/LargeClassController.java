package com.dhu.ats.controller;

import com.dhu.ats.model.FixedAsset;
import com.dhu.ats.model.LargeClass;
import com.dhu.ats.model.SmallClass;
import com.dhu.ats.service.FixedAssetService;
import com.dhu.ats.service.LargeClassService;
import com.dhu.ats.service.SmallClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


//    @RequestMapping(value = {"/largeclass"}, method = RequestMethod.GET)
//    public List<LargeClass> getLargeClassBySelectPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
//
//        PageHelper.startPage(pageNum,pageSize);
//        List<LargeClass> largeClasses=largeClassService.getAllLargeClass();
//        PageInfo<LargeClass> pageInfo=new PageInfo<>(largeClasses);
//        return pageInfo.getList();
//    }



    @RequestMapping(value = {"/class"}, method = RequestMethod.GET)
    public List<LargeClass> getAllLargeClassAndSmallClassAndFixedAsset() {
        List<LargeClass> largeClasses = largeClassService.getAllLargeClass();
        for (LargeClass largeClass :
                largeClasses) {
            List<SmallClass> smallClasses = smallClassService.getSmallClassByLargeClassId(largeClass.getLargeClassId());
//            for (SmallClass smallClass :
//                    smallClasses) {
//                List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetBySmallClassId(smallClass.getSmallClassId());
//                smallClass.setAssets(fixedAssets);
//            }
            largeClass.setSmallClasses(smallClasses);
        }

        return largeClasses;
    }



//    @RequestMapping(value = {"/largeclass/{largeClassId}/fixedasset"}, method = RequestMethod.GET)
//    public PageInfo getOrderedFixedAssetByLargeClassId1(@PathVariable(name = "largeClassId") int largeClassId,
//        @RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("field") String field, @RequestParam("order") String order) {
//        /*LargeClass largeClass = largeClassService.getLargeClassById(largeClassId);
//        List<SmallClass> smallClasses = smallClassService.getSmallClassByLargeClassId(largeClass.getLargeClassId());
//        List<FixedAsset> fixedAssetList = new ArrayList<>();
//        for (SmallClass smallClass :
//                smallClasses) {
//            List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetBySmallClassId(smallClass.getSmallClassId());
//            fixedAssetList.addAll(fixedAssets);
//        }*/
//        PageHelper.startPage(page,limit);
//        List<FixedAsset> fixedAssets= fixedAssetService.getOrderedFixedAssetByLargeClassId(largeClassId,field,order);
//        PageInfo pageInfo=new PageInfo(fixedAssets);
//        return pageInfo;
//
//
//    }


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

