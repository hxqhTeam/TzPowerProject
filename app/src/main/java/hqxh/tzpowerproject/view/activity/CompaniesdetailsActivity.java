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

import java.nio.Buffer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.COMPANIES;

/**
 * Created by Administrator on 2017/8/13.
 * 供应商详情
 */

public class CompaniesdetailsActivity extends BaseActivity {

    private static String TAG = "CompaniesdetailsActivity";
    /*返回按钮*/
    @Bind(R.id.title_back_id)
    ImageView backImageView;

    /*标题*/
    @Bind(R.id.title_name)
    TextView titleTextView;

    /*菜单按钮*/
    @Bind(R.id.title_add)
    ImageView menuImageView;
    private PopupWindow popupWindow;

    @Bind(R.id.company_text_id)
    TextView companyText;//供应商
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.producttype_text_id)
    TextView producttypeText;//供货类型
    @Bind(R.id.cptype_text_id)
    TextView cptypeText;//供货商类型
    @Bind(R.id.status_text_id)
    TextView statusText;//状态
    @Bind(R.id.remark_text_id)
    TextView remarkText;//简介

    private TextView pfjlText; //评分记录
    private TextView spgcText; //审批过程

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_details);
        ButterKnife.bind(CompaniesdetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }

    private COMPANIES companies;

    private void geiIntentData() {
        companies = (COMPANIES) getIntent().getSerializableExtra("companies");
    }

    @Override
    protected void findViewById() {
        titleTextView.setText(R.string.xq_title);
        menuImageView.setVisibility(View.VISIBLE);

    }

    @Override
    protected void initView() {
        companyText.setText(companies.getCOMPANY());
        descriptionText.setText(companies.getNAME());
        producttypeText.setText(companies.getPRODUCTTYPE());
        cptypeText.setText(companies.getTYPE());
        statusText.setText(companies.getSTATUS());
        remarkText.setText(companies.getREMARK());


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


    /**
     * 初始化showPopupWindow*
     */
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(CompaniesdetailsActivity.this).inflate(
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

        pfjlText = (TextView) contentView.findViewById(R.id.cgsqh_text_id);
        spgcText = (TextView) contentView.findViewById(R.id.spjl_text_id);
        pfjlText.setVisibility(View.VISIBLE);
        pfjlText.setText(R.string.pfjl_text);
        pfjlText.setOnClickListener(cgsqhLinearLayoutOnClickListener);
        spgcText.setOnClickListener(spgcLinearLayoutOnClickListener);
    }

    private View.OnClickListener cgsqhLinearLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            Intent intent = new Intent(CompaniesdetailsActivity.this, CompshistoryListActivity.class);
            intent.putExtra("company", companies.getCOMPANY());
            startActivityForResult(intent, 0);
        }
    };
    private View.OnClickListener spgcLinearLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();

            Intent intent = new Intent(CompaniesdetailsActivity.this, WftransactionListActivity.class);
            intent.putExtra("ownertable", Constants.COMPANIES_NAME);
            intent.putExtra("ownerid", companies.getCOMPANIESID());
            startActivityForResult(intent, 0);

        }
    };

}
