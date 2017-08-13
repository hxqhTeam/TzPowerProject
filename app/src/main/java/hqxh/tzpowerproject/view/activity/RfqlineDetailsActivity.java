package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.model.REQUIREPLANLINE;
import hqxh.tzpowerproject.model.RFQLINE;


/**
 * 询价单行详情
 */
public class RfqlineDetailsActivity extends BaseActivity {
    private static String TAG = "RfqlineDetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    @Bind(R.id.line_text_id)
    TextView requireplanlinenumText;//行
    @Bind(R.id.itemnum_text_id)
    TextView itemnumText;//物资编码
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.itemspecvendor_text_id)
    TextView itemspecvendorText;//制造厂商
    @Bind(R.id.orderqty_text_id)
    TextView orderqtyText;//数量
    @Bind(R.id.orderunit_text_id)
    TextView orderunitText;//订购单位
    @Bind(R.id.requestedbyname_text_id)
    TextView requestedbynameText;//需求人
    @Bind(R.id.unitcost_text_id)
    TextView unitcostText;//最后一次报价
    @Bind(R.id.enterdate_text_id)
    TextView enterdateText;//最后一次报价时间
    @Bind(R.id.name_text_id)
    TextView nameText;//最后一次报价供应商


    private RFQLINE rfqline;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rfqline_details);
        ButterKnife.bind(RfqlineDetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        rfqline = (RFQLINE) getIntent().getSerializableExtra("rfqline");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        requireplanlinenumText.setText(rfqline.getRFQLINENUM());
        itemnumText.setText(rfqline.getITEMNUM());
        descriptionText.setText(rfqline.getDESCRIPTION());
        itemspecvendorText.setText(rfqline.getITEM_ITEMSPECVENDOR_ALNVALUE());
        orderqtyText.setText(rfqline.getORDERQTY());
        orderunitText.setText(rfqline.getORDERUNIT());
        requestedbynameText.setText(rfqline.getPERSON_DISPLAYNAME());
        unitcostText.setText(rfqline.getPOLINEHIS_UNITCOST());
        enterdateText.setText(rfqline.getPOLINEHIS_ENTERALT());
        nameText.setText(rfqline.getCOMHIS_NAME());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
