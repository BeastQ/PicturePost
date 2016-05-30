package cn.edu.bupt.picturepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by BeastQ on 2016/5/19.
 * 此Activity是自动拍照的实现
 */
public class setAutoPicturesActivity extends Activity {
    private Button button;
    private EditText text,text1;
    String tm,tm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvitity_setauto);
        button = (Button) findViewById(R.id.btnStartAutoPicture);
        text = (EditText) findViewById(R.id.times);
        text1 = (EditText) findViewById(R.id.EveryTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tm = text.getText().toString();
                tm2 = text1.getText().toString();
                //Toast.makeText(setAutoPicturesActivity.this,tm,Toast.LENGTH_SHORT).show();
                final int tm1 = Integer.parseInt(tm);
                final int tm3 = Integer.parseInt(tm2);
                Intent intent = new Intent(setAutoPicturesActivity.this,AutoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("time",tm1);
                bundle.putInt("everytime",tm3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
