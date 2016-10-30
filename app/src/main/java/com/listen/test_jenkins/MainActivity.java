package com.listen.test_jenkins;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvChannel;



    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvChannel = ((TextView) findViewById(R.id.tv_channel));

        ActivityInfo info = null;
        try {
            info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            mTvChannel.setText(TAG + "，" + info.metaData.getString("CHANNEL") + "，master");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
