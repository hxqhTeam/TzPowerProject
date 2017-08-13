package hqxh.tzpowerproject.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.adapter.BaseQuickAdapter;
import hqxh.tzpowerproject.adapter.RfqlineListAdapter;
import hqxh.tzpowerproject.adapter.RfqvendorListAdapter;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.api.JsonUtils;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.model.RFQ;
import hqxh.tzpowerproject.model.RFQLINE;
import hqxh.tzpowerproject.model.RFQVENDOR;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;
import hqxh.tzpowerproject.view.widght.SwipeRefreshLayout;


/**
 * 供应商Activity
 */
public class RfqvendorListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {


    private static final String TAG = "RfqvendorListActivity";


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
    private RfqvendorListAdapter rfqvendorlistadapter;
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

    private String title;
    private String rfqnum;
    private String appid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(RfqvendorListActivity.this);
        initData();
        findViewById();
        initView();
    }

    /**
     * 初始化数据
     **/
    private void initData() {
        title = getIntent().getExtras().getString("title");
        rfqnum = getIntent().getExtras().getString("rfqnum");
        appid = getIntent().getExtras().getString("appid");

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
        titleTextView.setText(title);
        search.setVisibility(View.GONE);


        layoutManager = new LinearLayoutManager(RfqvendorListActivity.this);
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
        initAdapter(new ArrayList<RFQVENDOR>());
        getData();

    }


    @Override
    public void onLoad() {
        page++;

        getData();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData();
    }


    /**
     * 获取数据*
     */
    private void getData() {
        String url = HttpManager.getRFQVENDOR(appid, rfqnum, AccountUtils.getPersionId(this), page, 20);

        HttpManager.getDataPagingInfo(RfqvendorListActivity.this, url, new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<RFQVENDOR> item = JsonUtils.parsingRFQVENDOR(results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            initAdapter(new ArrayList<RFQVENDOR>());
                        }
                        if (page > totalPages) {
                            MessageUtils.showMiddleToast(RfqvendorListActivity.this, getString(R.string.have_all_data_text));
                        } else {
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
    private void initAdapter(final List<RFQVENDOR> list) {
        rfqvendorlistadapter = new RfqvendorListAdapter(RfqvendorListActivity.this, R.layout.list_itemrfqvendor, list);
        recyclerView.setAdapter(rfqvendorlistadapter);
        rfqvendorlistadapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<RFQVENDOR> list) {
        rfqvendorlistadapter.addData(list);
    }


}