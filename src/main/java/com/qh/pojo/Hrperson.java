package com.qh.pojo;

import java.io.Serializable;

/**
 * hrperson
 * @author 
 */
public class Hrperson implements Serializable {
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
    /**
     * adminfname
     */
    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;

    private static final long serialVersionUID = 1L;

    public String getPersonfnumber() {
        return personfnumber;
    }

    public void setPersonfnumber(String personfnumber) {
        this.personfnumber = personfnumber;
    }

    public String getPersonfname() {
        return personfname;
    }

    public void setPersonfname(String personfname) {
        this.personfname = personfname;
    }

    public String getFidcardno() {
        return fidcardno;
    }

    public void setFidcardno(String fidcardno) {
        this.fidcardno = fidcardno;
    }

    public String getPositionfname() {
        return positionfname;
    }

    public void setPositionfname(String positionfname) {
        this.positionfname = positionfname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBankfname() {
        return bankfname;
    }

    public void setBankfname(String bankfname) {
        this.bankfname = bankfname;
    }

    public String getEmployeefname() {
        return employeefname;
    }

    public void setEmployeefname(String employeefname) {
        this.employeefname = employeefname;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Hrperson other = (Hrperson) that;
        return (this.getPersonfnumber() == null ? other.getPersonfnumber() == null : this.getPersonfnumber().equals(other.getPersonfnumber()))
            && (this.getPersonfname() == null ? other.getPersonfname() == null : this.getPersonfname().equals(other.getPersonfname()))
            && (this.getFidcardno() == null ? other.getFidcardno() == null : this.getFidcardno().equals(other.getFidcardno()))
            && (this.getPositionfname() == null ? other.getPositionfname() == null : this.getPositionfname().equals(other.getPositionfname()))
            && (this.getAccountnumber() == null ? other.getAccountnumber() == null : this.getAccountnumber().equals(other.getAccountnumber()))
            && (this.getBankfname() == null ? other.getBankfname() == null : this.getBankfname().equals(other.getBankfname()))
            && (this.getEmployeefname() == null ? other.getEmployeefname() == null : this.getEmployeefname().equals(other.getEmployeefname()))
            && (this.getField1() == null ? other.getField1() == null : this.getField1().equals(other.getField1()))
            && (this.getField2() == null ? other.getField2() == null : this.getField2().equals(other.getField2()))
            && (this.getField3() == null ? other.getField3() == null : this.getField3().equals(other.getField3()))
            && (this.getField4() == null ? other.getField4() == null : this.getField4().equals(other.getField4()))
            && (this.getField5() == null ? other.getField5() == null : this.getField5().equals(other.getField5()))
            && (this.getField6() == null ? other.getField6() == null : this.getField6().equals(other.getField6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonfnumber() == null) ? 0 : getPersonfnumber().hashCode());
        result = prime * result + ((getPersonfname() == null) ? 0 : getPersonfname().hashCode());
        result = prime * result + ((getFidcardno() == null) ? 0 : getFidcardno().hashCode());
        result = prime * result + ((getPositionfname() == null) ? 0 : getPositionfname().hashCode());
        result = prime * result + ((getAccountnumber() == null) ? 0 : getAccountnumber().hashCode());
        result = prime * result + ((getBankfname() == null) ? 0 : getBankfname().hashCode());
        result = prime * result + ((getEmployeefname() == null) ? 0 : getEmployeefname().hashCode());
        result = prime * result + ((getField1() == null) ? 0 : getField1().hashCode());
        result = prime * result + ((getField2() == null) ? 0 : getField2().hashCode());
        result = prime * result + ((getField3() == null) ? 0 : getField3().hashCode());
        result = prime * result + ((getField4() == null) ? 0 : getField4().hashCode());
        result = prime * result + ((getField5() == null) ? 0 : getField5().hashCode());
        result = prime * result + ((getField6() == null) ? 0 : getField6().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", personfnumber=").append(personfnumber);
        sb.append(", personfname=").append(personfname);
        sb.append(", fidcardno=").append(fidcardno);
        sb.append(", positionfname=").append(positionfname);
        sb.append(", accountnumber=").append(accountnumber);
        sb.append(", bankfname=").append(bankfname);
        sb.append(", employeefname=").append(employeefname);
        sb.append(", field1=").append(field1);
        sb.append(", field2=").append(field2);
        sb.append(", field3=").append(field3);
        sb.append(", field4=").append(field4);
        sb.append(", field5=").append(field5);
        sb.append(", field6=").append(field6);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}