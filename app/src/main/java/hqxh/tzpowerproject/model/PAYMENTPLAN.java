package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *付款计划
 */
public class PAYMENTPLAN extends Entity{
    public String PAYTYPE;//付款内容
    public String PAYRATIO;//付款比例
    public String PAYAMOUNT;//付款金额
    public String PAYPLANDATE;//预计付款日期
    public String PERSON_DISPLAYNAME;//最后修改人
    public String LASTMODTIME;//最后修改日期
    public String DESCRIPTION;//说明
    public String CREATEPEROSN;//创建人

    public String getPAYTYPE() {
        return PAYTYPE;
    }

    public void setPAYTYPE(String PAYTYPE) {
        this.PAYTYPE = PAYTYPE;
    }

    public String getPAYRATIO() {
        return PAYRATIO;
    }

    public void setPAYRATIO(String PAYRATIO) {
        this.PAYRATIO = PAYRATIO;
    }

    public String getPAYAMOUNT() {
        return PAYAMOUNT;
    }

    public void setPAYAMOUNT(String PAYAMOUNT) {
        this.PAYAMOUNT = PAYAMOUNT;
    }

    public String getPAYPLANDATE() {
        return PAYPLANDATE;
    }

    public void setPAYPLANDATE(String PAYPLANDATE) {
        this.PAYPLANDATE = PAYPLANDATE;
    }

    public String getPERSON_DISPLAYNAME() {
        return PERSON_DISPLAYNAME;
    }

    public void setPERSON_DISPLAYNAME(String PERSON_DISPLAYNAME) {
        this.PERSON_DISPLAYNAME = PERSON_DISPLAYNAME;
    }

    public String getLASTMODTIME() {
        return LASTMODTIME;
    }

    public void setLASTMODTIME(String LASTMODTIME) {
        this.LASTMODTIME = LASTMODTIME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getCREATEPEROSN() {
        return CREATEPEROSN;
    }

    public void setCREATEPEROSN(String CREATEPEROSN) {
        this.CREATEPEROSN = CREATEPEROSN;
    }
}
