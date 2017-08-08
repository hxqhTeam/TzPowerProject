package hqxh.tzpowerproject.view.activity;

import android.animation.LayoutTransition;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.Bind;
import hqxh.tzpowerproject.R;


/**
 * 需求申请详情
 */
public class RequireplandetailsActivity extends BaseActivity {
    private static String TAG = "RequireplandetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;

//    @Bind()
//    private TextView sb;//设备
//    private TextView sbwz;//设备位置
//    private ImageView photoImg;//拍照
//    private EditText description;//缺陷描述
//    private TextView fxbm;//发现部门
//    private ImageView fxbm_img;//
//    private TextView fxr;//发现人
//    private TextView reportdate;//发现时间
//    private TextView zrr;//责任人
//    private TextView schedfinish;//整改期限
//    private EditText n_recreq;//整改要求
//    private CheckBox worktype;//是否排查
//    private EditText remarkdesc;//备注
//
//
//    private WORKORDER workorder;
//
//
//    /**界面信息**/
//
//    /**
//     * 时间选择器
//     **/
//    private DatePickerDialog datePickerDialog;
//    StringBuffer stringBuffer;
//    private int layoutnum;
//
//    private ArrayAdapter<String> adapter;
//
//
//    //弹出框
//    private ArrayList<DialogMenuItem> mMenuItems = new ArrayList<>();
//
//
//    private BaseAnimatorSet mBasIn;
//    private BaseAnimatorSet mBasOut;
//
//
//    protected FlippingLoadingDialog mLoadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requireplan_details);
//        geiIntentData();
        findViewById();
        initView();

//        mBasIn = new BounceTopEnter();
//        mBasOut = new SlideBottomExit();
    }

//    private void geiIntentData() {
//        workorder = (WORKORDER) getIntent().getSerializableExtra("workorder");
//    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.title_back_id);
        titleTextView = (TextView) findViewById(R.id.title_name);
//        submitBtn = (Button) findViewById(R.id.sbmit_id);
//
//        sb = (TextView) findViewById(R.id.workorder_sb);
//        sbwz = (TextView) findViewById(R.id.workorder_sbwz);
//        photoImg = (ImageView) findViewById(R.id.photo_image);
//        description = (EditText) findViewById(R.id.workorder_description);
//        fxbm = (TextView) findViewById(R.id.workorder_fxbm);
//        fxbm_img = (ImageView) findViewById(R.id.fxbm_img);
//        fxr = (TextView) findViewById(R.id.workorder_fxr);
//        reportdate = (TextView) findViewById(R.id.workorder_reportdate);
//        zrr = (TextView) findViewById(R.id.workorder_zrr);
//        schedfinish = (TextView) findViewById(R.id.workorder_schedfinish);
//        n_recreq = (EditText) findViewById(R.id.workorder_n_recreq);
//        worktype = (CheckBox) findViewById(R.id.workorder_worktype);
//        remarkdesc = (EditText) findViewById(R.id.workorder_remarkdesc);
//
//        ViewGroup container = (ViewGroup) findViewById(R.id.container);
//        LayoutTransition transition = new LayoutTransition();
//        container.setLayoutTransition(transition);
    }


    @Override
    protected void initView() {
//        backImageView.setOnClickListener(backImageViewOnClickListener);
//        titleTextView.setText(R.string.workorder_details_title);

    }


}
