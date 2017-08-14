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
import android.widget.PopupWindow;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.REQUIREPLAN;


/**
 *  工程付款actvity
 */
public class PayapprovedetailsActivity extends BaseActivity {
    private static String TAG = "PayapprovedetailsActivity";

    @Bind(R.id.title_back_id)
    ImageView backImageView;//返回按钮
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;
   /*菜单按钮* */
    @Bind(R.id.title_add)
   ImageView menuImageView;

    private PopupWindow popupWindow;

    @Bind(R.id.paynum_text_id)
    TextView paynumText;//审批单号
    @Bind(R.id.description_text_id)
    TextView descriptionText;//描述
    @Bind(R.id.ponum_text_id)
    TextView ponumText;//采购单编号
    @Bind(R.id.ztdescription_text_id)
    TextView ztdescriptionText;//采购单描述
    @Bind(R.id.contractnum_text_id)
    TextView contractnumText;//合同编号
    @Bind(R.id.contractdesc_text_id)
    TextView contractdescText;//合同名称
    @Bind(R.id.status_text_id)
    TextView statuseText;//审批状态
    @Bind(R.id.zhangtao_text_id)
    TextView zhangtaoText;//账套信息
    @Bind(R.id.financial_text_id)
    TextView financialText;//财务经办人
    @Bind(R.id.receipts_text_id)
    TextView receiptsText;//验收情况
    @Bind(R.id.displayname_text_id)
    TextView displaynameText;//创建人
    @Bind(R.id.createdate_text_id)
    TextView createdateText;//创建时间
    @Bind(R.id.paytype_text_id)
    TextView paytypeText;//付款类型
    @Bind(R.id.pototalcost_text_id)
    TextView pototalcostText;//采购单金额
    @Bind(R.id.totalcost_text_id)
    TextView totalcostText;//合同金额
    @Bind(R.id.finalcost_text_id)
    TextView finalcostText;//合同结算金额
    @Bind(R.id.paycost_text_id)
    TextView paycostText;//本次付款金额
    @Bind(R.id.payproportion_text_id)
    TextView payproportionText;//本次付款比例
    @Bind(R.id.guarantee_text_id)
    TextView guaranteeText;//预留质保金
    @Bind(R.id.agencyfund_text_id)
    TextView agencyfundText;//代收款
    @Bind(R.id.paidcost_text_id)
    TextView paidcostText;//累计付款金额
    @Bind(R.id.pretaxcost_text_id)
    TextView pretaxcostText;//合同累计付款比例
    @Bind(R.id.paidproportion_text_id)
    TextView paidproportionText;//采购单累计付款比例
    @Bind(R.id.lastrecdate_text_id)
    TextView lastrecdateText;//最后到货日期
    @Bind(R.id.period_text_id)
    TextView periodText;//质保期
    @Bind(R.id.expirationdate_text_id)
    TextView expirationdateText;//质保到期日期
    @Bind(R.id.difference_text_id)
    TextView differenceText;//差异情况
    @Bind(R.id.vendor_text_id)
    TextView vendorText;//供应商描述



    private PAYAPPROVE payapprove;
    private TextView annexText;
    private TextView shjlText;


    /**
     * 界面信息
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payapprove_details);
        ButterKnife.bind(PayapprovedetailsActivity.this);
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
        menuImageView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initView() {
        paynumText.setText(payapprove.getPAYNUM());
        descriptionText.setText(payapprove.getDESCRIPTION());
        ponumText.setText(payapprove.getPONUM());
        ztdescriptionText.setText(payapprove.getPODESC());
        contractnumText.setText(payapprove.getCONTRACTNUM());
        contractdescText.setText(payapprove.getCONTRACTDESC());
        statuseText.setText(payapprove.getSTATUS());
        zhangtaoText.setText(payapprove.getZHANGTAO());
        financialText.setText(payapprove.getFINANCIAL());
        receiptsText.setText(payapprove.getRECEIPTS());
        displaynameText.setText(payapprove.getCREATEBY());
        createdateText.setText(payapprove.getCREATEALT());
        paytypeText.setText(payapprove.getPAYTYPE());
        pototalcostText.setText(payapprove.getPOTOTALCOST());
        totalcostText.setText(payapprove.getTOTALCOST());
        finalcostText.setText(payapprove.getFINALCOST());
        paycostText.setText(payapprove.getPAYCOST());
        payproportionText.setText(payapprove.getPAYPROPORTION());
        guaranteeText.setText(payapprove.getGUARANTEE());
        agencyfundText.setText(payapprove.getAGENCYFUND());
        paidcostText.setText(payapprove.getPAIDCOST());
        pretaxcostText.setText(payapprove.getPRETAXCOST());
        paidproportionText.setText(payapprove.getPAIDPROPORTION());
        lastrecdateText.setText(payapprove.getLASTRECALT());
        periodText.setText(payapprove.getPERIOD());
        expirationdateText.setText(payapprove.getEXPIRATIONALT());
        differenceText.setText(payapprove.getDIFFERENCE());
        vendorText.setText(payapprove.getVENDOR());



    }

    //返回按钮
    @OnClick(R.id.title_back_id)
    void setBackImageView() {
        finish();
    }
    //菜单按钮
    @OnClick(R.id.title_add)
    void setMenuImageView(){
        showPopupwidow(menuImageView);
    }

    private void showPopupwidow(View view) {


    }
}
