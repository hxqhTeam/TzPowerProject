package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 物资合同付款审批表
 */
public class PayapproveListAdapter extends BaseQuickAdapter<PAYAPPROVE> {
    public PayapproveListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }



    @Override
    protected void convert(BaseViewHolder helper, PAYAPPROVE item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.num_text_id, item.getPAYNUM());
        helper.setText(R.id.item_desc_text, item.getDESCRIPTION());
        helper.setText(R.id.reportdate_text_id, item.getSTATUS());
        helper.setText(R.id.persion_text_id, item.getCREATEBY());
    }


}
