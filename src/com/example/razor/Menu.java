package com.example.razor;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity {
	String classes[] = { "Startingpoint", "TextPlay", "Email", "Camera",
			"Data", "example5", "example6" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String name = classes[position];
		try {
			Class ourClass = Class.forName("com.example.razor." + name);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.preferences:
			Toast.makeText(getApplicationContext(), "preferences not implemented yet", Toast.LENGTH_SHORT);
			return true;
		case R.id.about_us:
			Toast.makeText(getApplicationContext(), "about us not implemented yet", Toast.LENGTH_SHORT);
			return true;

		default:
			return false;
		}

	}

}
