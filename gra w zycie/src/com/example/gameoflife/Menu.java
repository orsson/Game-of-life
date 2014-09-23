package com.example.gameoflife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		 Button button = (Button) findViewById(R.id.button1);   
		 button.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) 
		        {
		        PaintView.yy=0;
		        Intent startNewActivityOpen = new Intent(com.example.gameoflife.Menu.this, MainActivity.class);
		        startActivityForResult(startNewActivityOpen, 0);	
		        }
		    });
		 
		 Button button2 = (Button) findViewById(R.id.button2);   
		 button2.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) 
		        {    
		        PaintView.yy=1;
		        Intent startNewActivityOpen = new Intent(com.example.gameoflife.Menu.this, MainActivity.class);
		        startActivityForResult(startNewActivityOpen, 0);	
		        }
		    });
		 
		 Button button3 = (Button) findViewById(R.id.button3);   
		 button3.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) 
		        {    
		        PaintView.yy=2;
		        Intent startNewActivityOpen = new Intent(com.example.gameoflife.Menu.this, MainActivity.class);
		        startActivityForResult(startNewActivityOpen, 0);	
		        }
		    });
		 
		 Button button4 = (Button) findViewById(R.id.button4);   
		 button4.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) 
		        {    
		        PaintView.yy=3;
		        Intent startNewActivityOpen = new Intent(com.example.gameoflife.Menu.this, MainActivity.class);
		        startActivityForResult(startNewActivityOpen, 0);	
		        }
		    });
		 
		 Button button5 = (Button) findViewById(R.id.button5);   
		 button5.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) 
		        {    
		        PaintView.yy=4;
		        Intent startNewActivityOpen = new Intent(com.example.gameoflife.Menu.this, MainActivity.class);
		        startActivityForResult(startNewActivityOpen, 0);	
		        }
		    });
	}

	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
