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
import java.util.List;

@RestController
public class FixedAssetController {
    @Autowired
    public FixedAssetService fixedAssetService;

    @Autowired
    public LargeClassService largeClassService;

    @Autowired
    public SmallClassService smallClassService;

    @RequestMapping(value = {"/fixedasset"}, method = RequestMethod.POST)
    public boolean createFixedAsset(@RequestBody FixedAsset fixedAsset) {
        if (fixedAsset.getAssetName() != null && fixedAsset.getAssignDate() != null && fixedAsset.getState() != null && fixedAsset.getSmallClassId() != null) {
            int result = fixedAssetService.createFixedAsset(fixedAsset);
            if (result == 0) return false;
            return true;
        }
        return false;
    }

    @RequestMapping(value = {"/fixedasset"}, method = RequestMethod.PUT)
    public boolean updateFixedAsset(@RequestBody FixedAsset fixedAsset) {
        int results = fixedAssetService.updateFixedAsset(fixedAsset);
        if (results == 0) return false;
        return true;
    }

    @RequestMapping(value = {"/fixedasset"}, method = RequestMethod.PATCH)
    public boolean updateFixedAssetBySelect(@RequestBody FixedAsset fixedAsset) {
        int results = fixedAssetService.updateFixedAssetBySelect(fixedAsset);
        if (results == 0) return false;
        return true;
    }


//    @RequestMapping(value = {"/fixedasset"}, method = RequestMethod.GET)
//    public PageInfo getAllFixedAsset(
//            @RequestParam("page") int page, @RequestParam("limit") int limit,
//            @RequestParam(value = "field", required = false, defaultValue = "asset_id") String field,
//            @RequestParam(value = "order", required = false, defaultValue = "asc") String order) {
//
//        PageHelper.startPage(page, limit, field + " " + order);
//        PageInfo pageInfo = new PageInfo(fixedAssetService.getAllFixedAsset());
//        return pageInfo;
//    }


    @RequestMapping(value = {"/fixedasset/{assetId}"}, method = RequestMethod.DELETE)
    public boolean deleteFixedAssetById(@PathVariable(name = "assetId") int assetId) {
        int result = fixedAssetService.deleteFixedAssetById(assetId);
        if (result == 0) return false;
        return true;
    }

//    @RequestMapping(value = {"/smallclass/{smallClassId}/fixedasset"},method = RequestMethod.GET)
//    public PageInfo getFixedAssetBySmallClassId(@PathVariable(name = "smallClassId") int smallClassId,@RequestParam("page") int page, @RequestParam("limit") int limit){
//        PageHelper.startPage(page,limit);
//        List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetBySmallClassId(smallClassId);
//        PageInfo pageInfo = new PageInfo(fixedAssets);
//        return pageInfo;
//    }

    @RequestMapping(value = {"/largeclass/{largeClassId}/fixedasset"}, method = RequestMethod.GET)
    public PageInfo getFixedAssetByLargeClassId(
            @PathVariable(name = "largeClassId") int largeClassId, @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "field", required = false, defaultValue = "asset_id") String field,
            @RequestParam(value = "order", required = false, defaultValue = "asc") String order) {
        /*LargeClass largeClass = largeClassService.getLargeClassById(largeClassId);
        List<SmallClass> smallClasses = smallClassService.getSmallClassByLargeClassId(largeClass.getLargeClassId());
        List<FixedAsset> fixedAssetList = new ArrayList<>();
        for (SmallClass smallClass :
                smallClasses) {
            List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetBySmallClassId(smallClass.getSmallClassId());
            fixedAssetList.addAll(fixedAssets);
        }*/
//        PageHelper.startPage(page,limit);
//        List<FixedAsset> fixedAssets=fixedAssetService.getFixedAssetByLargeClassId(largeClassId);
//        PageInfo pageInfo=new PageInfo(fixedAssets);
//        return pageInfo;

        PageHelper.startPage(page, limit, field + " " + order);
        List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetByLargeClassId(largeClassId);
        PageInfo pageInfo = new PageInfo(fixedAssets);
        return pageInfo;

    }


    @RequestMapping(value = {"/smallclass/{smallClassId}/fixedasset"}, method = RequestMethod.GET)
    public PageInfo getFixedAssetBySmallClassId(
            @PathVariable(name = "smallClassId") int smallClassId,
            @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "field", required = false, defaultValue = "asset_id") String field,
            @RequestParam(value = "order", required = false, defaultValue = "asc") String order) {
        PageHelper.startPage(page, limit, field + " " + order);
        List<FixedAsset> fixedAssets = fixedAssetService.getFixedAssetBySmallClassId(smallClassId);
        PageInfo pageInfo = new PageInfo(fixedAssets);
        return pageInfo;
    }

    @RequestMapping(value = {"/fixedasset"}, method = RequestMethod.GET)
    public PageInfo getAllFixedAsset(
            @RequestParam("page") int page, @RequestParam("limit") int limit,
            @RequestParam(value = "field", required = false, defaultValue = "asset_id") String field,
            @RequestParam(value = "order", required = false, defaultValue = "asc") String order,
            @RequestParam(value = "largeClassName",required = false, defaultValue = "") String largeClassName,
            @RequestParam(value = "smallClassName",required = false, defaultValue = "") String smallClassName,
            @RequestParam(value = "assetName",required = false, defaultValue = "") String assetName,
            @RequestParam(value = "assignDate",required = false, defaultValue = "") String assignDate,
            @RequestParam(value = "state",required = false, defaultValue = "") String state,
            @RequestParam(value = "placeLocation",required = false, defaultValue = "") String placeLocation,
            @RequestParam(value = "recentDays",required = false, defaultValue = "-1") int recentDays
    ) {

        PageHelper.startPage(page, limit, field + " " + order);
        List<FixedAsset> fixedAssets = fixedAssetService.getAllFixedAsset(largeClassName,
                smallClassName,
                assetName,
                assignDate,
                state,
                placeLocation,
                recentDays);
        PageInfo pageInfo = new PageInfo(fixedAssets);
        return pageInfo;
    }

}
