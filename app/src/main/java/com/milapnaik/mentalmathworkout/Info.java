package com.milapnaik.mentalmathworkout;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.text.Html;

/**
 * Created by MilapNaik on 5/5/16.
 */
public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView textView =(TextView)findViewById(R.id.TTlink);
        textView.setTextSize(28);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.tradertest.org'> tradertest.org </a>";
        textView.setText(Html.fromHtml(text));
    }

    public void mainmenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
