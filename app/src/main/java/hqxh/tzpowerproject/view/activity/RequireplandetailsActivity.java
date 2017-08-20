package hqxh.tzpowerproject.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.api.JsonUtils;
import hqxh.tzpowerproject.bean.Approve;
import hqxh.tzpowerproject.bean.LoginResults;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;
import hqxh.tzpowerproject.view.widght.ConfirmDialog;


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

    /**
     * 菜单按钮
     **/
    @Bind(R.id.title_add)
    ImageView menuImageView;

    private PopupWindow popupWindow;

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
    @Bind(R.id.scrollView_id)
    ScrollView scrollview;

    @Bind(R.id.buttom_linearlayout_id)
    LinearLayout buttonLinearLayout;
    @Bind(R.id.btn_workflow_id)
    Button workflowBtn; //工作流审批


    private REQUIREPLAN requireplan;

    private LinearLayout xqjhLinearLayout; //需求计划


    private int mark;
    private String app;
    private String ownertable;
    private String ownerid;


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requireplan_details);
        ButterKnife.bind(RequireplandetailsActivity.this);
        getIntentData();
        findViewById();
        initView();

    }

    private void getIntentData() {
        if (getIntent().hasExtra("mark")) {
            mark = getIntent().getExtras().getInt("mark");
        }

        requireplan = (REQUIREPLAN) getIntent().getSerializableExtra("requireplan");

        if (getIntent().hasExtra("app")) {
            app = getIntent().getExtras().getString("app");
        }

        if (getIntent().hasExtra("ownertable")) {
            ownertable = getIntent().getExtras().getString("ownertable");
        }

        if (getIntent().hasExtra("ownerid")) {
            ownerid = getIntent().getExtras().getString("ownerid");
        }

    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);
        if (mark == Constants.TASK_CODE) {
            buttonLinearLayout.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(0, 0, 0, getHeight(buttonLinearLayout));//4个参数按顺序分别是左上右下
            scrollview.setLayoutParams(layoutParams);

        }
    }




    /**获取View的高度**/
    private int getHeight(View view){
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();

        return height;
    }


    @Override
    protected void initView() {
        if (null == requireplan || mark == Constants.TASK_CODE) {
            getData(app, ownertable, ownerid);
        } else {
            showData();
        }

    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }

    //菜单按钮
    @OnClick(R.id.title_add)
    void setMenuImageView() {
        showPopupWindow(menuImageView);
    }


    @OnClick(R.id.btn_workflow_id)
    void setOnClick() {
        Log.e(TAG, "启动工作流");
        PostStart();
    }


    /**
     * 初始化showPopupWindow*
     */
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(RequireplandetailsActivity.this).inflate(
                R.layout.xqjh_popup_window, null);


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

        xqjhLinearLayout = (LinearLayout) contentView.findViewById(R.id.plan_text_id);
        xqjhLinearLayout.setOnClickListener(xqjhLinearLayoutOnClickListener);
    }

    private View.OnClickListener xqjhLinearLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent = new Intent(RequireplandetailsActivity.this, RequireplanlineListActivity.class);
            intent.putExtra("requireplannum", requireplan.getREQUIREPLANNUM());
            startActivityForResult(intent, 0);
        }
    };


    //获取详情数据
    private void getData(String app, String ownertable, String ownerid) {

        String url = HttpManager.getREQUIREPLAN(app, ownertable, ownerid, AccountUtils.getPersionId(RequireplandetailsActivity.this));

        HttpManager.getDataPagingInfo(RequireplandetailsActivity.this, url, new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {

                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<REQUIREPLAN> item = JsonUtils.parsingREQUIREPLAN(results.getResultlist());
                if (item == null || item.isEmpty()) {
                } else {
                    requireplan = item.get(0);
                    showData();
                }
            }

            @Override
            public void onFailure(String error) {
            }
        });


    }


    private void showData() {
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


    //启动工作流
    private void PostStart() {

        HttpManager.postStart(RequireplandetailsActivity.this, ownertable, ownerid, app, AccountUtils.getUserName(RequireplandetailsActivity.this), new HttpRequestHandler<String>() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data=" + data);
                LoginResults loginResults = JsonUtils.parsingWorkFlow(data);
                if (loginResults.getErrcode().equals(Constants.WORKFLOW_106)) {
                    List<Approve> list = JsonUtils.parsingApprove(loginResults.getResult());
                    showDialog(list);
                }

            }

            @Override
            public void onSuccess(String data, int totalPages, int currentPage) {
                Log.e(TAG, "111=" + data);

            }

            @Override
            public void onFailure(String error) {
                Log.e(TAG, "error=" + error);

            }
        });

    }


    //弹出对话框
    public void showDialog(List<Approve> results) {//

        ConfirmDialog.Builder dialog = new ConfirmDialog.Builder(this);
        dialog.setTitle("审批")
                .setData(results)
                .setPositiveButton("确定", new ConfirmDialog.Builder.cOnClickListener() {
                    @Override
                    public void cOnClickListener(DialogInterface dialogInterface, Approve result, String memo) {
                        dialogInterface.dismiss();
                        PostApproval(ownertable, ownerid, memo, result.getIspositive(), AccountUtils.getPersionId(RequireplandetailsActivity.this));
                    }


                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }


    //审批工作流
    private void PostApproval(String ownertable, String ownerid, String memo, String selectWhat, String useruid) {

        HttpManager.approvalFlow(RequireplandetailsActivity.this, ownertable, ownerid, memo, selectWhat, useruid, new HttpRequestHandler<String>() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data=" + data);
                LoginResults loginResults = JsonUtils.parsingWorkFlow(data);
                MessageUtils.showMiddleToast(RequireplandetailsActivity.this, loginResults.getErrmsg());
                finish();
            }

            @Override
            public void onSuccess(String data, int totalPages, int currentPage) {
                Log.e(TAG, "111=" + data);

            }

            @Override
            public void onFailure(String error) {
                Log.e(TAG, "error=" + error);

            }
        });

    }

}
