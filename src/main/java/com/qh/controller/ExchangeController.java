package com.qh.controller;



import com.qh.pojo.*;
import com.qh.service.HRService;
import com.qh.service.TravelService;
import com.qh.util.ChangeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Controller
public class ExchangeController {
    @RequestMapping ("upload")
    @ResponseBody
    public DataVO upload(@RequestParam("file") MultipartFile file) {

        DataVO dataVo = null;
        if (file.isEmpty()){
            dataVo=new DataVO<>(500,"", null,null);
            return dataVo;
        }

        try {
             List<Hrperson> allHrMessage = HRService.getAllHrMessage();
            List<Travelperson> allTravelByExcel = TravelService.getAllTravelByExcel(file);


            //把null替换掉
            List<MatchVO> match = ChangeUtil.Match(allHrMessage, allTravelByExcel);

            dataVo= new DataVO<>(200,"", (long) (match.size()+1),match);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(dataVo.getCode());

        return dataVo;
    }


    @RequestMapping("main")

    public String main1(){
        return "table2";
    }

}
