package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.COMPANIES;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 供应商
 */
public class CompaniesListAdapter extends BaseQuickAdapter<COMPANIES> {
    public CompaniesListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }



    @Override
    protected void convert(BaseViewHolder helper, COMPANIES item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.num_text_id, item.getCOMPANY());
        helper.setText(R.id.item_desc_text, item.getNAME());
        helper.setText(R.id.reportdate_text_id, item.getSTATUS());
        helper.setText(R.id.persion_text_id, "类型:"+item.getPRODUCTTYPE());
    }


}
