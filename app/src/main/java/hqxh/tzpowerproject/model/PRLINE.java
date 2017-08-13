package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *采购申请行／工程采购申请行
 */
public class PRLINE extends Entity{
    public String ITEMNUM;//物资编码
    public String DESCRIPTION;//物资描述
    public String ITEM_ITEMSPECVENDOR_ALNVALUE;//制造商
    public String ORDERQTY;//数量
    public String ORDERUNIT;//订购单位
    public String UNITCOST;//单位成本
    public String LINECOST;//行成本
    public String CGLX;//采购方式
    public String REQUIREPLANNUM;//需求单编号
    public String PONUM;//PO
    public String RFQNUM;//RFQ
    public String PRLINENUM;//行

    public String getPRLINENUM() {
        return PRLINENUM;
    }

    public void setPRLINENUM(String PRLINENUM) {
        this.PRLINENUM = PRLINENUM;
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

    public String getCGLX() {
        return CGLX;
    }

    public void setCGLX(String CGLX) {
        this.CGLX = CGLX;
    }

    public String getREQUIREPLANNUM() {
        return REQUIREPLANNUM;
    }

    public void setREQUIREPLANNUM(String REQUIREPLANNUM) {
        this.REQUIREPLANNUM = REQUIREPLANNUM;
    }

    public String getPONUM() {
        return PONUM;
    }

    public void setPONUM(String PONUM) {
        this.PONUM = PONUM;
    }

    public String getRFQNUM() {
        return RFQNUM;
    }

    public void setRFQNUM(String RFQNUM) {
        this.RFQNUM = RFQNUM;
    }
}
