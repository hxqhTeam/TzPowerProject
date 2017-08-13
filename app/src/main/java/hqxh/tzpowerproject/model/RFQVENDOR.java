package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *供应商／工程采购申请行
 */
public class RFQVENDOR extends Entity{
    public String VENDOR;//供应商
    public String CONTACT;//联系人
    public String PHONE;//电话
    public String EMAIL;//电子邮件

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
