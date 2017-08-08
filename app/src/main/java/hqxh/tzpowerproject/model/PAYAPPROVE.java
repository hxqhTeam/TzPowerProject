package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *采购单
 */
public class PO extends Entity{
    public String PONUM;//采购单编号
    public String DESCRIPTION;//描述
    public String POGENRE;//采购单类型
    public String ZHANGTAO;//帐套信息
    public String ALNDOMAIN_ZT_DESCRIPTION;//帐套信息描述
    public String ISHTBH;//有合同编号？
    public String CONNUM;//合同编号
    public String CONTRACTSTATUS;//合同备注
    public String YTQK;//委托情况
    public String STATUS;//状态
    public String PRETAXTOTAL;//税前总计
    public String TOTALTAX1;//税款总计
    public String TOTALCOST;//成本总计
    public String RECEIPTS;//入库情况
    public String VENDOR;//公司代码
    public String PO_VENDOR_NAME;//公司描述
    public String VENDOR_CONTACT_CONTACT;//联系人
    public String VENDOR_CONTACT_VOICEPHONE;//办公室电话
    public String VENDOR_CONTACT_FAXPHONE;//传真
    public String VENDOR_CONTACT_CELLPHONE;//手机号码
    public String VENDOR_CONTACT_EMAIL;//邮箱地址
    public String MEMO;//询比价情况


    public String getPONUM() {
        return PONUM;
    }

    public void setPONUM(String PONUM) {
        this.PONUM = PONUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPOGENRE() {
        return POGENRE;
    }

    public void setPOGENRE(String POGENRE) {
        this.POGENRE = POGENRE;
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

    public String getISHTBH() {
        return ISHTBH;
    }

    public void setISHTBH(String ISHTBH) {
        this.ISHTBH = ISHTBH;
    }

    public String getCONNUM() {
        return CONNUM;
    }

    public void setCONNUM(String CONNUM) {
        this.CONNUM = CONNUM;
    }

    public String getCONTRACTSTATUS() {
        return CONTRACTSTATUS;
    }

    public void setCONTRACTSTATUS(String CONTRACTSTATUS) {
        this.CONTRACTSTATUS = CONTRACTSTATUS;
    }

    public String getYTQK() {
        return YTQK;
    }

    public void setYTQK(String YTQK) {
        this.YTQK = YTQK;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getPRETAXTOTAL() {
        return PRETAXTOTAL;
    }

    public void setPRETAXTOTAL(String PRETAXTOTAL) {
        this.PRETAXTOTAL = PRETAXTOTAL;
    }

    public String getTOTALTAX1() {
        return TOTALTAX1;
    }

    public void setTOTALTAX1(String TOTALTAX1) {
        this.TOTALTAX1 = TOTALTAX1;
    }

    public String getTOTALCOST() {
        return TOTALCOST;
    }

    public void setTOTALCOST(String TOTALCOST) {
        this.TOTALCOST = TOTALCOST;
    }

    public String getRECEIPTS() {
        return RECEIPTS;
    }

    public void setRECEIPTS(String RECEIPTS) {
        this.RECEIPTS = RECEIPTS;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public String getPO_VENDOR_NAME() {
        return PO_VENDOR_NAME;
    }

    public void setPO_VENDOR_NAME(String PO_VENDOR_NAME) {
        this.PO_VENDOR_NAME = PO_VENDOR_NAME;
    }

    public String getVENDOR_CONTACT_CONTACT() {
        return VENDOR_CONTACT_CONTACT;
    }

    public void setVENDOR_CONTACT_CONTACT(String VENDOR_CONTACT_CONTACT) {
        this.VENDOR_CONTACT_CONTACT = VENDOR_CONTACT_CONTACT;
    }

    public String getVENDOR_CONTACT_VOICEPHONE() {
        return VENDOR_CONTACT_VOICEPHONE;
    }

    public void setVENDOR_CONTACT_VOICEPHONE(String VENDOR_CONTACT_VOICEPHONE) {
        this.VENDOR_CONTACT_VOICEPHONE = VENDOR_CONTACT_VOICEPHONE;
    }

    public String getVENDOR_CONTACT_FAXPHONE() {
        return VENDOR_CONTACT_FAXPHONE;
    }

    public void setVENDOR_CONTACT_FAXPHONE(String VENDOR_CONTACT_FAXPHONE) {
        this.VENDOR_CONTACT_FAXPHONE = VENDOR_CONTACT_FAXPHONE;
    }

    public String getVENDOR_CONTACT_CELLPHONE() {
        return VENDOR_CONTACT_CELLPHONE;
    }

    public void setVENDOR_CONTACT_CELLPHONE(String VENDOR_CONTACT_CELLPHONE) {
        this.VENDOR_CONTACT_CELLPHONE = VENDOR_CONTACT_CELLPHONE;
    }

    public String getVENDOR_CONTACT_EMAIL() {
        return VENDOR_CONTACT_EMAIL;
    }

    public void setVENDOR_CONTACT_EMAIL(String VENDOR_CONTACT_EMAIL) {
        this.VENDOR_CONTACT_EMAIL = VENDOR_CONTACT_EMAIL;
    }

    public String getMEMO() {
        return MEMO;
    }

    public void setMEMO(String MEMO) {
        this.MEMO = MEMO;
    }
}
