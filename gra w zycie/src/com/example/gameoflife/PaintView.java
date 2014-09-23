package com.example.gameoflife;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class PaintView extends SurfaceView
{
    Paint paint = new Paint(); 
    static int xx=0; //odpowiedzialne za rysowanie i ruch
    static int yy=0; //odpowiedzialne za ustawienie tab poczatkowej
    
	static int a=26;
	static int b=20;
	static int[][] tab=new int[a][b];
	
    public PaintView(Context context, AttributeSet attrs) 
    {
        super(context, attrs);
        paint = new Paint();
        
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				tab[i][j]=0;
			}
		}
		if(yy==1){tab[5][4]=1;tab[5][5]=1;tab[5][6]=1;tab[7][11]=1;tab[8][11]=1;tab[9][11]=1;tab[14][11]=1;tab[14][12]=1;tab[14][13]=1;tab[9][2]=1;tab[9][3]=1;tab[9][4]=1;}
		if(yy==2){tab[14][15]=1;tab[14][16]=1;tab[14][17]=1;tab[15][15]=1;tab[16][16]=1;}
		
    }
   
    public boolean onTouchEvent(MotionEvent event) 
    {
    	xx=0; 
    	int x=(int) (event.getX()/30);
        int y=(int) (event.getY()/30);
        
        if(y>23)
        {
        xx=1;
        }
        else
        {
        tab[y][x]=1;
        }
        
        invalidate();
        return true;
    }

	@SuppressLint("DrawAllocation")
	public void onDraw(Canvas canvas)
	{		
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(4);        
		paint.setStyle(Paint.Style.STROKE);  
		//siatka
		for(int i=0;i<24;i++)
		{
			for(int j=0;j<18;j++)
			{
				
				canvas.drawRect(30*j,30*i,30+30*j,30+30*i,paint); 
			}	
		}

		int[][]tab2=new int[a][b];
		
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				tab2[i][j]=0;
			}
		}
		
		//periodycznosc
		
		for(int i=0;i<26;i++)
		{
			for(int j=0;j<20;j++)
			{
				tab[0][j]=tab[24][j];
				tab[25][j]=tab[1][j];
				tab[i][0]=tab[i][18];
				tab[i][19]=tab[i][1];
			}
		}
		
	
	if(xx==1)
	{
		 int licznik;
	     for (int m = 0; m < 25; m++)
	     {
	         for (int n = 0; n < 19; n++)
	         {
	             licznik = 0;
           
	            
	             if(m==0 || n==0)
	             {
	             if (tab[23][17] == 1) licznik++;
	             if (tab[23][n] == 1) licznik++;
	             if (tab[23][n+1] == 1) licznik++;
	             if (tab[m][17] == 1) licznik++;
	             if (tab[m][n+1] == 1) licznik++;
	             if (tab[m+1][17] == 1) licznik++;
	             if (tab[m+1][n] == 1) licznik++;
	             if (tab[m+1][n+1] == 1) licznik++;
	             }
	             
	             
	             else
	             {
	             if (tab[m-1][n-1] == 1) licznik++;
	             if (tab[m-1][n] == 1) licznik++;
	             if (tab[m-1][n+1] == 1) licznik++;
	             if (tab[m][n-1] == 1) licznik++;
	             if (tab[m][n+1] == 1) licznik++;
	             if (tab[m+1][n-1] == 1) licznik++;
	             if (tab[m+1][n] == 1) licznik++;
	             if (tab[m+1][n+1] == 1) licznik++;
	             }
	             
	             if (tab[m][n] == 1 && licznik < 2)
	            	 tab2[m][n] = 0;
	             else if (tab[m][n] == 1 && licznik > 3)
	            	 tab2[m][n] = 0;
	             else if (tab[m][n] == 1 && (licznik == 2 || licznik == 3))
	            	 tab2[m][n] = 1;
	             else if (tab[m][n] == 0 && licznik == 3)
	            	 tab2[m][n] = 1;
	      
	         }
	     }
	     
	     for (int m = 0; m < a; m++)
	     {
	         for (int n = 0; n < b; n++)
	             tab[m][n] = tab2[m][n];
	     }
		
		
	}
		//wypelnienie siatki
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.RED);
		
		if(yy==4)
		{
			Random rnd = new Random();
			
			int r=rnd.nextInt(256);
			int g=rnd.nextInt(256);
			int b=rnd.nextInt(256);
			paint.setColor(Color.rgb(r,g,b));
			
		}
		
		for(int i=0;i<24;i++)
		{
			for(int j=0;j<18;j++)
			{
				if(tab[i][j]==1)
				canvas.drawRect((30*j)+2,(30*i)+2,(30+30*j)-2,(30+30*i)-2,paint);	
				if(yy==3)
				{
				Random rnd = new Random();
				int r=rnd.nextInt(256);
				int g=rnd.nextInt(256);
				int b=rnd.nextInt(256);
				paint.setColor(Color.rgb(r,g,b));
				}
			}
		}
	}
}
 
