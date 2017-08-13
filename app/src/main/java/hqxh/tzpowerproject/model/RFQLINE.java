package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *采购申请行／工程采购申请行
 */
public class RFQLINE extends Entity{
    public String ITEMNUM;//物资编码
    public String DESCRIPTION;//物资描述
    public String ITEM_ITEMSPECVENDOR_ALNVALUE;//制造商
    public String ORDERQTY;//数量
    public String ORDERUNIT;//订购单位
    public String PERSON_DISPLAYNAME;//需求人
    public String POLINEHIS_UNITCOST;//最近一次报价
    public String POLINEHIS_ENTERALT;//最近一次报价时间
    public String COMHIS_NAME;//最近报价供应商
    public String RFQLINENUM;//行

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

    public String getPERSON_DISPLAYNAME() {
        return PERSON_DISPLAYNAME;
    }

    public void setPERSON_DISPLAYNAME(String PERSON_DISPLAYNAME) {
        this.PERSON_DISPLAYNAME = PERSON_DISPLAYNAME;
    }

    public String getPOLINEHIS_UNITCOST() {
        return POLINEHIS_UNITCOST;
    }

    public void setPOLINEHIS_UNITCOST(String POLINEHIS_UNITCOST) {
        this.POLINEHIS_UNITCOST = POLINEHIS_UNITCOST;
    }

    public String getPOLINEHIS_ENTERALT() {
        return POLINEHIS_ENTERALT;
    }

    public void setPOLINEHIS_ENTERALT(String POLINEHIS_ENTERALT) {
        this.POLINEHIS_ENTERALT = POLINEHIS_ENTERALT;
    }

    public String getCOMHIS_NAME() {
        return COMHIS_NAME;
    }

    public void setCOMHIS_NAME(String COMHIS_NAME) {
        this.COMHIS_NAME = COMHIS_NAME;
    }

    public String getRFQLINENUM() {
        return RFQLINENUM;
    }

    public void setRFQLINENUM(String RFQLINENUM) {
        this.RFQLINENUM = RFQLINENUM;
    }
}
