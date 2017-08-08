package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *采购申请
 */
public class PR extends Entity{
    public String PRNUM;//申请编号
    public String DESCRIPTION;//描述
    public String ZHANGTAO;//帐套
    public String ALNDOMAIN_ZT_DESCRIPTION;//帐套信息描述
    public String PLANCOST;//物资费用预算
    public String REMAINCOST;//物资费用剩余
    public String TOTALCOST;//成本总计
    public String STATUS;//状态
    public String PLANTTYPE;//计划类型
    public String PROJECTNUM;//项目编号
    public String PROJECTDESC;//项目名称
    public String REQUESTEDBYNAME;//需求人名字
    public String DEPARTMENT;//部门名称
    public String ISSUEDATE;//请求日期
    public String REQUIREDDATE;//要求的日期

    public String getPRNUM() {
        return PRNUM;
    }

    public void setPRNUM(String PRNUM) {
        this.PRNUM = PRNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getZHANGTAO() {
        return ZHANGTAO;
    }

    public void setZHANGTAO(String ZHANGTAO) {
        this.ZHANGTAO = ZHANGTAO;
    }

    public String getALNDOMAIN_ZT_DESCRIPTION() {
        return ALNDOMAIN_ZT_DESCRIPTION;
    }

    public void setALNDOMAIN_ZT_DESCRIPTION(String ALNDOMAIN_ZT_DESCRIPTION) {
        this.ALNDOMAIN_ZT_DESCRIPTION = ALNDOMAIN_ZT_DESCRIPTION;
    }

    public String getPLANCOST() {
        return PLANCOST;
    }

    public void setPLANCOST(String PLANCOST) {
        this.PLANCOST = PLANCOST;
    }

    public String getREMAINCOST() {
        return REMAINCOST;
    }

    public void setREMAINCOST(String REMAINCOST) {
        this.REMAINCOST = REMAINCOST;
    }

    public String getTOTALCOST() {
        return TOTALCOST;
    }

    public void setTOTALCOST(String TOTALCOST) {
        this.TOTALCOST = TOTALCOST;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getPLANTTYPE() {
        return PLANTTYPE;
    }

    public void setPLANTTYPE(String PLANTTYPE) {
        this.PLANTTYPE = PLANTTYPE;
    }

    public String getPROJECTNUM() {
        return PROJECTNUM;
    }

    public void setPROJECTNUM(String PROJECTNUM) {
        this.PROJECTNUM = PROJECTNUM;
    }

    public String getPROJECTDESC() {
        return PROJECTDESC;
    }

    public void setPROJECTDESC(String PROJECTDESC) {
        this.PROJECTDESC = PROJECTDESC;
    }

    public String getREQUESTEDBYNAME() {
        return REQUESTEDBYNAME;
    }

    public void setREQUESTEDBYNAME(String REQUESTEDBYNAME) {
        this.REQUESTEDBYNAME = REQUESTEDBYNAME;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public String getISSUEDATE() {
        return ISSUEDATE;
    }

    public void setISSUEDATE(String ISSUEDATE) {
        this.ISSUEDATE = ISSUEDATE;
    }

    public String getREQUIREDDATE() {
        return REQUIREDDATE;
    }

    public void setREQUIREDDATE(String REQUIREDDATE) {
        this.REQUIREDDATE = REQUIREDDATE;
    }
}
