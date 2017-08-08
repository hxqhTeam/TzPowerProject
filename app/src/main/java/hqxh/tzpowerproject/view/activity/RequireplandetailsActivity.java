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
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.REQUIREPLAN;


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

    @Bind(R.id.requireplannum_text_id)
    TextView requireplannumText;//申请单号
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//账套信息
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//账套描述
    @Bind(R.id.status_text_id)
    TextView statusText;//审批状态
    @Bind(R.id.itemtype_text_id)
    TextView itemtypeText;//需求计划类型
    @Bind(R.id.plantype_text_id)
    TextView plantypeText;//计划类型
    @Bind(R.id.requireperson_text_id)
    TextView requirepersonText;//需求人员
    @Bind(R.id.department_text_id)
    TextView departmentText;//部门专业
    @Bind(R.id.projectnum_text_id)
    TextView projectnumText;//项目编号
    @Bind(R.id.projectname_text_id)
    TextView projectnameText;//项目名称
    @Bind(R.id.plancost_text_id)
    TextView plancostText;//项目预算
    @Bind(R.id.remaincost_text_id)
    TextView remaincostText;//预算剩余
    @Bind(R.id.createtime_text_id)
    TextView createtimeText;//申请日期
    @Bind(R.id.requiretime_text_id)
    TextView requiretimeText;//需求日期


    private REQUIREPLAN requireplan;


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requireplan_details);
        ButterKnife.bind(RequireplandetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        requireplan = (REQUIREPLAN) getIntent().getSerializableExtra("requireplan");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
    }


    @Override
    protected void initView() {
        requireplannumText.setText(requireplan.getREQUIREPLANNUM());
        descriptionText.setText(requireplan.getDESCRIPTION());
        zhangtaoText.setText(requireplan.getZHANGTAO());
        ztdescriptionText.setText(requireplan.getZTDESCRIPTION());
        statusText.setText(requireplan.getSTATUS());
        itemtypeText.setText(requireplan.getITEMTYPE());
        plantypeText.setText(requireplan.getPLANTYPE());
        requirepersonText.setText(requireplan.getREQUIREPERSON());
        departmentText.setText(requireplan.getDEPARTMENT());
        projectnumText.setText(requireplan.getPROJECTNUM());
        projectnameText.setText(requireplan.getPROJECTNAME());
        plancostText.setText(requireplan.getPLANCOST());
        remaincostText.setText(requireplan.getREMAINCOST());
        createtimeText.setText(requireplan.getCREATETIME());
        requiretimeText.setText(requireplan.getREQUIRETIME());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }

}
