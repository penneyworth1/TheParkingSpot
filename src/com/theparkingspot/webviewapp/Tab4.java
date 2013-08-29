package com.theparkingspot.webviewapp;

import com.theparkingspot.webviewapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ImageView.ScaleType;

public class Tab4 extends Activity 
{

	//private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab4);
		
		final WebView webView = (WebView) findViewById(R.id.webView4);
		final ProgressBar myPB = (ProgressBar) findViewById(R.id.progressBar4);
		final ImageView myImageView = (ImageView) findViewById(R.id.spotsImageView4);
		myImageView.setScaleType(ScaleType.CENTER_CROP);
		
		if(MainActivity.networkConnected)
		{
			webView.setWebViewClient(new MyWebViewClient());
			webView.getSettings().setJavaScriptEnabled(true);
			webView.setVerticalScrollBarEnabled(false);
			webView.setHorizontalScrollBarEnabled(false);
			
			webView.setWebViewClient(new WebViewClient()
				{
		            @Override
		            public void onPageFinished(WebView view, String url)
		            {
		                // Show webview and hide progress bar
		                webView.setVisibility(View.VISIBLE);
		                myPB.setVisibility(View.INVISIBLE);
		                myImageView.setVisibility(View.INVISIBLE);
		            }
		        }
			);
			
			webView.loadUrl("https://app.theparkingspot.com/Mobile/SpotClub/Login.aspx");
		}
		else
		{
			myPB.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab4, menu);
		return true;
	}

}
