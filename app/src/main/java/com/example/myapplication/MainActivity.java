package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.activityfragemnttest.TestDataActivity;
import com.example.myapplication.databinding.NewMainLayoutBinding;
import com.example.myapplication.hook.HookHelper;
import com.example.myapplication.hook.NotificationUtils;
import com.example.myapplication.kotin.SecondActivity;
import com.example.myapplication.kotin.StudentKotlin;
import com.example.myapplication.kotin.Teacher2;
import com.example.myapplication.kotin.TestEntity;
import com.example.myapplication.kotin.TestStudentLombox;
import com.example.myapplication.template.IntentDataIml;
import com.example.myapplication.testdata.FirstActivity;
import com.orhanobut.logger.Logger;

import io.flutter.facade.Flutter;
import lombok.val;

public class MainActivity extends AppCompatActivity {


    private String name;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        测试使用layout的分包整理策略，涉及到build.gradle文件中sourceset节点的修改配置
//        setContentView(R.layout.new_main_layout);
        NewMainLayoutBinding mainLayoutBinding =
                DataBindingUtil.setContentView(this, R.layout.new_main_layout);
        NewMainLayoutBinding newMainLayoutBinding =
                DataBindingUtil.findBinding(getWindow().getDecorView().findViewById(R.id.tv_main));
        if (newMainLayoutBinding != null) {
            newMainLayoutBinding.tvMain.setText("databinding测试");
        }

        int a = 1;
        int b = 2;
        int c = 1 / 2;
        Log.d("xujixiao", c + "-----java的值");
        /*使用hook技术hook onclicklistener 方法添加一些额外的操作*/
        View.OnClickListener testClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LoginActivity.start(MainActivity.this);
//                val intentData = new IntentDataIml();
//                SecondActivity.Companion.start(MainActivity.this, intentData);
//                FirstActivity.start(MainActivity.this);

                TestDataActivity.Companion.start(MainActivity.this);
            }
        };
        findViewById(R.id.tv_main).setOnClickListener(testClick);
        HookHelper.hook(this, findViewById(R.id.tv_main));

        NotificationUtils.sendNotification(this);

        TestEntity testEntity = new TestEntity();
        testEntity.setName("xujxiiao");
        testEntity.setSubName("xujixiao");


        TestStudentLombox studentLombox = new TestStudentLombox();
        studentLombox.setName("xujxiiao").setAge("xujixiao");


        StudentKotlin studentKotlin = new StudentKotlin("xujixiao", 0);
//        studentKotlin.setAge2();
        showName(studentKotlin);

        Teacher2 teacher2 = new Teacher2();
//        teacher2.showName(null);

        addFlutterFragment();

        FrameLayout frameLayout = findViewById(R.id.fl_contain);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);
            layoutParams.setMargins(50 * i, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.mipmap.ic_launcher);
            frameLayout.addView(imageView);
        }

    }

    private void addFlutterFragment() {
        LinearLayout linearLayout = findViewById(R.id.ll_flutter_fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.ll_flutter_fragment, Flutter.createFragment("这个是flutter的fragment的页面")).commit();
    }

    /**
     * 初始化腾讯的mmkv框架的方式。
     */
    private void initMMKV() {
//        String rootDir = MMKV.initialize(this);
//        Log.d("xujixiao", rootDir);
    }

    /**
     * 测试对于泛型对象的输出
     */
    private static <T> void showName(T t) {
        Logger.d(t);
    }
}
