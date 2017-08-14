package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *物资编码
 */
public class MATECODE extends Entity{
    public String MATECODEID;//MATECODEID
    public String MC_MATERIALCODENUM;//物资表单编号
    public String DESCRIPTION;//描述
    public String MC_CREATEDBY;//申请人
    public String MC_DEPARTMENT;//申请专业
    public String ZHANGTAO;//帐套
    public String ALNDOMAIN_ZT_DESCRIPTION;//帐套描述
    public String STATUS;//状态
    public String MC_CREATETIME;//申请时间

    public String getMATECODEID() {
        return MATECODEID;
    }

    public void setMATECODEID(String MATECODEID) {
        this.MATECODEID = MATECODEID;
    }

    public String getMC_MATERIALCODENUM() {
        return MC_MATERIALCODENUM;
    }

    public void setMC_MATERIALCODENUM(String MC_MATERIALCODENUM) {
        this.MC_MATERIALCODENUM = MC_MATERIALCODENUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getMC_CREATEDBY() {
        return MC_CREATEDBY;
    }

    public void setMC_CREATEDBY(String MC_CREATEDBY) {
        this.MC_CREATEDBY = MC_CREATEDBY;
    }

    public String getMC_DEPARTMENT() {
        return MC_DEPARTMENT;
    }

    public void setMC_DEPARTMENT(String MC_DEPARTMENT) {
        this.MC_DEPARTMENT = MC_DEPARTMENT;
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

    public String getMC_CREATETIME() {
        return MC_CREATETIME;
    }

    public void setMC_CREATETIME(String MC_CREATETIME) {
        this.MC_CREATETIME = MC_CREATETIME;
    }
}
