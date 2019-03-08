package zbc.com.andfixdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.ztsc.commonutils.logcat.LogUtil;
import com.ztsc.commonutils.toast.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by benchengzhou on 2019/3/7  18:07 .
 * 作者邮箱： mappstore@163.com
 * 功能描述：
 * 类    名： MainActivity
 * 备    注：
 */

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_bug)
    Button btnBug;
    @Bind(R.id.btn_repair)
    Button btnRepair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        loadMethod();
    }

    private void loadMethod() {
//        Demo demo = new Demo("名称", "成功");
        Demo demo=null ;
        if(demo==null){
            ToastUtils.showToastShort("空指针了");
        }
        LogUtil.e(demo.toString());

    }


    public class Demo {
        private String demoName;
        private String demoMsg;

        public Demo(String demoName, String demoMsg) {
            this.demoName = demoName;
            this.demoMsg = demoMsg;
        }

        public String getDemoName() {
            return demoName;
        }

        public void setDemoName(String demoName) {
            this.demoName = demoName;
        }

        public String getDemoMsg() {
            return demoMsg;
        }

        public void setDemoMsg(String demoMsg) {
            this.demoMsg = demoMsg;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "demoName='" + demoName + '\'' +
                    ", demoMsg='" + demoMsg + '\'' +
                    '}';
        }
    }

}
