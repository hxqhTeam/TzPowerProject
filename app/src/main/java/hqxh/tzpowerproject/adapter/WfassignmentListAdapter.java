package hqxh.tzpowerproject.adapter;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;


import java.util.List;

import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.model.WFASSIGNMENT;
import hqxh.tzpowerproject.view.widght.BaseViewHolder;


/**
 * Created by apple on 15/10/26
 * 收件箱
 */
public class WfassignmentListAdapter extends BaseQuickAdapter<WFASSIGNMENT> {

    private static final String TAG="WfassignmentListAdapter";

    public WfassignmentListAdapter(Context context, int layoutResId, List data) {
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
//        CardView cardView = helper.getView(R.id.card_container);

        Log.e(TAG,"APP="+item.getAPP()+",OWNERTABLE="+item.getOWNERTABLE()+",OWNERID="+item.getOWNERID());
        helper.setText(R.id.desc_text, item.getDESCRIPTION());
    }


}
