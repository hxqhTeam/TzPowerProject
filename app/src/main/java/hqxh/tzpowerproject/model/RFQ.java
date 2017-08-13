package hqxh.tzpowerproject.model;

/**
 *询价单
 */
public class RFQ extends Entity{
    public String RFQID;//RFQID
    public String RFQNUM;//RFQ
    public String DESCRIPTION;//描述
    public String QUOTATIONTYPE;//报价方式
    public String ZHANGTAO;//帐套信息
    public String ALNDOMAIN_ZT_DESCRIPTION;//帐套信息描述
    public String STATUS;//状态
    public String PERSON_DISPLAYNAME;//输入人
    public String CLOSEONDATE;//截止日期

    public String getRFQID() {
        return RFQID;
    }

    public void setRFQID(String RFQID) {
        this.RFQID = RFQID;
    }

    public String getRFQNUM() {
        return RFQNUM;
    }

    public void setRFQNUM(String RFQNUM) {
        this.RFQNUM = RFQNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getQUOTATIONTYPE() {
        return QUOTATIONTYPE;
    }

    public void setQUOTATIONTYPE(String QUOTATIONTYPE) {
        this.QUOTATIONTYPE = QUOTATIONTYPE;
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

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getPERSON_DISPLAYNAME() {
        return PERSON_DISPLAYNAME;
    }

    public void setPERSON_DISPLAYNAME(String PERSON_DISPLAYNAME) {
        this.PERSON_DISPLAYNAME = PERSON_DISPLAYNAME;
    }

    public String getCLOSEONDATE() {
        return CLOSEONDATE;
    }

    public void setCLOSEONDATE(String CLOSEONDATE) {
        this.CLOSEONDATE = CLOSEONDATE;
    }
}
