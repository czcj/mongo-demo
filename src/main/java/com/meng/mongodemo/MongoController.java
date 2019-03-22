package com.meng.mongodemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MongoController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping("/count")
    public String getCount(){
        Query query = new Query();
        Criteria criteria = Criteria.where("storageStatus").is("USEING");
        criteria.and("project").is("4");
        criteria.and("usage").in("2");
        query.addCriteria(criteria);
        long mapCount = mongoTemplate.count(query, "IRS_HIGH_CONTENT_MAP");
        return JSON.toJSONString(mapCount);
    }
    @RequestMapping("/contentMap")
    public String getContentMap(){
        Query query = new Query();
        Criteria criteria = Criteria.where("storageStatus").is("USEING");
        criteria.and("project").is("4");
        criteria.and("usage").in("2");
        query.addCriteria(criteria);
        long mapCount = mongoTemplate.count(query, "IRS_HIGH_CONTENT_MAP");
        List<String> contentMap = mongoTemplate.find(query, String.class, "IRS_HIGH_CONTENT_MAP");
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0;i<mapCount;i++){
            HashMap jsonObject = JSON.parseObject(contentMap.get(i),HashMap.class);
            strings.add((String)(jsonObject.get("resId")));
        }
        return JSON.toJSONString(strings);
    }
}
