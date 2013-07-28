package com.example.razor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {
	private EditText send;
	private Button startActivity;
	private Button startForResult;
	private TextView got;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		init();
	}

	public void init() {
		
		send = (EditText)findViewById(R.id.etSend);
		startActivity = (Button)findViewById(R.id.bstart);
		startForResult = (Button)findViewById(R.id.bstartForResult);
		got = (TextView) findViewById(R.id.tvgot);
		startActivity.setOnClickListener(this);
		startForResult.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bstartForResult:
			
			break;
		case R.id.bstart:
			String bread = send.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Log.d("", "here");
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;

		default:
			break;
		}
	}

}
