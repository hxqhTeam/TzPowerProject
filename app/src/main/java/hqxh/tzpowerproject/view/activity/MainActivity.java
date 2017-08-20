package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hqxh.tzpowerproject.AppManager;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.adapter.BaseQuickAdapter;
import hqxh.tzpowerproject.adapter.MyGridViewAdpter;
import hqxh.tzpowerproject.adapter.MyViewPagerAdapter;
import hqxh.tzpowerproject.adapter.WfassignmentListAdapter;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.api.JsonUtils;
import hqxh.tzpowerproject.bean.ProdctBean;
import hqxh.tzpowerproject.bean.Results;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.model.WFASSIGNMENT;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;
import hqxh.tzpowerproject.view.widght.SwipeRefreshLayout;

/**
 * MainActivity
 */
public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {


    private ImageView memberImg;
    private ViewPager viewPager;
    private LinearLayout group;//圆点指示器
    private ImageView[] ivPoints;//小圆点图片的集合
    private int totalPage; //总的页数
    private int mPageSize = 8; //每页显示的最大的数量
    private List<ProdctBean> listDatas;//总的数据源
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中
    private int currentPage;//当前页
    private List<String> list = new ArrayList<String>();//appid集合
    private String[] proName = null;

    LinearLayoutManager layoutManager;
    /**
     * RecyclerView*
     */
    public RecyclerView recyclerView;
    /**
     * 暂无数据*
     */
    private LinearLayout nodatalayout;
    /**
     * 界面刷新*
     */
    private SwipeRefreshLayout refresh_layout = null;
    /**
     * 适配器*
     */
    private WfassignmentListAdapter workorderListAdapter;
    private int page = 1;


    ArrayList<WFASSIGNMENT> items = new ArrayList<WFASSIGNMENT>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIntentData();
        findViewById();
        initView();
    }

    private void getIntentData() {
        proName = getResources().getStringArray(R.array.main_text);
        list = JsonUtils.getApp(AccountUtils.getmyapps(MainActivity.this));
    }

    @Override
    protected void findViewById() {
        memberImg = (ImageView) findViewById(R.id.img_member);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        group = (LinearLayout) findViewById(R.id.points);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);
        refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        nodatalayout = (LinearLayout) findViewById(R.id.have_not_data_id);
    }

    @Override
    protected void initView() {
        layoutManager = new LinearLayoutManager(MainActivity.this);
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

        refresh_layout.setRefreshing(true);
        initAdapter(new ArrayList<WFASSIGNMENT>());
        getData();
        listDatas = new ArrayList<ProdctBean>();
        if (list != null && list.size() != 0) {
            if (list.contains(Constants.RP_APPID)) {//需款计划
                listDatas.add(new ProdctBean(proName[0], Constants.RP_APPID, R.drawable.ic_xkji));
            }
            if (list.contains(Constants.PR_NAME)) {//采购申请
                listDatas.add(new ProdctBean(proName[1], Constants.PR_NAME, R.drawable.ic_cgsq));
            }
            if (list.contains(Constants.RFQ_APPID)) {//询价单
                listDatas.add(new ProdctBean(proName[2], Constants.RFQ_APPID, R.drawable.ic_xjd));
            }
            if (list.contains(Constants.PO_APPID)) {//采购单
                listDatas.add(new ProdctBean(proName[3], Constants.PO_APPID, R.drawable.ic_cgd));
            }
            if (list.contains(Constants.PAYAPPROVE_APPID)) {//物资采购付款
                listDatas.add(new ProdctBean(proName[4], Constants.PAYAPPROVE_APPID, R.drawable.ic_wzcgfk));
            }
            if (list.contains(Constants.MATECODE_APPID)) {//物资编码
                listDatas.add(new ProdctBean(proName[5], Constants.MATECODE_APPID, R.drawable.ic_wzbm));
            }
            if (list.contains(Constants.PRSER_APPID)) {//工程采购申请
                listDatas.add(new ProdctBean(proName[6], Constants.PRSER_APPID, R.drawable.ic_gccgsq));
            }
            if (list.contains(Constants.RFQSER_APPID)) {//工程询价单
                listDatas.add(new ProdctBean(proName[7], Constants.RFQSER_APPID, R.drawable.ic_gcxjd));
            }
            if (list.contains(Constants.POSER_APPID)) {//工程服务采购单
                listDatas.add(new ProdctBean(proName[8], Constants.POSER_APPID, R.drawable.ic_gcfwcgd));
            }
            if (list.contains(Constants.COMPANY_APPID)) {//供应商
                listDatas.add(new ProdctBean(proName[9], Constants.COMPANY_APPID, R.drawable.ic_gys));
            }
            if (list.contains(Constants.SERREC_APPID)) {//工程验收
                listDatas.add(new ProdctBean(proName[10], Constants.SERREC_APPID, R.drawable.ic_gcys));
            }
            if (list.contains(Constants.GCPAYAPP_APPID)) {//工程付款
                listDatas.add(new ProdctBean(proName[11], Constants.GCPAYAPP_APPID, R.drawable.ic_gcfk));
            }


        }
        //总的页数向上取整
        totalPage = (int) Math.ceil(listDatas.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<View>();
        for (int i = 0; i < totalPage; i++) {
            //每个页面都是inflate出一个新实例
            final GridView gridView = (GridView) View.inflate(this, R.layout.item_gridview, null);
            gridView.setAdapter(new MyGridViewAdpter(this, listDatas, i, mPageSize));
            //添加item点击监听
            gridView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int position, long arg3) {
                    Log.e("TAG", "position=" + position);
                    // TODO Auto-generated method stub
                    Object obj = gridView.getItemAtPosition(position);
                    if (obj != null && obj instanceof ProdctBean) {
                        ProdctBean prodctBean = (ProdctBean) obj;
                        Intent intent;
                        Log.e("TAG", "appid=" + prodctBean.getAppid());
                        switch (prodctBean.getAppid()) {

                            case Constants.RP_APPID: //需款计划
                                intent = new Intent(MainActivity.this, XqjhListActivity.class);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.PR_APPID: //采购申请
                                intent = new Intent(MainActivity.this, PrListActivity.class);
                                intent.putExtra("mark", PrListActivity.PR_CG);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.RFQ_APPID: //询价单
                                intent = new Intent(MainActivity.this, RfqListActivity.class);
                                intent.putExtra("mark", RfqListActivity.XJD_CG);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.PO_APPID: //采购单
                                intent = new Intent(MainActivity.this, PoListActivity.class);
                                intent.putExtra("mark", PoListActivity.PO_CG);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.PAYAPPROVE_APPID: //物资采购付款
                                intent = new Intent(MainActivity.this, PayapproveListActivity.class);
                                intent.putExtra("mark", PayapproveListActivity.PAYAPPROVE);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.MATECODE_APPID: //物资编码
                                intent = new Intent(MainActivity.this, MatecodeListActivity.class);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.PRSER_APPID: //工程采购
                                intent = new Intent(MainActivity.this, PrListActivity.class);
                                intent.putExtra("mark", PrListActivity.PR_GC);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.RFQSER_APPID: //工程询价单
                                intent = new Intent(MainActivity.this, RfqListActivity.class);
                                intent.putExtra("mark", RfqListActivity.XJD_GC);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.POSER_APPID: //工程服务采购单
                                intent = new Intent(MainActivity.this, PoListActivity.class);
                                intent.putExtra("mark", PoListActivity.PO_GC);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.COMPANY_APPID: //供应商
                                intent = new Intent(MainActivity.this, CompaniesListActivity.class);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.SERREC_APPID: //工程验收
                                intent = new Intent(MainActivity.this, PoListActivity.class);
                                intent.putExtra("mark", PoListActivity.PO_GCYS);
                                startActivityForResult(intent, 0);
                                break;
                            case Constants.GCPAYAPP_APPID: //工程付款
                                intent = new Intent(MainActivity.this, PayapproveListActivity.class);
                                intent.putExtra("mark", PayapproveListActivity.GCPAYAPP);
                                startActivityForResult(intent, 0);
                                break;

                        }
                    }
                }
            });
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        //设置ViewPager适配器
        viewPager.setAdapter(new MyViewPagerAdapter(viewPagerList));

        if (totalPage == 1) {
            group.setVisibility(View.GONE);
        }
        //添加小圆点
        ivPoints = new ImageView[totalPage];
        for (int i = 0; i < totalPage; i++) {
            //循坏加入点点图片组
            ivPoints[i] = new ImageView(this);
            if (i == 0) {
                ivPoints[i].setImageResource(R.drawable.page_focuese);
            } else {
                ivPoints[i].setImageResource(R.drawable.page_unfocused);
            }
            ivPoints[i].setPadding(8, 8, 8, 8);
            group.addView(ivPoints[i]);
        }
        //设置ViewPager的滑动监听，主要是设置点点的背景颜色的改变
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                //currentPage = position;
                for (int i = 0; i < totalPage; i++) {
                    if (i == position) {
                        ivPoints[i].setImageResource(R.drawable.page_focuese);
                    } else {
                        ivPoints[i].setImageResource(R.drawable.page_unfocused);
                    }
                }
            }
        });
    }

    /**
     * 获取数据*
     */
    private void getData() {
        HttpManager.getDataPagingInfo(MainActivity.this, HttpManager.getWFASSIGNMENT(AccountUtils.getPersionId(MainActivity.this), page, 20), new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
//                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<WFASSIGNMENT> item = JsonUtils.parsingWFASSIGNMENT(results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            items = new ArrayList<WFASSIGNMENT>();
                            initAdapter(items);
                        }
                        for (int i = 0; i < item.size(); i++) {
                            items.add(item.get(i));
                        }
                        addData(item);
                    }
                    nodatalayout.setVisibility(View.GONE);

                    initAdapter(items);
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
    private void initAdapter(final List<WFASSIGNMENT> list) {
        nodatalayout.setVisibility(View.GONE);
        workorderListAdapter = new WfassignmentListAdapter(MainActivity.this, R.layout.list_item_wfassignment, list);
        recyclerView.setAdapter(workorderListAdapter);
        workorderListAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = null;

                WFASSIGNMENT wfassignment = (WFASSIGNMENT) workorderListAdapter.getData().get(position);
                String app = wfassignment.getAPP();

                Log.e("app","app"+app);
                if (app.equals(Constants.RP_APPID)) { //需款计划
                    intent = new Intent(MainActivity.this, RequireplandetailsActivity.class);
                    intent.putExtra("app", app);
                    intent.putExtra("ownertable", wfassignment.getOWNERTABLE());
                    intent.putExtra("ownerid", wfassignment.getOWNERID());
                    intent.putExtra("mark", Constants.TASK_CODE);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("requireplan", null);
                    intent.putExtras(bundle);

                    startActivityForResult(intent,0);

                } else if (app == Constants.PR_APPID) {//采购申请

                } else if (app == Constants.RFQ_APPID) {//询价单

                } else if (app.equals(Constants.PO_APPID)) {//采购单
                    intent = new Intent(MainActivity.this, PodetailsActivity.class);
                    intent.putExtra("app", app);
                    intent.putExtra("ownertable", wfassignment.getOWNERTABLE());
                    intent.putExtra("ownerid", wfassignment.getOWNERID());
                    intent.putExtra("mark", Constants.TASK_CODE);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("po", null);
                    intent.putExtras(bundle);


                    startActivityForResult(intent, 0);

                } else if (app == Constants.PAYAPPROVE_APPID) {//物资采购申请

                } else if (app == Constants.MATECODE_APPID) {//物资编码

                } else if (app == Constants.PRSER_APPID) {//工程采购

                } else if (app == Constants.RFQSER_APPID) {//工程询价单

                } else if (app == Constants.POSER_APPID) {//工程服务采购单

                } else if (app == Constants.COMPANY_APPID) {//供应商

                } else if (app == Constants.SERREC_APPID) {//工程验收

                } else if (app == Constants.GCPAYAPP_APPID) {//工程付款
                    intent = new Intent(MainActivity.this, PayapprovedetailsActivity.class);
                    intent.putExtra("app", app);
                    intent.putExtra("ownertable", wfassignment.getOWNERTABLE());
                    intent.putExtra("ownerid", wfassignment.getOWNERID());
                    intent.putExtra("mark", Constants.TASK_CODE);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("payapprove", null);
                    intent.putExtras(bundle);

                    startActivityForResult(intent,0);

                } else {
                    MessageUtils.showMiddleToast(MainActivity.this, "暂无法审批该功能模块");
                }

//                Intent intent = new Intent(MainActivity.this, WorkorderDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("workorder", (Serializable) workorderListAdapter.getData().get(position));
//                bundle.putInt("position", position);
//                intent.putExtras(bundle);
//                startActivityForResult(intent, 0);
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<WFASSIGNMENT> list) {
        workorderListAdapter.addData(list);
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

    private long exitTime = 0;

    @Override
    public void onBackPressed() {


        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        } else {
            AppManager.AppExit(MainActivity.this);
        }
    }

}
