package com.qh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qh.pojo.Hrperson;
import com.qh.pojo.StatusVO;
import com.qh.util.DoPOSTMessage;
import com.qh.util.DoPOSTTaken;

import java.util.ArrayList;
import java.util.List;

public class HRService {

    public static List<Hrperson> getAllHrMessage() throws Exception {




            List<Hrperson> hrpersonList = new ArrayList<>();

            String Token = DoPOSTTaken.doPost();
            String jsonMessage = DoPOSTMessage.doPost(Token);
            //转换为json对象
            JSONObject jsonObject = JSON.parseObject(jsonMessage);
            String data = jsonObject.getString("data");
            //转换为JSON数组
            JSONArray objects = JSON.parseArray(data);

            for (int i = 0; i < objects.size(); i++) {
                JSONObject jsonObject1 = JSON.parseObject((String) objects.get(i));
                //获取员工姓名
                String personfname = jsonObject1.getString("personfname");



                //员工编号
                String personfnumber = jsonObject1.getString("personfnumber");
                //身份证号
                String fidcardno = jsonObject1.getString("fidcardno");
                //职位名称
                String positionfname = jsonObject1.getString("positionfname");
                //在职状态
                String employeefname = jsonObject1.getString("employeefname");
                //银行卡信息集合
                String accountlist = jsonObject1.getString("accountlist");

                String adminfname = jsonObject1.getString("adminfname");



                //银行卡账户
                String accountnumber = null;
                //银行名称
                String bankfname = null;
                JSONArray list = JSON.parseArray(accountlist);

                if (list != null) {
                    for (int j = 0; j < list.size(); j++) {
                        JSONObject jsonObject2 = (JSONObject) list.get(j);

                        accountnumber = jsonObject2.getString("accountnumber");

                        bankfname = jsonObject2.getString("bankfname");
                    }
                }

                Hrperson person = new Hrperson();

                person.setAccountnumber(accountnumber);
                person.setBankfname(bankfname);
                person.setEmployeefname(employeefname);
                person.setFidcardno(fidcardno);
                person.setPersonfname(personfname);
                person.setPersonfnumber(personfnumber);
                person.setPositionfname(positionfname);
                person.setField1(adminfname);
                //Hr所有员工银行信息
                hrpersonList.add(person);
            }

            return hrpersonList;
    }
}
