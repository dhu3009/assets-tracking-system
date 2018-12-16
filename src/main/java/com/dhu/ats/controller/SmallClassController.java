package com.dhu.ats.controller;

import com.dhu.ats.model.SmallClass;
import com.dhu.ats.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmallClassController {
    @Autowired
    public SmallClassService smallClassService;

    @RequestMapping(value={"/smallclass"},method= RequestMethod.POST)
    public boolean createSmallClass(@RequestBody SmallClass smallClass){
        if(smallClass.getLargeClassId()!=null&&smallClass.getSmallClassName()!=null){
            int result=smallClassService.createSmallClass(smallClass);
            if(result==0) return false;
            return true;
        }
        return false;

    }
}
