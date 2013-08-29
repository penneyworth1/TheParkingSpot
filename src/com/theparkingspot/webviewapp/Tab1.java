package com.theparkingspot.webviewapp;

import com.theparkingspot.webviewapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;

public class Tab1 extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab1);
		
		final WebView webView = (WebView) findViewById(R.id.webView1);
		final ProgressBar myPB = (ProgressBar) findViewById(R.id.progressBar1);
		final ImageView myImageView = (ImageView) findViewById(R.id.spotsImageView1);
		myImageView.setScaleType(ScaleType.CENTER_CROP);
		
		if(MainActivity.networkConnected)
		{
			webView.setWebViewClient(new MyWebViewClient());
			webView.setWebChromeClient(new WebChromeClient() 
			{
				 public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) 
				 {
					    callback.invoke(origin, true, false);
				 }
			});
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
			
			webView.loadUrl("http://app.theparkingspot.com/mobile/");
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
		getMenuInflater().inflate(R.menu.tab1, menu);
		return true;
	}

}
