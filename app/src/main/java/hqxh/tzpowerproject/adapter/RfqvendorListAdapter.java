package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.PRLINE;
import hqxh.tzpowerproject.model.RFQVENDOR;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 供应商
 */
public class RfqvendorListAdapter extends BaseQuickAdapter<RFQVENDOR> {

    public RfqvendorListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, RFQVENDOR item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.vendor_text_id, item.getVENDOR());
        helper.setText(R.id.contact_text_id, item.getCONTACT());
        helper.setText(R.id.phone_text_id, item.getPHONE());
        helper.setText(R.id.email_text_id, item.getEMAIL());
    }


}
