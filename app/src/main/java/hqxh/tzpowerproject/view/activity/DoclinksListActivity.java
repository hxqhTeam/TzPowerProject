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
import hqxh.tzpowerproject.adapter.Doclinkslistadapter;
import hqxh.tzpowerproject.adapter.PolineListAdapter;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.api.JsonUtils;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.model.DOCLINKS;
import hqxh.tzpowerproject.model.POLINE;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;
import hqxh.tzpowerproject.view.widght.SwipeRefreshLayout;


/**
 * 合同文本Activity
 */
public class DoclinksListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {


    private static final String TAG = "DoclinksListActivity";


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
    private Doclinkslistadapter doclinkslistadapter;
    /**
     * 编辑框*
     */
    @Bind(R.id.search_edit)
    EditText search;
    /**
     * 查询条件*
     */
    private int page = 1;


    private ProgressDialog mProgressDialog;

    private String  title;
    private String  ownertable;
    private String  ownerid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(DoclinksListActivity.this);
        initData();
        findViewById();
        initView();
    }

    /**获取标识**/
    private void initData() {
        title=getIntent().getExtras().getString("title");
        ownertable=getIntent().getExtras().getString("ownertable");
        ownerid=getIntent().getExtras().getString("ownerid");
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

        layoutManager = new LinearLayoutManager(DoclinksListActivity.this);
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
        initAdapter(new ArrayList<DOCLINKS>());
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
        String url=HttpManager.getDOCLINKS(ownertable,ownerid, AccountUtils.getPersionId(this),page, 20);
        HttpManager.getDataPagingInfo(DoclinksListActivity.this, url, new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<DOCLINKS> item = JsonUtils.parsingDOCLINKS(results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            initAdapter(new ArrayList<DOCLINKS>());
                        }
                        if(page>totalPages){
                            MessageUtils.showMiddleToast(DoclinksListActivity.this,getString(R.string.have_all_data_text));
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
    private void initAdapter(final List<DOCLINKS> list) {
        doclinkslistadapter = new Doclinkslistadapter(DoclinksListActivity.this, R.layout.list_itemdoclinks, list);
        recyclerView.setAdapter(doclinkslistadapter);
        doclinkslistadapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<DOCLINKS> list) {
        doclinkslistadapter.addData(list);
    }


}
