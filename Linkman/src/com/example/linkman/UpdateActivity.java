package com.example.linkman;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends ActionBarActivity{
	   protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_update);
	        final EditText name=(EditText)findViewById(R.id.text1);
	        final EditText number=(EditText)findViewById(R.id.text2);
	        Button sure=(Button)findViewById(R.id.updatesure);
	        Bundle bundle=getIntent().getExtras();
	        final String getname=bundle.getString("name");
	        name.setText(getname);
	        sure.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					DatabaseLinkman linkman = new DatabaseLinkman(UpdateActivity.this, "linkman", null, 1);
					Man man=new Man(name.getText().toString(),number.getText().toString());
					linkman.Update( linkman.getWritableDatabase(),getname,man);
					new  AlertDialog.Builder(UpdateActivity.this)    	 
	                //.setTitle("标题" )  
	   
	                .setMessage("更新成功" )  
	   
	                .setPositiveButton("确定" ,  null )  
	   
	                .show();  
				}
	        	
	        });
	       
	   }

}
