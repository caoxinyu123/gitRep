package com.qh.util;

import com.qh.pojo.Hrperson;
import com.qh.pojo.MatchVO;
import com.qh.pojo.Travelperson;

import java.util.ArrayList;
import java.util.List;

public class ChangeUtil {

        public static List<MatchVO> Match(List<Hrperson> hrpersonList, List<Travelperson> travelpersonList){
                List<MatchVO> matchVOS = new ArrayList<>();


                for (Travelperson t: travelpersonList
                     ) {
                            MatchVO matchVO = new MatchVO();
                        String personfnumber = t.getPersonfnumber();

                        for (Hrperson h:hrpersonList
                             ) {
                                if (h.getPersonfnumber().equals(personfnumber)){
                                        String bankfname = h.getBankfname();
                                        String accountnumber = h.getAccountnumber();
                                        String fidcardno = h.getFidcardno();
                                    //    String employeefname = h.getEmployeefname();
                                        String positionfname = h.getPositionfname();
                                        String adminfname =h.getField1();


                                    matchVO.setAccountnumber(accountnumber);
                                        matchVO.setBankfname(bankfname);
                                        matchVO.setFidcardno(fidcardno);
                                        matchVO.setEmployeefname(positionfname);
                                        matchVO.setDepname(adminfname);


                                        matchVO.setPersonfnumber(personfnumber);
                                        matchVO.setPersonfname(t.getPersonfname());
                                        matchVO.setMoney(t.getMoney());
                                        matchVO.setMsg(t.getMsg());
                                        matchVO.setDatestr(t.getDatestr());

                                         matchVOS.add(matchVO);

                                         break;

                                }
                        }
                }


                return matchVOS;
        }
}
