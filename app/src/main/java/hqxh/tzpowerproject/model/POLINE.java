package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *采购单行／工程采购申请行
 */
public class POLINE extends Entity{
    public String POLINENUM;//行号
    public String REQDELIVERYDATE;//到货日期
    public String ITEMNUM;//项目
    public String DESCRIPTION;//描述
    public String ITEM_ITEMSPECVENDOR_ALNVALUE;//制造商
    public String ORDERQTY;//数量
    public String ORDERUNIT;//订购单位
    public String STORELOC;//库房
    public String UNITCOST;//单位成本
    public String LINECOST;//行成本
    public String AFTERAUNITCOST;//含税单价
    public String AFTERALINECOST;//含税金额
    public String REQDELIVERYALT;//要求的日期
    public String PERSON_DISPLAYNAME;//请求者
    public String REMARK;//备注
    public String ITEM_COMPANYNAME;//供应商名
    public String PROJECTNUM;//项目编号
    public String PROJECTNAME;//项目名称
    public String REQUIREPLANNUM;//需求计划申请单编号
    public String RFQNUM;//询价单编号
    public String PRNUM;//采购申请编号

    public String getPOLINENUM() {
        return POLINENUM;
    }

    public void setPOLINENUM(String POLINENUM) {
        this.POLINENUM = POLINENUM;
    }

    public String getREQDELIVERYDATE() {
        return REQDELIVERYDATE;
    }

    public void setREQDELIVERYDATE(String REQDELIVERYDATE) {
        this.REQDELIVERYDATE = REQDELIVERYDATE;
    }

    public String getITEMNUM() {
        return ITEMNUM;
    }

    public void setITEMNUM(String ITEMNUM) {
        this.ITEMNUM = ITEMNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getITEM_ITEMSPECVENDOR_ALNVALUE() {
        return ITEM_ITEMSPECVENDOR_ALNVALUE;
    }

    public void setITEM_ITEMSPECVENDOR_ALNVALUE(String ITEM_ITEMSPECVENDOR_ALNVALUE) {
        this.ITEM_ITEMSPECVENDOR_ALNVALUE = ITEM_ITEMSPECVENDOR_ALNVALUE;
    }

    public String getORDERQTY() {
        return ORDERQTY;
    }

    public void setORDERQTY(String ORDERQTY) {
        this.ORDERQTY = ORDERQTY;
    }

    public String getORDERUNIT() {
        return ORDERUNIT;
    }

    public void setORDERUNIT(String ORDERUNIT) {
        this.ORDERUNIT = ORDERUNIT;
    }

    public String getSTORELOC() {
        return STORELOC;
    }

    public void setSTORELOC(String STORELOC) {
        this.STORELOC = STORELOC;
    }

    public String getUNITCOST() {
        return UNITCOST;
    }

    public void setUNITCOST(String UNITCOST) {
        this.UNITCOST = UNITCOST;
    }

    public String getLINECOST() {
        return LINECOST;
    }

    public void setLINECOST(String LINECOST) {
        this.LINECOST = LINECOST;
    }

    public String getAFTERAUNITCOST() {
        return AFTERAUNITCOST;
    }

    public void setAFTERAUNITCOST(String AFTERAUNITCOST) {
        this.AFTERAUNITCOST = AFTERAUNITCOST;
    }

    public String getAFTERALINECOST() {
        return AFTERALINECOST;
    }

    public void setAFTERALINECOST(String AFTERALINECOST) {
        this.AFTERALINECOST = AFTERALINECOST;
    }

    public String getREQDELIVERYALT() {
        return REQDELIVERYALT;
    }

    public void setREQDELIVERYALT(String REQDELIVERYALT) {
        this.REQDELIVERYALT = REQDELIVERYALT;
    }

    public String getPERSON_DISPLAYNAME() {
        return PERSON_DISPLAYNAME;
    }

    public void setPERSON_DISPLAYNAME(String PERSON_DISPLAYNAME) {
        this.PERSON_DISPLAYNAME = PERSON_DISPLAYNAME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getITEM_COMPANYNAME() {
        return ITEM_COMPANYNAME;
    }

    public void setITEM_COMPANYNAME(String ITEM_COMPANYNAME) {
        this.ITEM_COMPANYNAME = ITEM_COMPANYNAME;
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

    public String getREQUIREPLANNUM() {
        return REQUIREPLANNUM;
    }

    public void setREQUIREPLANNUM(String REQUIREPLANNUM) {
        this.REQUIREPLANNUM = REQUIREPLANNUM;
    }

    public String getRFQNUM() {
        return RFQNUM;
    }

    public void setRFQNUM(String RFQNUM) {
        this.RFQNUM = RFQNUM;
    }

    public String getPRNUM() {
        return PRNUM;
    }

    public void setPRNUM(String PRNUM) {
        this.PRNUM = PRNUM;
    }
}
