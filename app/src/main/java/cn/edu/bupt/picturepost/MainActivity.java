package cn.edu.bupt.picturepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * 程序入口，主要负责加载一些UI控件
 */
public class MainActivity extends Activity {
    private Switch aSwitch ;
    private TextView textView1;
    private Button button;
    private boolean checkFlag = false; //用来标识是那种拍照模式
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = (Switch) findViewById(R.id.switcher);
        textView1 = (TextView) findViewById(R.id.showCheckState);
        button = (Button) findViewById(R.id.btnStartPicture);
        //监听开关按钮的状态
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textView1.setText("自动拍照模式");
                    checkFlag = b;
                }
                else{
                    textView1.setText("手动拍照模式");
                    checkFlag = b;
                }
            }
        });
        //监听开始按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkFlag){
                    Intent auto = new Intent(MainActivity.this,setAutoPicturesActivity.class);
                    startActivity(auto);

                }else{
                    Intent manual = new Intent(MainActivity.this,setManualPicturesActivity.class);
                    startActivity(manual);

                }
            }
        });

    }

}
