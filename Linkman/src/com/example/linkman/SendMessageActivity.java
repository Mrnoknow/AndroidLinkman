package com.example.linkman;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lenovo on 2015/10/28.
 */
public class SendMessageActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        Bundle bundle=getIntent().getExtras();
        final EditText textView=(EditText)findViewById(R.id.myEditText1);
       final String telephone=bundle.getString("telephone");
        textView.setText(telephone);
        final EditText editText=(EditText)findViewById(R.id.myEditText2);
        Button button=(Button)findViewById(R.id.myButton1);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                SmsManager smsManager=SmsManager.getDefault();
                PendingIntent pendingIntent=PendingIntent.getBroadcast(SendMessageActivity.this,0,new Intent(),0);
                smsManager.sendTextMessage(telephone,null,editText.getText().toString(),pendingIntent,null);
                editText.setText("");
            }
        });
    }
}
