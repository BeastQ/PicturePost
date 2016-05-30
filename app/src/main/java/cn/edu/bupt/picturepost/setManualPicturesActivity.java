package cn.edu.bupt.picturepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by BeastQ on 2016/5/19.
 * 此Activity是手动拍照的实现
 */
public class setManualPicturesActivity extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局页面
        setContentView(R.layout.activity_setmanual);
        button = (Button) findViewById(R.id.btnStartManualPicture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setManualPicturesActivity.this,ManualActivity.class);
                startActivity(intent);
            }
        });
    }
}
