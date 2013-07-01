package com.example.razor;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements OnClickListener {
	private ImageButton takepic;
	private Button setWall;
	private ImageView showpic;
	private Intent i;
	private final static int cameraData = 0;
	private Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		init();
	}

	private void init() {
		takepic = (ImageButton) findViewById(R.id.ibTakePic);
		setWall = (Button) findViewById(R.id.bSetWall);
		showpic = (ImageView) findViewById(R.id.ivReturnedPicture);
		takepic.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSetWall:
			
				try {
					if(bmp!= null){
					getApplicationContext().setWallpaper(bmp);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case R.id.ibTakePic:
			i= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			showpic.setImageBitmap(bmp);
		}
	}
}
