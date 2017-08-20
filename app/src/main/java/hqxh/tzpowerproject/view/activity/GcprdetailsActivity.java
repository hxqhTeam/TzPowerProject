package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.PR;


/**
 * 工程采购
 */
public class GcprdetailsActivity extends BaseActivity {
    private static String TAG = "GcprdetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;

    /**菜单按钮**/
    @Bind(R.id.title_add)
    ImageView menuImageView;

    private PopupWindow popupWindow;

    @Bind(R.id.prnum_text_id)
    TextView prnumText;//采购申请
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//账套信息
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//账套描述
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.totalcost_text_id)
    TextView totalcostText;//预估总价
    @Bind(R.id.projectnum_text_id)
    TextView projectnumText;//项目编号
    @Bind(R.id.projectdesc_text_id)
    TextView projectdescText;//项目描述
    @Bind(R.id.projectec_text_id)
    TextView projectecText;//预算额度
    @Bind(R.id.projectsc_text_id)
    TextView projectscText;//预算剩余
    @Bind(R.id.requireperson_text_id)
    TextView requirepersonText;//需求人
    @Bind(R.id.mc_department_text_id)
    TextView mc_departmentText;//申请部门
    @Bind(R.id.prgqyq_text_id)
    TextView prgqyqText;//工期要求
    @Bind(R.id.remark_text_id)
    TextView remarkText;//说明


    private PR pr;

    private TextView cgsqhText; //采购申请行
    private TextView xgText; //相关文件
    private TextView spgcText; //审批过程


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcpr_details);
        ButterKnife.bind(GcprdetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        pr = (PR) getIntent().getSerializableExtra("pr");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        prnumText.setText(pr.getPRNUM());
        descriptionText.setText(pr.getDESCRIPTION());
        zhangtaoText.setText(pr.getZHANGTAO());
        ztdescriptionText.setText(pr.getALNDOMAIN_ZT_DESCRIPTION());
        statusText.setText(pr.getSTATUS());
        totalcostText.setText(pr.getTOTALCOST());
        projectnumText.setText(pr.getPROJECTNUM());
        projectdescText.setText(pr.getPROJECTDESC());
        projectecText.setText(pr.getPROJECT_PROJECTEC());
        projectscText.setText(pr.getPROJECT_PROJECTSC());
        requirepersonText.setText(pr.getREQUESTEDBYNAME());
        mc_departmentText.setText(pr.getDEPARTMENT());
        prgqyqText.setText(pr.getPRGQYQ());
        remarkText.setText(pr.getREMARK());

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }

    //菜单按钮
    @OnClick(R.id.title_add)
    void setMenuImageView(){
        showPopupWindow(menuImageView);
    }


    /**
     * 初始化showPopupWindow*
     */
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(GcprdetailsActivity.this).inflate(
                R.layout.cgsq_popup_window, null);


        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                return false;
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.popup_background_mtrl_mult));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

        cgsqhText = (TextView) contentView.findViewById(R.id.cgsqh_text_id);
        xgText = (TextView) contentView.findViewById(R.id.xgwj_text_id);
        spgcText = (TextView) contentView.findViewById(R.id.spjl_text_id);
        cgsqhText.setVisibility(View.VISIBLE);
        xgText.setVisibility(View.VISIBLE);
        cgsqhText.setOnClickListener(cgsqhLinearLayoutOnClickListener);
        xgText.setOnClickListener(xgTextOnClickListener);
        spgcText.setOnClickListener(spgcLinearLayoutOnClickListener);
    }

    private View.OnClickListener cgsqhLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(GcprdetailsActivity.this,PrLineListActivity.class);
            intent.putExtra("prnum",pr.getPRNUM());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener xgTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(GcprdetailsActivity.this,DoclinksListActivity.class);
            intent.putExtra("title",getResources().getString(R.string.xgwj_text));
            intent.putExtra("ownertable",Constants.PR_NAME);
            intent.putExtra("ownerid",pr.getPRID());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener spgcLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();

            Intent intent =new Intent(GcprdetailsActivity.this,WftransactionListActivity.class);
            intent.putExtra("ownertable", Constants.PR_NAME);
            intent.putExtra("ownerid",pr.getPRID());
            startActivityForResult(intent,0);

        }
    };

}
