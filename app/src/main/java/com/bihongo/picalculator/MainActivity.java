package com.bihongo.picalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText totalPI, totalTriangle, totalRectangle;

    private TextView viewResult, viewComment;

    private Button result, resetValue;

    private ImageView imageView, facebook, whatsapp;

    double a, b, c , myResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPI = (EditText)findViewById(R.id.t_pi);
        totalTriangle = (EditText)findViewById(R.id.t_tri);
        totalRectangle = (EditText)findViewById(R.id.t_rec);

        result = (Button)findViewById(R.id.result);
        resetValue = (Button)findViewById(R.id.reset);
        viewResult = (TextView) findViewById(R.id.view_result);
        viewComment = (TextView) findViewById(R.id.view_comment);

        imageView = (ImageView) findViewById(R.id.view_image);

        facebook = (ImageView) findViewById(R.id.fb);
        whatsapp = (ImageView) findViewById(R.id.wt);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/learnwitharifurrahman"));
                startActivity(intent);
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://wa.me/8801684516151"));
                startActivity(intent);
            }
        });


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(totalPI.getText().toString())){
                    Toast.makeText(MainActivity.this, "মোট PI এর সংখ্যা লিখুন...",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(totalTriangle.getText().toString())){
                    Toast.makeText(MainActivity.this, "মোট ত্রিভুজের সংখ্যা লিখুন...",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(totalRectangle.getText().toString())){
                    Toast.makeText(MainActivity.this, "মোট চতুর্ভুজের সংখ্যা লিখুন...",
                            Toast.LENGTH_SHORT).show();
                }else {

                a = Double.parseDouble(totalPI.getText().toString());
                b = Double.parseDouble(totalTriangle.getText().toString());
                c = Double.parseDouble(totalRectangle.getText().toString());

                if(b+c > a){
                    Toast.makeText(MainActivity.this, "মোট PI এর চেয়ে ত্রিভুজ ও চতুর্ভুজের মোট সংখ্যা বেশি!",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {

                myResult = ((b-c)/a)*100;

                final DecimalFormat df = new DecimalFormat("0.00");


                viewResult.setText(String.valueOf( df.format(myResult) + "%"));


                if(myResult == 100){
                    viewComment.setText("অনন্য (Upgrading)");
                    imageView.setImageResource(R.drawable.upgrading);
                }
                if(myResult < 100 && myResult >= 50){
                    viewComment.setText("অর্জনমুখী (Achieving)");
                    imageView.setImageResource(R.drawable.achieving);
                }
                if(myResult < 50 && myResult >= 25){
                    viewComment.setText("অগ্রগামী (Advancing)");
                    imageView.setImageResource(R.drawable.advancing);
                }
                if(myResult < 25 && myResult >= 0){
                    viewComment.setText("সক্রিয় (Activating)");
                    imageView.setImageResource(R.drawable.activating);
                }
                if(myResult < 0 && myResult >= -25){
                    viewComment.setText("অনুসন্ধানী (Exploring)");
                    imageView.setImageResource(R.drawable.exploring);
                }
                if(myResult < -25 && myResult >= -50){
                    viewComment.setText("বিকাশমান (Developing)");
                    imageView.setImageResource(R.drawable.developing);
                }
                if(myResult < -50 && myResult >= -100){
                    viewComment.setText("প্রারম্ভিক (Elementary)");
                    imageView.setImageResource(R.drawable.elementary);
                }

                }}
                totalRectangle.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }

        });

        resetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPI.setText("");
                totalTriangle.setText("");
                totalRectangle.setText("");
                viewComment.setText("");
                viewResult.setText("");
                imageView.setImageResource(R.drawable.blank);

            }
        });

    }
}