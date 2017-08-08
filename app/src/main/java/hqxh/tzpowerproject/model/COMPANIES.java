package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *需款计划
 */
public class REQUIREPLAN extends Entity{
    public String REQUIREPLANNUM;//需求申请单编号
    public String DEPARTMENT;//部门专业
    public String PLANCOST;//项目预算
    public String STATUS;//状态
    public String ITEMTYPE;//需求计划类型
    public String REQUIREPERSON;//需求人员
    public String PROJECTNUM;//项目编号
    public String PROJECTNAME;//项目名称
    public String CREATETIME;//申请日期
    public String ZTDESCRIPTION;//帐套信息
    public String PLANTYPE;//计划类型
    public String REMAINCOST;//预算剩余
    public String ZHANGTAO;//帐套信息
    public String REQUIRETIME;//需求日期
    public String getREQUIREPLANNUM() {
        return REQUIREPLANNUM;
    }

    public String DESCRIPTION;//需求申请单描述

    public void setREQUIREPLANNUM(String REQUIREPLANNUM) {
        this.REQUIREPLANNUM = REQUIREPLANNUM;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public String getPLANCOST() {
        return PLANCOST;
    }

    public void setPLANCOST(String PLANCOST) {
        this.PLANCOST = PLANCOST;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getITEMTYPE() {
        return ITEMTYPE;
    }

    public void setITEMTYPE(String ITEMTYPE) {
        this.ITEMTYPE = ITEMTYPE;
    }

    public String getREQUIREPERSON() {
        return REQUIREPERSON;
    }

    public void setREQUIREPERSON(String REQUIREPERSON) {
        this.REQUIREPERSON = REQUIREPERSON;
    }

    public String getPROJECTNUM() {
        return PROJECTNUM;
    }

    public void setPROJECTNUM(String PROJECTNUM) {
        this.PROJECTNUM = PROJECTNUM;
    }

    public String getPROJECTNAME() {
        return PROJECTNAME;
    }

    public void setPROJECTNAME(String PROJECTNAME) {
        this.PROJECTNAME = PROJECTNAME;
    }

    public String getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(String CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getZTDESCRIPTION() {
        return ZTDESCRIPTION;
    }

    public void setZTDESCRIPTION(String ZTDESCRIPTION) {
        this.ZTDESCRIPTION = ZTDESCRIPTION;
    }

    public String getPLANTYPE() {
        return PLANTYPE;
    }

    public void setPLANTYPE(String PLANTYPE) {
        this.PLANTYPE = PLANTYPE;
    }

    public String getREMAINCOST() {
        return REMAINCOST;
    }

    public void setREMAINCOST(String REMAINCOST) {
        this.REMAINCOST = REMAINCOST;
    }

    public String getZHANGTAO() {
        return ZHANGTAO;
    }

    public void setZHANGTAO(String ZHANGTAO) {
        this.ZHANGTAO = ZHANGTAO;
    }

    public String getREQUIRETIME() {
        return REQUIRETIME;
    }

    public void setREQUIRETIME(String REQUIRETIME) {
        this.REQUIRETIME = REQUIRETIME;
    }
}
