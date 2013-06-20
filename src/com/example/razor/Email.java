package com.example.razor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personsEmail, intro, personsName, things, hatefulAction, outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		personsName = (EditText) findViewById(R.id.etName);
		things = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOut);
		sendEmail = (Button) findViewById(R.id.btnSend);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		retrieveStrings();
		String emailaddress[] = { emailAdd };
		String message = "Well hello "
				+ name
				+ " I just wanted to say "
				+ beginning
				+ ".  Not only that but I hate when you "
				+ stupidAction
				+ ", that just really makes me crazy.  I just want to make you "
				+ hatefulAct
				+ ".  Welp, thats all I wanted to chit-chatter about, oh and"
				+ out
				+ ".  Oh also if you get bored you should check out www.mybringback.com"
				+ '\n' + "PS. I think I love you...    ";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		//for emails u want to send to, takes in string array only
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAdd);
		//for subject of email takes in string
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you!");
		emailIntent.setType("plain/text");
		//for the message takes in a string
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);

	}

	private void retrieveStrings() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction = things.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}