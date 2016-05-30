package cn.edu.bupt.picturepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FtpLoginActivity extends Activity {
    private EditText hostname,username,password,hostport;
    private String hname,uname,pwd,inStream;
    private int hport;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftp1);
        hostname = (EditText) findViewById(R.id.txt_host_name);
        username = (EditText) findViewById(R.id.txt_user_name);
        password = (EditText) findViewById(R.id.txt_password);
        hostport = (EditText) findViewById(R.id.txt_host_port);
        button = (Button) findViewById(R.id.button_login);
        /**
         * 以下为获取输入框中的内容
         */
        //添加按钮监听事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hname = hostname.getText().toString().trim();
                uname = username.getText().toString().trim();
                pwd = password.getText().toString().trim();
                hport = Integer.parseInt(hostport.getText().toString());
                Intent i = new Intent(FtpLoginActivity.this,upLoadActivity.class);
                Bundle data = new Bundle();
                data.putString("hostname",hname);
                data.putString("username",uname);
                data.putString("password",pwd);
                data.putInt("hostport",hport);
                i.putExtras(data);
                startActivity(i);
            }
        });
    }
}
