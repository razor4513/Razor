package com.example.razor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Startingpoint extends Activity {
int count;
Button add, mult;
Button sub, div;
TextView display;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startingpoint);
        count=0;
        add= (Button) findViewById(R.id.bAdd);
        sub= (Button) findViewById(R.id.bSub);
        mult= (Button) findViewById(R.id.bMult);
        div= (Button) findViewById(R.id.bDiv);
        display= (TextView)findViewById(R.id.tvDisplay);
        add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count ++;
				display.setText ("Your total is: " + count);
			}
		});
        
 sub.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count --;
				display.setText ("Your total is: " + count);
			}
		});
 div.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			count /= 2;
			display.setText ("Your total is: " + count);
		}
	});
 mult.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			count *= 2;
			display.setText ("Your total is: " + count);
		}
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_startingpoint, menu);
        return true;
    }
}
