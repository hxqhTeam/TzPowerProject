package hqxh.tzpowerproject.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.Buffer;

import butterknife.Bind;
import butterknife.ButterKnife;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.COMPANIES;

/**
 * Created by Administrator on 2017/8/13.
 */

public class CompaniesdetailsActivity extends BaseActivity {

    private static String TAG="CompaniesdetailsActivity";
/*返回按钮*/
    @Bind(R.id.title_back_id)
    ImageView backImageView;

/*标题*/
    @Bind(R.id.title_name)
    TextView titleTextView;

   /*菜单按钮*/
    @Bind(R.id.title_add)
    ImageView menuImageView;

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
    TextView remarkText;//备注

    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_details);
        ButterKnife.bind(CompaniesdetailsActivity.this);
        geiIntentData();
        findViewById();
        initView();

    }
    private COMPANIES companies;
    private void geiIntentData(){
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

}
