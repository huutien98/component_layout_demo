package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.vncoder.demo_layout.R;

public class TextVieww extends AppCompatActivity {
    android.widget.TextView textview1;
    android.widget.TextView textview2;
    android.widget.TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);
        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        next = findViewById(R.id.next);

        String htmlcontent =
                "<h1>Đây là HTML</h1><ul><li>Thẻ UL/LI</li><li>Thẻ UL/LI</li></ul>" +
                        "<p>Dòng <font color=\"red\">chữ</font> trong <big><b>thẻ p</b></big><p>" +
                        "<a href=\"...\">Bấm vào link</a>" +
                        "<strike>Gạch ngang</strike>";
        textview1.setText(Html.fromHtml(htmlcontent));

        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FancyToast.makeText(getBaseContext(),"Show Text view 1",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
            }
        });

        String noidung =
                "SpannableString\n" + "Chữ đậm\n" + "Gạch chân\n" + "Nghiêng\n" + "Kẻ ngang\n" + "Màu sắc\n" + "12AM\n" + "Click Me\n" + "URL\n" ;

        SpannableString noidungspanned = new SpannableString(noidung);

        noidungspanned.setSpan(new RelativeSizeSpan(2f), 0, 15, 0);
        noidungspanned.setSpan(new StyleSpan(Typeface.BOLD), 16, 23, 0);
        noidungspanned.setSpan(new UnderlineSpan(), 24, 33, 0);
        noidungspanned.setSpan(new StyleSpan(Typeface.ITALIC), 34, 42, 0);
        noidungspanned.setSpan(new StrikethroughSpan(), 42, 50, 0);
        noidungspanned.setSpan(new BackgroundColorSpan(Color.GREEN), 51, 59,0);
        noidungspanned.setSpan(new ForegroundColorSpan(Color.RED), 34, 51, 0 );
        noidungspanned.setSpan(new SuperscriptSpan(),20, 64, 0 );
        noidungspanned.setSpan(new RelativeSizeSpan(.9f),61, 64, 0 );
        noidungspanned.setSpan(new URLSpan("https://fb.com") , 64, 73, 0);

        noidungspanned.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(getApplication(),"textview",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
            }
        }, 73, 76, 0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextVieww.this, ImageVieww.class);
                startActivity(intent);
            }
        });


        textview2.setMovementMethod(LinkMovementMethod.getInstance());
        textview2.setText(noidungspanned);



    }
}