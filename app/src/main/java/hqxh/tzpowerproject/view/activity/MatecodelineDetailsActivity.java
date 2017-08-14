package hqxh.tzpowerproject.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.MATECODELINE;
import hqxh.tzpowerproject.model.PAYAPPROVE;


/**
 * 物资编码行详情
 */
public class MatecodelineDetailsActivity extends BaseActivity {
    private static String TAG = "MatecodelineDetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    @Bind(R.id.mc_materialinfonum_text_id)
    TextView mc_materialinfonumText;//物资编码
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.mc_materialdatatype_text_id)
    TextView mc_materialdatatypeText;//分类
    @Bind(R.id.mc_standardname_text_id)
    TextView mc_standardnameText;//物资名称
    @Bind(R.id.mc_lottype_text_id)
    TextView mc_lottypeText;//批次
    @Bind(R.id.mc_unit_text_id)
    TextView mc_unitText;//采购单位
    @Bind(R.id.status_text)
    TextView statusText;//状态
    @Bind(R.id.mc_price_text_id)
    TextView mc_price_Text;//估价


    private MATECODELINE matecodeline;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matecodeline_details);
        ButterKnife.bind(MatecodelineDetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        matecodeline = (MATECODELINE) getIntent().getSerializableExtra("matecodeline");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        mc_materialinfonumText.setText(matecodeline.getMC_MATERIALINFONUM());
        descriptionText.setText(matecodeline.getMC_MATERIALDESC());
        mc_materialdatatypeText.setText(matecodeline.getMC_MATERIALDATATYPE());
        mc_standardnameText.setText(matecodeline.getMC_STANDARDNAME());
        mc_lottypeText.setText(matecodeline.getMC_LOTTYPE());
        mc_unitText.setText(matecodeline.getMC_UNIT());
        statusText.setText(matecodeline.getMC_MATERIALDESC());
        mc_price_Text.setText(matecodeline.getMC_PRICE());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
