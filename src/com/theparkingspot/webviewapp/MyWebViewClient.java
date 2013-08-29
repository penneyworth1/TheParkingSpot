package com.theparkingspot.webviewapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient  extends WebViewClient
{
	@Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) 
	{
        //We will handle link-clicking. Returning true allows the system to handle a link-click, which opens a browser on top of the app.
        return false;
    }
}
