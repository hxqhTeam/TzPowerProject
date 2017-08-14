package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *物资编码行
 */
public class MATECODELINE extends Entity{
    public String MC_MATERIALINFONUM;//物资编码
    public String MC_MATERIALDESC;//物资描述
    public String MC_MATERIALDATATYPE;//物资分类
    public String MC_STANDARDNAME;//标谁名称
    public String MC_LOTTYPE;//批次
    public String MC_UNIT;//采购单位
    public String MC_INFOSTATE;//编码状态
    public String MC_PRICE;//估价

    public String getMC_MATERIALINFONUM() {
        return MC_MATERIALINFONUM;
    }

    public void setMC_MATERIALINFONUM(String MC_MATERIALINFONUM) {
        this.MC_MATERIALINFONUM = MC_MATERIALINFONUM;
    }

    public String getMC_MATERIALDESC() {
        return MC_MATERIALDESC;
    }

    public void setMC_MATERIALDESC(String MC_MATERIALDESC) {
        this.MC_MATERIALDESC = MC_MATERIALDESC;
    }

    public String getMC_MATERIALDATATYPE() {
        return MC_MATERIALDATATYPE;
    }

    public void setMC_MATERIALDATATYPE(String MC_MATERIALDATATYPE) {
        this.MC_MATERIALDATATYPE = MC_MATERIALDATATYPE;
    }

    public String getMC_STANDARDNAME() {
        return MC_STANDARDNAME;
    }

    public void setMC_STANDARDNAME(String MC_STANDARDNAME) {
        this.MC_STANDARDNAME = MC_STANDARDNAME;
    }

    public String getMC_LOTTYPE() {
        return MC_LOTTYPE;
    }

    public void setMC_LOTTYPE(String MC_LOTTYPE) {
        this.MC_LOTTYPE = MC_LOTTYPE;
    }

    public String getMC_UNIT() {
        return MC_UNIT;
    }

    public void setMC_UNIT(String MC_UNIT) {
        this.MC_UNIT = MC_UNIT;
    }

    public String getMC_INFOSTATE() {
        return MC_INFOSTATE;
    }

    public void setMC_INFOSTATE(String MC_INFOSTATE) {
        this.MC_INFOSTATE = MC_INFOSTATE;
    }

    public String getMC_PRICE() {
        return MC_PRICE;
    }

    public void setMC_PRICE(String MC_PRICE) {
        this.MC_PRICE = MC_PRICE;
    }
}
