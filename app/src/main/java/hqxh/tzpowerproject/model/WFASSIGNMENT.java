package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 * 收件箱
 */

public class WFASSIGNMENT extends Entity{
    public String OWNERTABLE;//对象名
    public String OWNERID;//唯一标识
    public String DESCRIPTION;//主题
    public String PROCESSNAME;//流程
    public String PROCESSREV;//版本
    public String APP;//应用程序
    public String ASSIGNCODE;//人员
    public String ASSIGNSTATUS;//状态
    public String DUEDATE;//日期
    public String ASSIGNEE_DEPT_DESCRIPTION;//岗位职能
    public String ASSIGNEE_DISPLAYNAME;//经办人审核人
    public String STARTDATE;//开始时间
    public String LASTMEMO_TRANSDATE;//审核时间
    public String LASTMEMO_MEDO;//审核意见

    public String getOWNERTABLE() {
        return OWNERTABLE;
    }

    public void setOWNERTABLE(String OWNERTABLE) {
        this.OWNERTABLE = OWNERTABLE;
    }

    public String getOWNERID() {
        return OWNERID;
    }

    public void setOWNERID(String OWNERID) {
        this.OWNERID = OWNERID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPROCESSNAME() {
        return PROCESSNAME;
    }

    public void setPROCESSNAME(String PROCESSNAME) {
        this.PROCESSNAME = PROCESSNAME;
    }

    public String getPROCESSREV() {
        return PROCESSREV;
    }

    public void setPROCESSREV(String PROCESSREV) {
        this.PROCESSREV = PROCESSREV;
    }

    public String getAPP() {
        return APP;
    }

    public void setAPP(String APP) {
        this.APP = APP;
    }

    public String getASSIGNCODE() {
        return ASSIGNCODE;
    }

    public void setASSIGNCODE(String ASSIGNCODE) {
        this.ASSIGNCODE = ASSIGNCODE;
    }

    public String getASSIGNSTATUS() {
        return ASSIGNSTATUS;
    }

    public void setASSIGNSTATUS(String ASSIGNSTATUS) {
        this.ASSIGNSTATUS = ASSIGNSTATUS;
    }

    public String getDUEDATE() {
        return DUEDATE;
    }

    public void setDUEDATE(String DUEDATE) {
        this.DUEDATE = DUEDATE;
    }

    public String getASSIGNEE_DEPT_DESCRIPTION() {
        return ASSIGNEE_DEPT_DESCRIPTION;
    }

    public void setASSIGNEE_DEPT_DESCRIPTION(String ASSIGNEE_DEPT_DESCRIPTION) {
        this.ASSIGNEE_DEPT_DESCRIPTION = ASSIGNEE_DEPT_DESCRIPTION;
    }

    public String getASSIGNEE_DISPLAYNAME() {
        return ASSIGNEE_DISPLAYNAME;
    }

    public void setASSIGNEE_DISPLAYNAME(String ASSIGNEE_DISPLAYNAME) {
        this.ASSIGNEE_DISPLAYNAME = ASSIGNEE_DISPLAYNAME;
    }

    public String getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(String STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public String getLASTMEMO_TRANSDATE() {
        return LASTMEMO_TRANSDATE;
    }

    public void setLASTMEMO_TRANSDATE(String LASTMEMO_TRANSDATE) {
        this.LASTMEMO_TRANSDATE = LASTMEMO_TRANSDATE;
    }

    public String getLASTMEMO_MEDO() {
        return LASTMEMO_MEDO;
    }

    public void setLASTMEMO_MEDO(String LASTMEMO_MEDO) {
        this.LASTMEMO_MEDO = LASTMEMO_MEDO;
    }
}
