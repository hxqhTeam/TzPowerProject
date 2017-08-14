package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.DOCLINKS;
import hqxh.tzpowerproject.model.PR;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 附件
 */
public class Doclinkslistadapter extends BaseQuickAdapter<DOCLINKS> {
    public Doclinkslistadapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }



    @Override
    protected void convert(BaseViewHolder helper, DOCLINKS item) {
        CardView cardView = helper.getView(R.id.card_container);
        helper.setText(R.id.document_text_id, item.getDOCUMENT());
        helper.setText(R.id.wdmc_text_id, item.getDOCINFO_DESCRIPTION());
        helper.setText(R.id.docinfo_urlname_text_id, item.getPERSON_DISPLAYNAME());
        helper.setText(R.id.createdate_text_id, item.getCREATEDATE());
    }


}
