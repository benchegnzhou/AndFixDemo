package zbc.com.andfixdemo.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.ztsc.commonutils.Util;
import com.ztsc.commonutils.logcat.LogUtil;
import java.io.IOException;

/**
 * Created by benchengzhou on 2019/3/8  14:40 .
 * 作者邮箱： mappstore@163.com
 * 功能描述： 热修复Andfix管理类
 * 类    名： AndfixPatchManger
 * 备    注：
 */
public class AndfixPatchManger {

    private PatchManager patchManager;

    private AndfixPatchManger() {
    }


    public static AndfixPatchManger getInstance() {
        return getInstance2.andfixPatchManger;
    }

    static class getInstance2 {
        private static AndfixPatchManger andfixPatchManger = new AndfixPatchManger();
    }


    /**
     * 初始化Andfix
     *
     * @param context  上线文，一般请使用AppApplication.context
     */
    public void initPath(Context context) {
        if (context == null) {
            LogUtil.e("AndfixPatchManger uninitialized ，please init first");
            return;
        }
        patchManager = new PatchManager(context);
        //设置当前版本号，内部通过sp文件记录当前版本有没有更新过指定的patch文件
        patchManager.init(Util.getVersion(context));
        //You should load patch as early as possible, generally, in the initialization phase of your application(such as Application.onCreate())
        patchManager.loadPatch();
    }


    /**
     * 当下载了一个新的补丁文件后，调用addPatch方法修复结果将立即生效
     *
     * @param patchPath   新下载的patch补丁文件的路径
     */
    public void addPatch(String patchPath) {
        try {
            if(patchManager!=null){
                patchManager.addPatch(patchPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
