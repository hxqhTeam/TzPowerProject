package hqxh.tzpowerproject.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PAYMENTPLAN;
import hqxh.tzpowerproject.model.POLINE;


/**
 * 付款计划
 */
public class PaymentplanDetailsActivity extends BaseActivity {
    private static String TAG = "PolinedetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    @Bind(R.id.paytype_text_id)
    TextView paytypeText;//付款内容
    @Bind(R.id.payratio_text_id)
    TextView payratioText;//付款比例
    @Bind(R.id.payamount_text_id)
    TextView payamountText;//付款金额
    @Bind(R.id.payplandate_text_id)
    TextView payplandateText;//预付款日期
    @Bind(R.id.cjr_text_id)
    TextView cjrText;//创建人
    @Bind(R.id.createtime_text_id)
    TextView createtimeText;//创建日期
    @Bind(R.id.person_displayname_text_id)
    TextView person_displaynameText;//最后修改人
    @Bind(R.id.lastmodtime_text_id)
    TextView lastmodtimeText;//最后修改日期


    private PAYMENTPLAN paymentplan;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentplan_details);
        ButterKnife.bind(PaymentplanDetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        paymentplan = (PAYMENTPLAN) getIntent().getSerializableExtra("paymentplan");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        paytypeText.setText(paymentplan.getPAYTYPE());
        payratioText.setText(paymentplan.getPAYRATIO());
        payamountText.setText(paymentplan.getPAYAMOUNT());
        payplandateText.setText(paymentplan.getPAYPLANDATE());
        cjrText.setText(paymentplan.getPERSON_DISPLAYNAME());
        createtimeText.setText(paymentplan.getCREATEPEROSN());
        person_displaynameText.setText(paymentplan.getPERSON_DISPLAYNAME());
        lastmodtimeText.setText(paymentplan.getLASTMODTIME());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
