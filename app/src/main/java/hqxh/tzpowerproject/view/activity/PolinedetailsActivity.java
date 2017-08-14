package hqxh.tzpowerproject.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.POLINE;
import hqxh.tzpowerproject.model.REQUIREPLANLINE;


/**
 * 采购单行
 */
public class PolinedetailsActivity extends BaseActivity {
    private static String TAG = "PolinedetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    @Bind(R.id.line_text_id)
    TextView polinenumText;//行
    @Bind(R.id.itemnum_text_id)
    TextView itemnumText;//物资编码
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.itemspecvendor_text_id)
    TextView itemspecvendorText;//制造厂商
    @Bind(R.id.orderqty_text_id)
    TextView orderqtyText;//订购数量
    @Bind(R.id.orderunit_text_id)
    TextView orderunitText;//订购单位
    @Bind(R.id.storeloc_text_id)
    TextView storelocText;//库房
    @Bind(R.id.unitcost_text_id)
    TextView unitcostText;//不含税单价
    @Bind(R.id.linecost_text_id)
    TextView linecostText;//不含税总价
    @Bind(R.id.afteraunitcost_text_id)
    TextView afteraunitcostText;//含税单价
    @Bind(R.id.afteralinecost_text_id)
    TextView afteralinecostText;//含税总价
    @Bind(R.id.reqdeliverydate_text_id)
    TextView reqdeliverydateText;//到货日期
    @Bind(R.id.requestedbyname_text_id)
    TextView requestedbynameText;//需求人
    @Bind(R.id.remark_text_id)
    TextView remarkText;//备注
    @Bind(R.id.projectnum_text_id)
    TextView projectnumText;//项目编号
    @Bind(R.id.projectname_text_id)
    TextView projectnameText;//项目名称
    @Bind(R.id.requireplannum_text_id)
    TextView requireplannumText;//需求计划
    @Bind(R.id.rfqnum_text_id)
    TextView rfqnumText;//询价单
    @Bind(R.id.prnum_text_id)
    TextView prnumText;//采购申请


    private POLINE poline;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poline_details);
        ButterKnife.bind(PolinedetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        poline = (POLINE) getIntent().getSerializableExtra("poline");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        polinenumText.setText(poline.getPOLINENUM());
        itemnumText.setText(poline.getITEMNUM());
        descriptionText.setText(poline.getDESCRIPTION());
        itemspecvendorText.setText(poline.getITEM_ITEMSPECVENDOR_ALNVALUE());
        orderqtyText.setText(poline.getORDERQTY());
        orderunitText.setText(poline.getORDERUNIT());
        storelocText.setText(poline.getSTORELOC());
        unitcostText.setText(poline.getUNITCOST());
        linecostText.setText(poline.getLINECOST());
        afteraunitcostText.setText(poline.getAFTERAUNITCOST());
        afteralinecostText.setText(poline.getAFTERALINECOST());
        reqdeliverydateText.setText(poline.getREQDELIVERYDATE());
        requestedbynameText.setText(poline.getPERSON_DISPLAYNAME());
        remarkText.setText(poline.getREMARK());
        projectnumText.setText(poline.getPROJECTNUM());
        projectnameText.setText(poline.getPROJECTNAME());
        requireplannumText.setText(poline.getREQUIREPLANNUM());
        rfqnumText.setText(poline.getRFQNUM());
        prnumText.setText(poline.getPRNUM());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
