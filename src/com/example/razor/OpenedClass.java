package com.example.razor;

import android.app.Activity;
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
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
	}

	public void init() {
		question = (TextView) findViewById(R.id.tv_question);
		returnData = (Button) findViewById(R.id.b_return);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rg_answers);
		selectionList.setOnCheckedChangeListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.r_crazy:

			break;
		case R.id.r_sexy:
			break;
		case R.id.r_both:
			break;

		default:
			break;
		}

	}

}
