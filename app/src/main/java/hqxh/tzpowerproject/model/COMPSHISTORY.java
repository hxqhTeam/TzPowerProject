package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *供应商
 */
public class COMPSHISTORY extends Entity{
    public String CREATEDATE;//创建时间
    public String CREATEDBY;//创建人
    public String THISSCORE;//本次加减分值
    public String CAUSE;//事件原因
    public String STATUS;//状态

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getCREATEDBY() {
        return CREATEDBY;
    }

    public void setCREATEDBY(String CREATEDBY) {
        this.CREATEDBY = CREATEDBY;
    }

    public String getTHISSCORE() {
        return THISSCORE;
    }

    public void setTHISSCORE(String THISSCORE) {
        this.THISSCORE = THISSCORE;
    }

    public String getCAUSE() {
        return CAUSE;
    }

    public void setCAUSE(String CAUSE) {
        this.CAUSE = CAUSE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
