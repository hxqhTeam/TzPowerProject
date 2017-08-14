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
import hqxh.tzpowerproject.model.MATECODE;
import hqxh.tzpowerproject.model.PR;


/**
 * 物资编码
 */
public class MatecodeDetailsActivity extends BaseActivity {
    private static String TAG = "MatecodeDetailsActivity";

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

    @Bind(R.id.mc_materialcodenum_text_id)
    TextView mc_materialcodenumText;//单号
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.mc_createdby_text_id)
    TextView mc_createdbyText;//申请人
    @Bind(R.id.mc_department_text_id)
    TextView mc_departmentText;//申请部门
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//套帐信息
    @Bind(R.id.alndomain_zt_description_text_id)
    TextView alndomain_zt_descriptionText;//帐套描述
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.mc_createtime_text_id)
    TextView mc_createtimeText;//申请时间


    private MATECODE matecode;

    private TextView cgsqhLinearLayout; //申请物资编码
    private TextView spgcLinearLayout; //审批过程




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matecode_details);
        ButterKnife.bind(MatecodeDetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private void geiIntentData() {
        matecode = (MATECODE) getIntent().getSerializableExtra("matecode");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        mc_materialcodenumText.setText(matecode.getMC_MATERIALCODENUM());
        descriptionText.setText(matecode.getDESCRIPTION());
        mc_createdbyText.setText(matecode.getMC_CREATEDBY());
        mc_departmentText.setText(matecode.getMC_DEPARTMENT());
        zhangtaoText.setText(matecode.getZHANGTAO());
        alndomain_zt_descriptionText.setText(matecode.getALNDOMAIN_ZT_DESCRIPTION());
        statusText.setText(matecode.getSTATUS());
        mc_createtimeText.setText(matecode.getMC_CREATETIME());

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
        View contentView = LayoutInflater.from(MatecodeDetailsActivity.this).inflate(
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

        cgsqhLinearLayout = (TextView) contentView.findViewById(R.id.cgsqh_text_id);
        spgcLinearLayout = (TextView) contentView.findViewById(R.id.spjl_text_id);
        cgsqhLinearLayout.setVisibility(View.VISIBLE);
        cgsqhLinearLayout.setText(R.string.sqwzbm_text);
        cgsqhLinearLayout.setOnClickListener(cgsqhLinearLayoutOnClickListener);
        spgcLinearLayout.setOnClickListener(spgcLinearLayoutOnClickListener);
    }

    private View.OnClickListener cgsqhLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent =new Intent(MatecodeDetailsActivity.this,MatecodeLineListActivity.class);
            intent.putExtra("mc_materialinfonum",matecode.getMC_MATERIALCODENUM());
            startActivityForResult(intent,0);
        }
    };
    private View.OnClickListener spgcLinearLayoutOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();

            Intent intent =new Intent(MatecodeDetailsActivity.this,WftransactionListActivity.class);
            intent.putExtra("ownertable", Constants.MATECODE_NAME);
            intent.putExtra("ownerid",matecode.getMATECODEID());
            startActivityForResult(intent,0);

        }
    };

}
