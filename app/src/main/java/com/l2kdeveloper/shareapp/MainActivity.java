package com.l2kdeveloper.shareapp;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInfo applicationInfo=getApplicationContext().getApplicationInfo();
                String ak_path=applicationInfo.sourceDir;
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("application/vmd.android.package-archive");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(ak_path)));
                startActivity(Intent.createChooser(intent,"Share App Using"));
            }
        });
    }
}
