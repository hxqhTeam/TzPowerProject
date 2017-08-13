package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *需求计划行
 */
public class REQUIREPLANLINE extends Entity{
    public String REQUIREPLANLINENUM;//行
    public String ITEMNUM;//物资编码
    public String ITEMDESC;//描述
    public String ITEMSPECVENDOR;//制造厂商
    public String ALLCURBAL;//总库存数量
    public String ALLINVRESBAL;//总预留数量
    public String INVUSEBAL;//半年内领用
    public String COUNT;//需求数量
    public String PRCOUNT;//订购数量
    public String MEASUREMENT;//订购单位
    public String LZESTICOST;//零值估价
    public String PERCOST;//单位成本
    public String ITEMTOTALCOST;//行成本

    public String getREQUIREPLANLINENUM() {
        return REQUIREPLANLINENUM;
    }

    public void setREQUIREPLANLINENUM(String REQUIREPLANLINENUM) {
        this.REQUIREPLANLINENUM = REQUIREPLANLINENUM;
    }

    public String getITEMNUM() {
        return ITEMNUM;
    }

    public void setITEMNUM(String ITEMNUM) {
        this.ITEMNUM = ITEMNUM;
    }

    public String getITEMDESC() {
        return ITEMDESC;
    }

    public void setITEMDESC(String ITEMDESC) {
        this.ITEMDESC = ITEMDESC;
    }

    public String getITEMSPECVENDOR() {
        return ITEMSPECVENDOR;
    }

    public void setITEMSPECVENDOR(String ITEMSPECVENDOR) {
        this.ITEMSPECVENDOR = ITEMSPECVENDOR;
    }

    public String getALLCURBAL() {
        return ALLCURBAL;
    }

    public void setALLCURBAL(String ALLCURBAL) {
        this.ALLCURBAL = ALLCURBAL;
    }

    public String getALLINVRESBAL() {
        return ALLINVRESBAL;
    }

    public void setALLINVRESBAL(String ALLINVRESBAL) {
        this.ALLINVRESBAL = ALLINVRESBAL;
    }

    public String getINVUSEBAL() {
        return INVUSEBAL;
    }

    public void setINVUSEBAL(String INVUSEBAL) {
        this.INVUSEBAL = INVUSEBAL;
    }

    public String getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(String COUNT) {
        this.COUNT = COUNT;
    }

    public String getPRCOUNT() {
        return PRCOUNT;
    }

    public void setPRCOUNT(String PRCOUNT) {
        this.PRCOUNT = PRCOUNT;
    }

    public String getMEASUREMENT() {
        return MEASUREMENT;
    }

    public void setMEASUREMENT(String MEASUREMENT) {
        this.MEASUREMENT = MEASUREMENT;
    }

    public String getLZESTICOST() {
        return LZESTICOST;
    }

    public void setLZESTICOST(String LZESTICOST) {
        this.LZESTICOST = LZESTICOST;
    }

    public String getPERCOST() {
        return PERCOST;
    }

    public void setPERCOST(String PERCOST) {
        this.PERCOST = PERCOST;
    }

    public String getITEMTOTALCOST() {
        return ITEMTOTALCOST;
    }

    public void setITEMTOTALCOST(String ITEMTOTALCOST) {
        this.ITEMTOTALCOST = ITEMTOTALCOST;
    }
}
