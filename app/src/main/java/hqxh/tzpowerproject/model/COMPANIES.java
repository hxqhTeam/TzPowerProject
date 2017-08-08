package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *供应商
 */
public class COMPANIES extends Entity{
    public String COMPANY;//供应商
    public String NAME;//供应商描述
    public String PRODUCTTYPE;//供货类型
    public String TYPE;//公司类型
    public String STATUS;//状态
    public String REMARK;//备注

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRODUCTTYPE() {
        return PRODUCTTYPE;
    }

    public void setPRODUCTTYPE(String PRODUCTTYPE) {
        this.PRODUCTTYPE = PRODUCTTYPE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}
