package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PRLINE;
import hqxh.tzpowerproject.model.WFASSIGNMENT;
import hqxh.tzpowerproject.model.WFTRANSACTION;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 审批流程
 */
public class WftransactionListAdapter extends BaseQuickAdapter<WFASSIGNMENT> {

    public WftransactionListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, WFASSIGNMENT item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.displayname_text_id, item.getASSIGNEE_DISPLAYNAME());
        helper.setText(R.id.transdate_text_id, item.getTRANS_TRANSDATE());
        helper.setText(R.id.node_text_id, item.getSTARTDATE());
        helper.setText(R.id.memo_text_id, item.getTRANS_MEMO());
    }


}
