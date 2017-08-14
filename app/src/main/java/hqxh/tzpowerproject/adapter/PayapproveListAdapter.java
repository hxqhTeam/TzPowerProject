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
 * 物资合同付款审批表/付款执行情况
 */
public class PayapproveListAdapter extends BaseQuickAdapter<PAYAPPROVE> {
    private int mark;
    public PayapproveListAdapter(Context context, int layoutResId, List data,int mark) {
        super(context, layoutResId, data);
        this.mark=mark;
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
        if(mark==0) {
            helper.setText(R.id.num_text_id, item.getPAYNUM());
            helper.setText(R.id.item_desc_text, item.getDESCRIPTION());
            helper.setText(R.id.reportdate_text_id, item.getSTATUS());
            helper.setText(R.id.persion_text_id, item.getCREATEBY());
        }else if(mark==1){
            helper.setText(R.id.dh_text_id, item.getPAYNUM());
            helper.setText(R.id.fk_description_text_id, item.getDESCRIPTION());
            helper.setText(R.id.status_text_id, item.getSTATUS());
        }
    }


}
