package com.meng.mongodemo;

import com.mongodb.WriteResult;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDemoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void contextLoads() {
//        Logger logger = LoggerFactory.getLogger(MongoDemoApplicationTests.class);
//        Query query = new Query();
//        Criteria criteria = Criteria.where("storageStatus").is("USEING");
//        criteria.and("project").is("4");
//        query.addCriteria(criteria);
//        long irs_high_content_map = mongoTemplate.count(query, "IRS_HIGH_CONTENT_MAP");
//        List<String> contentMap = mongoTemplate.find(query, String.class, "IRS_HIGH_CONTENT_MAP");
//        System.out.println(contentMap.size());
        Query query = new Query();
        Criteria criteria = Criteria.where("test").is(123);
        query.addCriteria(criteria);
        List<String> test = mongoTemplate.find(query, String.class, "test");
        System.out.println(test);
//        WriteResult test1 = mongoTemplate.remove(query, "test");
        DeleteResult test1 = mongoTemplate.remove(query,"test");
        long n = test1.getDeletedCount();
//        int n = test1.getN();
        System.out.println(n);
    }

}
