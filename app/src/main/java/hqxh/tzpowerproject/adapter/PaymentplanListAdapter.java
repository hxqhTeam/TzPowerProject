package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.PAYMENTPLAN;
import hqxh.tzpowerproject.model.POLINE;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 付款计划
 */
public class PaymentplanListAdapter extends BaseQuickAdapter<PAYMENTPLAN> {

    public PaymentplanListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, PAYMENTPLAN item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.paytype_text_id, item.getPAYTYPE());
        helper.setText(R.id.payratio_text_id, item.getPAYRATIO());
        helper.setText(R.id.payamount_text_id, item.getPAYAMOUNT());
    }


}
