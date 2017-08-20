package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.COMPSHISTORY;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.view.activity.PoListActivity;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 评分记录
 */
public class CompshistoryListAdapter extends BaseQuickAdapter<COMPSHISTORY> {

    public CompshistoryListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, COMPSHISTORY item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.createdate_text_id, item.getCREATEDATE());
        helper.setText(R.id.createdby_text_id, item.getCREATEDBY());
        helper.setText(R.id.thisscore_text_id, item.getTHISSCORE());
        helper.setText(R.id.cause_text_id, item.getCAUSE());
        helper.setText(R.id.status_text_id, item.getSTATUS());
    }


}
