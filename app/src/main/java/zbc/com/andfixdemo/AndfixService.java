package zbc.com.andfixdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.ztsc.commonutils.Util;
import com.ztsc.commonutils.toast.ToastUtils;

import zbc.com.andfixdemo.application.MApplication;

/**
 * Created by benchengzhou on 2019/3/9  19:31 .
 * 作者邮箱： mappstore@163.com
 * 功能描述： 热更新组件
 * 类    名： AndfixService
 * 备    注：
 * function: 1. 检测apatch文件 2. 下载最新的apatch文件，放在缓存目录 3. 加载下载好的apatch文件
 */
public class AndfixService extends Service {
    private String apatchFileDir;
    private static final String CHECK_FIXURL = "http://192.168.1.1:8080";
    private static final String NAME_APATCH = ".apatch";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        checkPatchUpdata();
    }


    /**
     * 检测是否存在热更新文件
     */
    private void checkPatchUpdata() {
        OkGo.<String>post(CHECK_FIXURL)
                .tag(this)
                .params("appVersionName", Util.getVersion(MApplication.sApplication.getApplicationContext()))
                .params("appVersionCode", Util.getVersionCode(MApplication.sApplication.getApplicationContext()))
                .execute(new StringCallback() {

                             @Override
                             public void onSuccess(Response<String> response) {

                             }

                             @Override
                             public void onError(Response<String> response) {
                                 super.onError(response);
                             }

                             @Override
                             public void onFinish() {
                                 super.onFinish();
                             }

                             @Override
                             public void onStart(Request<String, ? extends Request> request) {
                                 super.onStart(request);
                             }
                         }
                );
    }


    /**
     * 数据和路径初始化
     */
    private void init() {
        apatchFileDir = getExternalCacheDir() + "/patch";
    }


}
