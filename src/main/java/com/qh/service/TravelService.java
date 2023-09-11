package com.qh.service;

import com.qh.pojo.Hrperson;
import com.qh.pojo.Travelperson;
import com.qh.util.ExcelUtils;
import lombok.Cleanup;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TravelService {

    public static List<Travelperson> getAllTravelByExcel(MultipartFile file) {
        List<Travelperson> pp = null;
        try {
            //获取文件输入流并且自动清理
            @Cleanup
            InputStream inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();

            Map<String, List<List<String>>> dataMap = ExcelUtils.parseExcel(inputStream, fileName);

            Set<String> strings = dataMap.keySet();

            pp = new ArrayList<>();

            for (String str : strings
            ) {


                int num = 0;
                int nameNum1 = 0;
                int msg = 0;
                int moneyNum = 0;
                int depNum = 0;
                //str 是月份


                List<List<String>> o = dataMap.get(str);

                //获取标题字段
                List<String> list1 = o.get(0);

                for (int i = 0; i < list1.size(); i++) {

                    if ("员工编码".equals(list1.get(i))) {
                        num = i;

                    } else if ("员工姓名".equals(list1.get(i))) {
                        nameNum1 = i;


                    } else if ("备注".equals(list1.get(i))) {

                        msg = i;

                    } else if (list1.get(i).toString().contains("实际发放")) {
                        moneyNum = i;

                    } else if ("部门".equals(list1.get(i))) {
                        depNum = i;

                    }
                }

                for (int i = 1; i < o.size(); i++) {

                    List<String> objects = o.get(i);


                    String number = objects.get(num);
                    String name = objects.get(nameNum1);
                    String msg1 = objects.get(msg);
                    String money = objects.get(moneyNum);
                    String dep = objects.get(depNum);

                    Travelperson p = new Travelperson();
                    p.setDatestr(str);
                    p.setPersonfnumber(number);
                    p.setPersonfname(name);
                    p.setMoney(money);
                    p.setDepname(dep);
                    p.setMsg(msg1);

                    pp.add(p);
                }

            }


        } catch (Exception e) {
            System.out.println("报错");
            e.printStackTrace();


        }
        return pp;
    }
}

