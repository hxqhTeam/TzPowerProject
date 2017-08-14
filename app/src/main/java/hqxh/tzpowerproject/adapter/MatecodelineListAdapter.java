package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.MATECODE;
import hqxh.tzpowerproject.model.MATECODELINE;
import hqxh.tzpowerproject.model.PRLINE;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 物资编码行
 */
public class MatecodelineListAdapter extends BaseQuickAdapter<MATECODELINE> {

    public MatecodelineListAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }


    @Override
    protected void convert(BaseViewHolder helper, MATECODELINE item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.line_title_id, mContext.getString(R.string.mc_materialinfonum_text));
        helper.setText(R.id.line_text_id, item.getMC_MATERIALINFONUM());
        helper.setText(R.id.itemnum_title_id, mContext.getString(R.string.description_text));
        helper.setText(R.id.itemnum_text_id, item.getMC_MATERIALDESC());
        helper.setText(R.id.description_title_id, mContext.getString(R.string.mc_materialdatatype_text));
        helper.setText(R.id.description_text_id, item.getMC_MATERIALDATATYPE());
    }


}
