package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.POLINE;
import hqxh.tzpowerproject.model.PRLINE;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 采购单行
 */
public class PolineListAdapter extends BaseQuickAdapter<POLINE> {

    public PolineListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, POLINE item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.line_text_id, item.getPOLINENUM());
        helper.setText(R.id.itemnum_text_id, item.getITEMNUM());
        helper.setText(R.id.description_text_id, item.getDESCRIPTION());
    }


}
