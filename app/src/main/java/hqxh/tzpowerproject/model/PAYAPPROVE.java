package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *物资合同付款审批表/工程验收
 */
public class PAYAPPROVE extends Entity{
    public String PAYAPPROVETYPE;//付款性质
    public String POTOTALCOST;//采购单金额
    public String TOTALCOST;//合同金额
    public String FINALCOST;//合同结算金额
    public String PAYCOST;//本次付款金额
    public String PAYPROPORTION;//本次付款比例
    public String PAIDCOST;//累计付款金额
    public String PAIDPROPORTION;//累计付款比例
    public String LASTRECALT;//最后到货日期
    public String GUARANTEE;//预留质保金
    public String PERIOD;//质保期
    public String EXPIRATIONALT;//质保到期日期
    public String VENDORNUM;//供应商编号
    public String VENDOR;//供应商
    public String COMPANIES_DUNSNUM;//组织机构代码
    public String TAXNUM;//税号
    public String BANKNUM;//开户银行
    public String BANKACCOUNT;//银行帐号
    public String INVOICENUM;//登记发票号
    public String VENDORINVNUM;//供应商发票号
    public String ADDALT;//登记日期
    public String NEWALT;//开票日期
    public String INVOICE_TOTALCOST;//发票总金额
    public String PAYNUM;//付款审批单号
    public String DESCRIPTION;//描述
    public String PONUM;//采购单编号
    public String PODESC;//采购单描述
    public String CONTRACTNUM;//合同编号
    public String CONTRACTDESC;//合同名称
    public String STATUS;//状态
    public String ZHANGTAO;//帐套信息
    public String DOMAIN_DESCRIPTION;//单位名称
    public String PAYPO_RECEIPTS;//入库情况
    public String CREATEBY;//创建人
    public String CREATEALT;//创建时间
    public String PAYTYPE;//付款类型


    public String getPAYAPPROVETYPE() {
        return PAYAPPROVETYPE;
    }

    public void setPAYAPPROVETYPE(String PAYAPPROVETYPE) {
        this.PAYAPPROVETYPE = PAYAPPROVETYPE;
    }

    public String getPOTOTALCOST() {
        return POTOTALCOST;
    }

    public void setPOTOTALCOST(String POTOTALCOST) {
        this.POTOTALCOST = POTOTALCOST;
    }

    public String getTOTALCOST() {
        return TOTALCOST;
    }

    public void setTOTALCOST(String TOTALCOST) {
        this.TOTALCOST = TOTALCOST;
    }

    public String getFINALCOST() {
        return FINALCOST;
    }

    public void setFINALCOST(String FINALCOST) {
        this.FINALCOST = FINALCOST;
    }

    public String getPAYCOST() {
        return PAYCOST;
    }

    public void setPAYCOST(String PAYCOST) {
        this.PAYCOST = PAYCOST;
    }

    public String getPAYPROPORTION() {
        return PAYPROPORTION;
    }

    public void setPAYPROPORTION(String PAYPROPORTION) {
        this.PAYPROPORTION = PAYPROPORTION;
    }

    public String getPAIDCOST() {
        return PAIDCOST;
    }

    public void setPAIDCOST(String PAIDCOST) {
        this.PAIDCOST = PAIDCOST;
    }

    public String getPAIDPROPORTION() {
        return PAIDPROPORTION;
    }

    public void setPAIDPROPORTION(String PAIDPROPORTION) {
        this.PAIDPROPORTION = PAIDPROPORTION;
    }

    public String getLASTRECALT() {
        return LASTRECALT;
    }

    public void setLASTRECALT(String LASTRECALT) {
        this.LASTRECALT = LASTRECALT;
    }

    public String getGUARANTEE() {
        return GUARANTEE;
    }

    public void setGUARANTEE(String GUARANTEE) {
        this.GUARANTEE = GUARANTEE;
    }

    public String getPERIOD() {
        return PERIOD;
    }

    public void setPERIOD(String PERIOD) {
        this.PERIOD = PERIOD;
    }

    public String getEXPIRATIONALT() {
        return EXPIRATIONALT;
    }

    public void setEXPIRATIONALT(String EXPIRATIONALT) {
        this.EXPIRATIONALT = EXPIRATIONALT;
    }

