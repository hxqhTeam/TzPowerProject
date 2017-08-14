package hqxh.tzpowerproject.model;

/**
 * Created by think on 2016/7/1.
 *合同文本
 */
public class DOCLINKS extends Entity{
    public String DOCUMENT;//文档
    public String DOCINFO_DESCRIPTION;//文档描述
    public String PERSON_DISPLAYNAME;//创建人
    public String CREATEDATE;//创建日期
    public String DOCINFO_URLNAME;//URL地址

    public String getDOCUMENT() {
        return DOCUMENT;
    }

    public void setDOCUMENT(String DOCUMENT) {
        this.DOCUMENT = DOCUMENT;
    }

    public String getDOCINFO_DESCRIPTION() {
        return DOCINFO_DESCRIPTION;
    }

    public void setDOCINFO_DESCRIPTION(String DOCINFO_DESCRIPTION) {
        this.DOCINFO_DESCRIPTION = DOCINFO_DESCRIPTION;
    }

    public String getPERSON_DISPLAYNAME() {
        return PERSON_DISPLAYNAME;
    }

    public void setPERSON_DISPLAYNAME(String PERSON_DISPLAYNAME) {
        this.PERSON_DISPLAYNAME = PERSON_DISPLAYNAME;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getDOCINFO_URLNAME() {
        return DOCINFO_URLNAME;
    }

    public void setDOCINFO_URLNAME(String DOCINFO_URLNAME) {
        this.DOCINFO_URLNAME = DOCINFO_URLNAME;
    }
}
