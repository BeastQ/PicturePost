package cn.edu.bupt.picturepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class upLoadActivity extends Activity {
    private String hname,uname,pwd;
    private int hport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_load);
        Intent intent = getIntent();
        Bundle paramsData = intent.getExtras();
        hname = paramsData.getString("hostname");
        uname = paramsData.getString("username");
        pwd = paramsData.getString("password");
        hport = paramsData.getInt("hostport");
        new uploadThread().start();
    }

    public String setImageName(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String imageName = df.format(calendar.getTime());
        return imageName;
    }

    class uploadThread extends Thread {
        @Override
        public void run() {
            FileInputStream in = null;
            File dir = new File("/mnt/sdcard/DCIM");
            File files[] = dir.listFiles();
            FtpUtils fileTools = new FtpUtils();
            if(dir.isDirectory()) {
                for(int i=0;i<files.length;i++) {
                    try {
                        in = new FileInputStream(files[i]);
                        boolean flag = fileTools.uploadFile(hname, hport, uname, pwd,
                                "/images/",setImageName() + i + ".jpg", in);
                        System.out.println(flag);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

