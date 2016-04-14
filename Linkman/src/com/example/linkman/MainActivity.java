package com.example.linkman;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends ActionBarActivity {
	Adapter adapter;
	ListView list;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (ListView) findViewById(R.id.listView);
        list.setTextFilterEnabled(true);
        SearchView sv = (SearchView) findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
        adapter = new Adapter(this);
        
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               
                ViewHolder text = (ViewHolder) view.getTag();
                Intent intent = new Intent();
                Man man=new Man(text.name.getText().toString(),text.number.getText().toString());
                intent.setClass(MainActivity.this, SingeMessageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("man",man);
                intent.putExtras(bundle);
                startActivity(intent);
               
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    list.clearTextFilter();  // 清楚ListView的过滤
                    adapter=new Adapter(MainActivity.this);
                    list=(ListView)findViewById(R.id.listView);
                    list.setAdapter(adapter);
                } else {
                	adapter=new Adapter(MainActivity.this,newText);
                    list=(ListView)findViewById(R.id.listView);
                    list.setAdapter(adapter);// 设置ListView的过滤关键词
                }
                return true;
            }

        });
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent();  
	            intent.setAction("android.intent.action.CALL_BUTTON");  
	            startActivity(intent);
			}
        	
        });
        button2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent();
				intent.setClass(MainActivity.this, AddmanActivity.class);
				startActivity(intent);
			}
        	
        });

    }

}