    public String getVENDORNUM() {
        return VENDORNUM;
    }

    public void setVENDORNUM(String VENDORNUM) {
        this.VENDORNUM = VENDORNUM;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public String getCOMPANIES_DUNSNUM() {
        return COMPANIES_DUNSNUM;
    }

    public void setCOMPANIES_DUNSNUM(String COMPANIES_DUNSNUM) {
        this.COMPANIES_DUNSNUM = COMPANIES_DUNSNUM;
    }

    public String getTAXNUM() {
        return TAXNUM;
    }

    public void setTAXNUM(String TAXNUM) {
        this.TAXNUM = TAXNUM;
    }

    public String getBANKNUM() {
        return BANKNUM;
    }

    public void setBANKNUM(String BANKNUM) {
        this.BANKNUM = BANKNUM;
    }

    public String getBANKACCOUNT() {
        return BANKACCOUNT;
    }

    public void setBANKACCOUNT(String BANKACCOUNT) {
        this.BANKACCOUNT = BANKACCOUNT;
    }

    public String getINVOICENUM() {
        return INVOICENUM;
    }

    public void setINVOICENUM(String INVOICENUM) {
        this.INVOICENUM = INVOICENUM;
    }

    public String getVENDORINVNUM() {
        return VENDORINVNUM;
    }

    public void setVENDORINVNUM(String VENDORINVNUM) {
        this.VENDORINVNUM = VENDORINVNUM;
    }

    public String getADDALT() {
        return ADDALT;
    }

    public void setADDALT(String ADDALT) {
        this.ADDALT = ADDALT;
    }

    public String getNEWALT() {
        return NEWALT;
    }

    public void setNEWALT(String NEWALT) {
        this.NEWALT = NEWALT;
    }

    public String getINVOICE_TOTALCOST() {
        return INVOICE_TOTALCOST;
    }

    public void setINVOICE_TOTALCOST(String INVOICE_TOTALCOST) {
        this.INVOICE_TOTALCOST = INVOICE_TOTALCOST;
    }

    public String getPAYNUM() {
        return PAYNUM;
    }

    public void setPAYNUM(String PAYNUM) {
        this.PAYNUM = PAYNUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPONUM() {
        return PONUM;
    }

    public void setPONUM(String PONUM) {
        this.PONUM = PONUM;
    }

    public String getPODESC() {
        return PODESC;
    }

    public void setPODESC(String PODESC) {
        this.PODESC = PODESC;
    }

    public String getCONTRACTNUM() {
        return CONTRACTNUM;
    }

    public void setCONTRACTNUM(String CONTRACTNUM) {
        this.CONTRACTNUM = CONTRACTNUM;
    }

    public String getCONTRACTDESC() {
        return CONTRACTDESC;
    }

    public void setCONTRACTDESC(String CONTRACTDESC) {
        this.CONTRACTDESC = CONTRACTDESC;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getZHANGTAO() {
        return ZHANGTAO;
    }

    public void setZHANGTAO(String ZHANGTAO) {
        this.ZHANGTAO = ZHANGTAO;
    }

    public String getDOMAIN_DESCRIPTION() {
        return DOMAIN_DESCRIPTION;
    }

    public void setDOMAIN_DESCRIPTION(String DOMAIN_DESCRIPTION) {
        this.DOMAIN_DESCRIPTION = DOMAIN_DESCRIPTION;
    }

    public String getPAYPO_RECEIPTS() {
        return PAYPO_RECEIPTS;
    }

    public void setPAYPO_RECEIPTS(String PAYPO_RECEIPTS) {
        this.PAYPO_RECEIPTS = PAYPO_RECEIPTS;
    }

    public String getCREATEBY() {
        return CREATEBY;
    }

    public void setCREATEBY(String CREATEBY) {
        this.CREATEBY = CREATEBY;
    }

    public String getCREATEALT() {
        return CREATEALT;
    }

    public void setCREATEALT(String CREATEALT) {
        this.CREATEALT = CREATEALT;
    }

    public String getPAYTYPE() {
        return PAYTYPE;
    }

    public void setPAYTYPE(String PAYTYPE) {
        this.PAYTYPE = PAYTYPE;
    }
}
