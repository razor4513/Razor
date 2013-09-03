package com.example.razor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {
	String sendData = "";
	TextView question;
	TextView test;
	Button returnData;
	RadioGroup selectionList;
	RadioButton sexy;
	RadioButton crazy;
	RadioButton both;
	String gotBread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		init();
		Bundle gotBasket = getIntent().getExtras();
		if(gotBasket != null){
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
		}
	}

	public void init() {
		question = (TextView) findViewById(R.id.tv_question);
		returnData = (Button) findViewById(R.id.b_return);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rg_answers);
		selectionList.setOnCheckedChangeListener(this);
		test = (TextView)findViewById(R.id.hi);

	}

	public void onClick(View v) {
		Intent person = new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("answer", sendData);
		person.putExtras(bundle);
		setResult(RESULT_OK, person);
		finish();
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.r_crazy:
			sendData = "probably";
			break;
		case R.id.r_sexy:
			sendData = "Definately";
			break;
		case R.id.r_both:
			sendData = "Spot on";
			break;
		default:
			break;
		}
		test.setText(sendData);

	}

}
