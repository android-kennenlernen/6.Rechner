//
// Copyright (C) 2013 Uli Fuchs
// MIT licensed
//

// Issues:
// 2013-11-17 Meth. 'invertNumber':
//            - Eingabe von '.' plus Vorzeichen-Wechsel wirft Exception

package com.example.rechner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private String displayText;
	
	private EditText etDisplay;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.etDisplay = (EditText) findViewById(R.id.etDisplay);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * Liest Display aus
     * @return Zahl im Display
     */
    String readDisplay() {
    	return this.etDisplay.getText().toString();
    }

    /**
     * Schreibt auf's Display 
     * @param value - Darzustellende Zahl
     */
    void writeDisplay(String value) {
    	this.etDisplay.setText(value);
    }     
    
    /**
     * 
     * @param value
     * @return
     */
    boolean hasPeriod(String value) {
    	return value.contains(".");
    }
    
    /**
     * Aendert das Vorzeichen eine Zahl
     * @param value - Die zu invertierende Zahl als Zeichenkette 
     * @return Die invertierte Zahl als Zeichenkette
     */
    String invertNumber(String value) {

    	String retVal;
    	
    	int len = value.length();
    	
    	int periodPos = value.indexOf('.') + 1;

    	// Aussage, ob sich der Dezimalpunkt an der letzten Position befindet, 
    	// e.g. '1.' 
    	// Dann sollte diese Zahl wie eine Integer behandelt werden.
    	boolean excludePeriod = len == periodPos;  
    	
    	// Aussage, ob sich der Dezimalpunkt links vom Ende der Zahl befindet,
    	// e.g. '1.0'
    	boolean realDouble = this.hasPeriod(value) 
    		&& (len > periodPos);

    	if (realDouble) {
    		
        	double res = Double.parseDouble(value) * (-1.0);
        	retVal = Double.toString(res);
        	
    	} else {
    		
    		if (excludePeriod) {
    			// Dezimalpunkt voruebergehend entfernen.
    			value = value.substring(0, len - 1);
    		}
    		
    		int res = Integer.parseInt(value) * -1;
    		retVal = Integer.toString(res); 
    		
    		if (excludePeriod) {
    			// Dezimalpunkt wieder zurueckschreiben.
    			retVal += ".";
    		}
  
    	}
    	
		return retVal;    	
    	
    }     
    
    /**
     * 
     * @param v
     */
    public void onClickBtnNum(View v) {
    	

    	String num = "";
    	
    	int id = v.getId();
    	
    	this.displayText = this.readDisplay();
    	
    	switch (id) {
    	
    	case R.id.btnNum_0 : num = "0"; break;
    	case R.id.btnNum_1 : num = "1"; break; 
    	case R.id.btnNum_2 : num = "2"; break;
    	case R.id.btnNum_3 : num = "3"; break;
    	case R.id.btnNum_4 : num = "4"; break;
    	case R.id.btnNum_5 : num = "5"; break;
    	case R.id.btnNum_6 : num = "6"; break;
    	case R.id.btnNum_7 : num = "7"; break;
    	case R.id.btnNum_8 : num = "8"; break;
    	case R.id.btnNum_9 : num = "9"; break;
    	case R.id.btnNum_Period : num = !this.hasPeriod(this.displayText) ? "." : ""; 
    		break;
    	case R.id.btnNum_Invert : this.displayText = invertNumber(this.displayText); 
    		break;    		
    	}     	
 
    	this.displayText += num;
    	
    	this.writeDisplay(this.displayText);
    		
    		
    }

    /**
     * 
     */
    void clearOp() {
    	this.displayText = "";
    	this.writeDisplay(this.displayText);
    }
    
    /**
     * 
     * @param v
     */
    public void onClickBtnOp(View v) {

    	int id = v.getId();
    	
    	switch (id) {
    	
    	case R.id.btnOp_Clear : clearOp();break;
    	
    	}     	
    	
    }
    
}
