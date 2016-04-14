package com.example.linkman;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddmanActivity extends ActionBarActivity {
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addman);
        final EditText name=(EditText)findViewById(R.id.editText1);
        final EditText telephone=(EditText)findViewById(R.id.editText2);
        Button Sure=(Button)findViewById(R.id.button1);
        Button No=(Button)findViewById(R.id.button2);
        Sure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(TextUtils.isEmpty(name.getText().toString())){
					new  AlertDialog.Builder(AddmanActivity.this)    
					 
	                //.setTitle("标题" )  
	   
	                .setMessage("请输入姓名" )  
	   
	                .setPositiveButton("确定" ,  null )  
	   
	                .show();  

				}
				else if(TextUtils.isEmpty(telephone.getText().toString())){
					new  AlertDialog.Builder(AddmanActivity.this)    
					 
	                //.setTitle("标题" )  
	   
	                .setMessage("请输入电话" )  
	   
	                .setPositiveButton("确定" ,  null )  
	   
	                .show();  

				}
				else{
				DatabaseLinkman linkman = new DatabaseLinkman(AddmanActivity.this, "linkman", null, 1);
				Man man=new Man(name.getText().toString(),telephone.getText().toString());
				linkman.Insert(man, linkman.getWritableDatabase());
				new  AlertDialog.Builder(AddmanActivity.this)    
			 
				                //.setTitle("标题" )  
				   
				                .setMessage("添加成功" )  
				   
				                .setPositiveButton("确定" ,  new DialogInterface.OnClickListener() { 
							           public void onClick(DialogInterface dialog, int id) { 
							        	   AddmanActivity.this.finish();}} )  
				   
				                .show();  
			
				}
				
			}
        	
        });
        No.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }
}
