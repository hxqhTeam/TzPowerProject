package hqxh.tzpowerproject.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.adapter.BaseQuickAdapter;
import hqxh.tzpowerproject.adapter.PayapproveListAdapter;
import hqxh.tzpowerproject.adapter.PoListAdapter;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.api.JsonUtils;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.model.PAYAPPROVE;
import hqxh.tzpowerproject.model.PO;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;
import hqxh.tzpowerproject.view.widght.SwipeRefreshLayout;


/**
 * 物资合同付款审批表Activity
 */
public class PayapproveListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {


    private static final String TAG = "PayapproveListActivity";
    public static final int PAYAPPROVE=1000; //物资合同付款
    public static final int GCPAYAPP=1001; //物资合同付款

    /**
     * 返回按钮
     */
    @Bind(R.id.title_back_id)
    ImageView backImageView;
    /**
     * 标题
     */
    @Bind(R.id.title_name)
    TextView titleTextView;


    LinearLayoutManager layoutManager;


    /**
     * RecyclerView*
     */
    @Bind(R.id.recyclerView_id)
    RecyclerView recyclerView;
    /**
     * 暂无数据*
     */
    @Bind(R.id.have_not_data_id)
    LinearLayout nodatalayout;
    /**
     * 界面刷新*
     */
    @Bind(R.id.swipe_container)
    SwipeRefreshLayout refresh_layout = null;
    /**
     * 适配器*
     */
    private PayapproveListAdapter payapproveListAdapter;
    /**
     * 编辑框*
     */
    @Bind(R.id.search_edit)
    EditText search;
    /**
     * 查询条件*
     */
    private String searchText = "";
    private int page = 1;


    private ProgressDialog mProgressDialog;

    private int mark;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(PayapproveListActivity.this);
        initData();
        findViewById();
        initView();
    }

    /**初始化界面数据**/
    private void initData() {
        mark=getIntent().getExtras().getInt("mark");
    }


    /**
     * 初始化界面组件*
     */

    @Override
    protected void findViewById() {
    }


    /**
     * 设置事件监听*
     */
    protected void initView() {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(mark==PAYAPPROVE){
            titleTextView.setText(R.string.wzcgfk_text);
        }else if(mark==GCPAYAPP){
            titleTextView.setText(R.string.gcfk_text);
        }


        setSearchEdit();

        layoutManager = new LinearLayoutManager(PayapproveListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refresh_layout.setColor(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refresh_layout.setRefreshing(true);

        refresh_layout.setOnRefreshListener(this);
        refresh_layout.setOnLoadListener(this);
        initAdapter(new ArrayList<PAYAPPROVE>());
        getData(searchText);

    }


    @Override
    public void onLoad() {
        page++;

        getData(searchText);
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData(searchText);
    }


    private void setSearchEdit() {
        SpannableString msp = new SpannableString("XX搜索");
        Drawable drawable = getResources().getDrawable(R.drawable.ic_search);
        msp.setSpan(new ImageSpan(drawable), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        search.setHint(msp);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) search.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    searchText = search.getText().toString();
                    payapproveListAdapter.removeAll(payapproveListAdapter.getData());
                    nodatalayout.setVisibility(View.GONE);
                    refresh_layout.setRefreshing(true);
                    page = 1;
                    getData(searchText);
                    return true;
                }
                return false;
            }
        });
    }


    /**
     * 获取数据*
     */
    private void getData(String search) {
        String url=null;
        if(mark==PAYAPPROVE){
            url=HttpManager.getPAYAPPROVE(search, AccountUtils.getPersionId(this),page, 20);
        }else if(mark==GCPAYAPP){
            url=HttpManager.getGCPAYAPP(search, AccountUtils.getPersionId(this),page, 20);
        }
        HttpManager.getDataPagingInfo(PayapproveListActivity.this, url, new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<PAYAPPROVE> item = JsonUtils.parsingPAYAPPROVE(results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            initAdapter(new ArrayList<PAYAPPROVE>());
                        }
                        if(page>totalPages){
                            MessageUtils.showMiddleToast(PayapproveListActivity.this,getString(R.string.have_all_data_text));
                        }else{
                            addData(item);
                        }

                    }
                }
            }

            @Override
            public void onFailure(String error) {
                refresh_layout.setRefreshing(false);
                nodatalayout.setVisibility(View.VISIBLE);
            }
        });

    }


    /**
     * 获取数据*
     */
    private void initAdapter(final List<PAYAPPROVE> list) {
        payapproveListAdapter = new PayapproveListAdapter(PayapproveListActivity.this, R.layout.list_item_1, list);
        recyclerView.setAdapter(payapproveListAdapter);
        payapproveListAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(N_grainjcListActivity.this, N_grainjcDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("worktype", worktype);
//                bundle.putSerializable("n_grainjc", items.get(position));
//                intent.putExtras(bundle);
//                startActivityForResult(intent, 0);
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<PAYAPPROVE> list) {
        payapproveListAdapter.addData(list);
    }


}
