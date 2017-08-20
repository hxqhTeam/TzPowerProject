package hqxh.tzpowerproject.view.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.pgyersdk.update.PgyUpdateManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import hqxh.tzpowerproject.AppManager;
import hqxh.tzpowerproject.R;
import hqxh.tzpowerproject.api.HttpManager;
import hqxh.tzpowerproject.api.HttpRequestHandler;
import hqxh.tzpowerproject.constants.Constants;
import hqxh.tzpowerproject.dialog.FlippingLoadingDialog;
import hqxh.tzpowerproject.until.AccountUtils;
import hqxh.tzpowerproject.until.MessageUtils;


public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    @Bind(R.id.login_username_edit)
    EditText mUsername;
    @Bind(R.id.login_password_edit)
    EditText mPassword;
    @Bind(R.id.btn_login)
    Button loginBtn;
    @Bind(R.id.checkBox)
    CheckBox checkBox; //记住密码


    private boolean isRemember; //是否记住密码

    String imei; //imei

    private long exitTime = 0;

    protected FlippingLoadingDialog mLoadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        PgyUpdateManager.register(LoginActivity.this, getString(R.string.file_provider));

        imei = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE))
                .getDeviceId();

        findViewById();
        initView();


    }

    @Override
    protected void findViewById() {


        boolean isChecked = AccountUtils.getIsChecked(LoginActivity.this);
        if (isChecked) {
            checkBox.setChecked(isChecked);
            mUsername.setText(AccountUtils.getUserName(LoginActivity.this));
            mPassword.setText(AccountUtils.getUserPassword(LoginActivity.this));
        }


    }


    //记住密码
    @OnCheckedChanged(R.id.checkBox)
    void onChecked(boolean isChecked) {
        isRemember = isChecked;
    }


    @OnClick(R.id.btn_login)
    void setLoginBtn() {
        if (mUsername.getText().length() == 0) {
            mUsername.setError(getString(R.string.login_error_empty_user));
            mUsername.requestFocus();
        } else if (mPassword.getText().length() == 0) {
            mPassword.setError(getString(R.string.login_error_empty_passwd));
            mPassword.requestFocus();
        } else {
            login();
        }
    }


    @Override
    protected void initView() {

        if (AccountUtils.getIpAddress(LoginActivity.this) == null
                || AccountUtils.getIpAddress(LoginActivity.this).equals("")) {//初始化地址
            AccountUtils.setIpAddress(LoginActivity.this, Constants.HTTP_API_IP);
        }

    }


    /**
     * 跳转至主界面*
     */
    private void startIntent() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivityForResult(intent,0);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }



    /**
     * 登陆*
     */
    private void login() {
        getLoadingDialog("正在登陆...").show();

        HttpManager.loginWithUsername(LoginActivity.this,
                mUsername.getText().toString(),
                mPassword.getText().toString(), imei,
                new HttpRequestHandler<String>() {
                    @Override
                    public void onSuccess(String data) {

                        getLoadingDialog("正在登陆...").dismiss();
                        if (data != null) {
                            getBaseApplication().setUsername(mUsername.getText().toString());
                            if (isRemember) {
                                AccountUtils.setChecked(LoginActivity.this, isRemember);
                                //记住密码
                                AccountUtils.setUserNameAndPassWord(LoginActivity.this, mUsername.getText().toString(), mPassword.getText().toString());
                            }
                            try {//保存登录返回信息
                                JSONObject object = new JSONObject(data);
                                AccountUtils.setLoginDetails(LoginActivity.this, object.getString("DEFSITE"), object.getString("DISPLAYNAME"),
                                        object.getString("EMAILADDRESS"), object.getString("MYAPPS"), object.getString("PERSONID"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            MessageUtils.showMiddleToast(LoginActivity.this, getString(R.string.login_successful_hint));
                            startIntent();
                        }
                    }

                    @Override
                    public void onSuccess(String data, int totalPages, int currentPage) {
                        if (data != null) {
                            MessageUtils.showMiddleToast(LoginActivity.this, getString(R.string.login_successful_hint));

                        }
                    }

                    @Override
                    public void onFailure(String error) {
                        MessageUtils.showErrorMessage(LoginActivity.this, error);
                        getLoadingDialog("正在登陆...").dismiss();
                    }
                });
    }


    @Override
    public void onBackPressed() {


        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        } else {
            AppManager.AppExit(LoginActivity.this);
        }
    }

    private FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(this, msg);
        return mLoadingDialog;
    }



}
