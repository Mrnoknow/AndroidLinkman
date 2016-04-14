package com.example.linkman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2015/10/26.
 */
public class SingeMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singe_message_activity);
        final Button myButton2=(Button)findViewById(R.id.myButton2);
        Bundle bundle=getIntent().getExtras();
        final Man man=(Man) bundle.getParcelable("man");
        myButton2.setText(man.getNumber());
        Button button=(Button)findViewById(R.id.button2);
        Button change=(Button)findViewById(R.id.button1);
        Button delete=(Button)findViewById(R.id.button3);
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(man.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             
                Intent intent = new Intent();
                intent.setClass(SingeMessageActivity.this, SendMessageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("telephone", man.getNumber());
                intent.putExtras(bundle);
                startActivity(intent);
                
            }
        });
      
        myButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent("android.intent.action.CALL", Uri.parse("tel:"+man.getNumber()));
                startActivity(myIntent);
            }
        });
        change.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent();
	                intent.setClass(SingeMessageActivity.this, UpdateActivity.class);
	                Bundle bundle = new Bundle();
	                bundle.putString("name", man.getName());
	                intent.putExtras(bundle);
	                startActivity(intent);
			}
        	
        });
        delete.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DatabaseLinkman linkman = new DatabaseLinkman(SingeMessageActivity.this, "linkman", null, 1);
				linkman.Delete( linkman.getWritableDatabase(),man.getName());
				new  AlertDialog.Builder(SingeMessageActivity.this)    
				.setMessage("Are you sure you want to delete?") 
			      
			       .setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
			           public void onClick(DialogInterface dialog, int id) { 
			        	   SingeMessageActivity.this.finish();
			           } 
			       }) 
			       .setNegativeButton("No", new DialogInterface.OnClickListener() { 
			           public void onClick(DialogInterface dialog, int id) { 
			                dialog.cancel(); 
			           } 
			       }).show(); 
				
			}
        	
        });
    }
}
