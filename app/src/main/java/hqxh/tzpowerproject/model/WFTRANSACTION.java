package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *审批流程
 */
public class WFTRANSACTION extends Entity{
    public String DISPLAYNAME;//审批人
    public String TRANSDATE;//审批日期
    public String MEMO;//意见
    public String NODE;//标题

    public String getDISPLAYNAME() {
        return DISPLAYNAME;
    }

    public void setDISPLAYNAME(String DISPLAYNAME) {
        this.DISPLAYNAME = DISPLAYNAME;
    }

    public String getTRANSDATE() {
        return TRANSDATE;
    }

    public void setTRANSDATE(String TRANSDATE) {
        this.TRANSDATE = TRANSDATE;
    }

    public String getMEMO() {
        return MEMO;
    }

    public void setMEMO(String MEMO) {
        this.MEMO = MEMO;
    }

    public String getNODE() {
        return NODE;
    }

    public void setNODE(String NODE) {
        this.NODE = NODE;
    }
}
