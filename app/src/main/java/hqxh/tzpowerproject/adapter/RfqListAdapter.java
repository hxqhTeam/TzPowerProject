package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PR;
import hqxh.tzpowerproject.model.REQUIREPLAN;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 采购申请
 */
public class PRListAdapter extends BaseQuickAdapter<PR> {
    public PRListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }



    @Override
    protected void convert(BaseViewHolder helper, PR item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.num_text_id, item.getPRNUM());
        helper.setText(R.id.item_desc_text, item.getDESCRIPTION());
        helper.setText(R.id.reportdate_text_id, item.getISSUEDATE());
        helper.setText(R.id.persion_text_id, item.getREQUESTEDBYNAME());
    }


}
