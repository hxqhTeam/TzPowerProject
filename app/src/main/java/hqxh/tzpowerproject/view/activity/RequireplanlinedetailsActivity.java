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


/**
 * 需求申请行详情
 */
public class RequireplanlinedetailsActivity extends BaseActivity {
    private static String TAG = "RequireplanlinedetailsActivity";

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
    @Bind(R.id.allcurbal_text_id)
    TextView allcurbalText;//总库存数量
    @Bind(R.id.allinvresbal_text_id)
    TextView allinvresbalText;//总预留数量
    @Bind(R.id.invusebal_text_id)
    TextView invusebalText;//半年内领用
    @Bind(R.id.count_text_id)
    TextView countText;//需求数量
    @Bind(R.id.prcount_text_id)
    TextView prcountText;//订购数量
    @Bind(R.id.measurement_text_id)
    TextView measurementText;//订购单位
    @Bind(R.id.lzesticost_text_id)
    TextView lzesticostText;//零值估价
    @Bind(R.id.percost_text_id)
    TextView percostText;//单位成本
    @Bind(R.id.itemtotalcost_text_id)
    TextView itemtotalcostText;//行成本


    private REQUIREPLANLINE requireplanline;



    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requireplanline_details);
        ButterKnife.bind(RequireplanlinedetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        requireplanline = (REQUIREPLANLINE) getIntent().getSerializableExtra("requireplanline");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        requireplanlinenumText.setText(requireplanline.getREQUIREPLANLINENUM());
        itemnumText.setText(requireplanline.getITEMNUM());
        descriptionText.setText(requireplanline.getITEMDESC());
        itemspecvendorText.setText(requireplanline.getITEMSPECVENDOR());
        allcurbalText.setText(requireplanline.getALLCURBAL());
        allinvresbalText.setText(requireplanline.getALLINVRESBAL());
        invusebalText.setText(requireplanline.getINVUSEBAL());
        countText.setText(requireplanline.getCOUNT());
        prcountText.setText(requireplanline.getPRCOUNT());
        measurementText.setText(requireplanline.getMEASUREMENT());
        lzesticostText.setText(requireplanline.getLZESTICOST());
        percostText.setText(requireplanline.getPERCOST());
        itemtotalcostText.setText(requireplanline.getITEMTOTALCOST());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }


}
