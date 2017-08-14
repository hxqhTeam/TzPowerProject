package hqxh.tzpowerproject.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.PAYMENTPLAN;


/**
 * 付款执行情况详情
 */
public class PayapproveItemDetailsActivity extends BaseActivity {
    private static String TAG = "PayapproveItemDetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    @Bind(R.id.paynum_text_id)
    TextView paynumText;//单号
    @Bind(R.id.description_text_id)
    TextView descriptionText;//付款内容
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.createdate_text_id)
    TextView createdateText;//输入日期
    @Bind(R.id.actualpaycost_text_id)
    TextView actualpaycostText;//付款金额
    @Bind(R.id.actualpaydate_text_id)
    TextView actualpaydateText;//实际付款日期
    @Bind(R.id.remark_text_id)
    TextView remarkText;//备注


    private PAYAPPROVE payapprove;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payapproveitem_details);
        ButterKnife.bind(PayapproveItemDetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        payapprove = (PAYAPPROVE) getIntent().getSerializableExtra("payapprove");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        paynumText.setText(payapprove.getPAYNUM());
        descriptionText.setText(payapprove.getDESCRIPTION());
        statusText.setText(payapprove.getSTATUS());
        createdateText.setText(payapprove.getCREATEDATE());
        actualpaycostText.setText(payapprove.getACTUALPAYCOST());
        actualpaydateText.setText(payapprove.getACTUALPAYDATE());
        remarkText.setText(payapprove.getREMARKS());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
