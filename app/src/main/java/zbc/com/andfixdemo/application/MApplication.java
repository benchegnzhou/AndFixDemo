package zbc.com.andfixdemo.application;

import android.app.Application;

import com.ztsc.commonutils.CommonUtil;
import com.ztsc.commonutils.utilconfig.Config;

import zbc.com.andfixdemo.andfix.AndfixPatchManger;

/**
 * Created by benchengzhou on 2019/3/7  18:44 .
 * 作者邮箱： mappstore@163.com
 * 功能描述：
 * 类    名： MApplication
 * 备    注：
 */

public class MApplication extends Application {
    public static MApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;         //获取全局上下文
        CommonUtil.getInstance().init(this, new Config()
                .setLogOpen(true)
                .setLogTag("ZBC_ANDFIX")
                .setToastOpen(true));
        initAndfix();
    }

    private void initAndfix() {
        AndfixPatchManger.getInstance().initPath(sApplication.getApplicationContext());
    }
}
