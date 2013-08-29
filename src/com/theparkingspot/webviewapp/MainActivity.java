package com.theparkingspot.webviewapp;

import com.theparkingspot.webviewapp.R;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends TabActivity implements OnTabChangeListener
{

	public static boolean networkConnected = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		networkConnected = isNetworkConnected();
		
		TabHost tabHost = getTabHost();
		tabHost.getTabWidget().setStripEnabled(false);
		tabHost.setOnTabChangedListener(this);
		
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
		tabSpec1.setIndicator("Home", getResources().getDrawable(R.drawable.firsttab_icon));
		Intent tab1Intent = new Intent(this, Tab1.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //Clear other activities on the stack so they reload when made active again (FLAG_ACTIVITY_CLEAR_TOP).
		tabSpec1.setContent(tab1Intent);
		
		TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
		tabSpec2.setIndicator("Locations", getResources().getDrawable(R.drawable.secondtab_icon));
		Intent tab2Intent = new Intent(this, Tab2.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		tabSpec2.setContent(tab2Intent);
		
		TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
		tabSpec3.setIndicator("Reservations", getResources().getDrawable(R.drawable.thirdtab_icon));
		Intent tab3Intent = new Intent(this, Tab3.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		tabSpec3.setContent(tab3Intent);
		
		TabSpec tabSpec4 = tabHost.newTabSpec("tab4");
		tabSpec4.setIndicator("Spot Club", getResources().getDrawable(R.drawable.fourthtab_icon));
		Intent tab4Intent = new Intent(this, Tab4.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		tabSpec4.setContent(tab4Intent);
		
		tabHost.addTab(tabSpec1);
		tabHost.addTab(tabSpec2);
		tabHost.addTab(tabSpec3);
		tabHost.addTab(tabSpec4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabChanged(String tabId)
	{
		networkConnected = isNetworkConnected();
		if(!networkConnected)
			Toast.makeText(getApplicationContext(), "No internet connection detected. Please check your network connectivity.", Toast.LENGTH_SHORT).show();
		
		//Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
		if(tabId.equals("tab1"))
		{
			
		}
		else if(tabId.equals("tab2"))
		{
			
		}
		else if(tabId.equals("tab3"))
		{
			
		}
		else if(tabId.equals("tab4"))
		{
			
		}
	}
	
	private boolean isNetworkConnected() 
	{
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) 
		{
			// There are no active networks.
			return false;
		} 
		else
			return true;
	}

}
