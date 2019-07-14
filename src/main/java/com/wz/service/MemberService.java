package com.wz.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public JSONObject getMember() {

        JSONObject result = new JSONObject();

        result.put("code",200);
        return result;
    }

}
