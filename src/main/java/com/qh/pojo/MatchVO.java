package com.qh.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MatchVO {
    private String datestr;


    /**
     * 部门名称
     */
    private String depname;
    /**
     * 备注
     */
    private String msg;
    /**
     * 差补金额
     */
    private String money;


    /**
     * 员工编号
     */
    private String personfnumber;

    /**
     * 员工名称

     */
    private String personfname;

    /**
     * 身份证号
     */
    private String fidcardno;

    /**
     * 职位名称
     */
    private String positionfname;

    /**
     * 银行卡账号
     */
    private String accountnumber;

    /**
     * 银行名称
     */
    private String bankfname;

    /**
     * 在职状态
     */
    private String employeefname;

}
