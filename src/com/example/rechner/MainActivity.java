//
// Copyright (C) 2013 Uli Fuchs
// MIT licensed
//

package com.example.rechner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

// Art der gewuenschten Operation
enum Operation {none, add, sub, mul, div};

// Zustand des Rechenwerkes
enum State {clean, hasOp1, hasOp2}; 

public class MainActivity extends Activity {

	// Rechenwerk
	private State state = State.clean;
	private String op1;
	private Operation op = Operation.none;
	private String op2;

	// Display
	private EditText etDisplay;
	private boolean newOperandExpected = true;
	
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
     * 
     * @param value
     */
    private void setOp1(String value) {
    	this.op1 = value;
    	this.state = State.hasOp1;
    }

    /**
     * 
     * @param value
     */
    private void setOp2(String value) {
    	this.op2 = value;
    	this.state = State.hasOp2;
    }
    
    
    /**
     * Liest das Display aus
     * @return Zahl im Display
     */
    String readDisplay() {
    	return this.etDisplay.getText().toString();
    }

    /**
     * Beschreiben des Displays 
     * @param value - Darzustellende Zahl
     */
    void writeDisplay(String value) {
    	this.etDisplay.setText(value);
    }     
    
    /**
     * Prueft das Vorhandensein eines Dezimal-Punktes in 'value' 
     * @param value - Zu ueberpruefender Zahlenwert
     * @return 'True', wenn Dezimal-Punkt vorhanden, andererweise 'False'
     */
    boolean hasDecimalPoint(String value) {
    	return value.contains(".");
    }
    
    /**
     * Aendert das Vorzeichen eine Zahl
     * @param value - Die zu invertierende Zahl als Zeichenkette 
     * @return Die invertierte Zahl als Zeichenkette
     */
    String invertNumber(String value) {

    	Double res = Double.parseDouble(value) * (-1);
		return res.toString();    	
    	
    }     
    
    /**
     * Ermittelt den betaetigten Schalter und leitet die betreffende Aktion ein
     * @param v - Referenz aud betaetigten Schalter
     */
	public void onClickBtnNum(View v) {

		String num = "";

		String displayText = "";
		
		if (this.newOperandExpected) {
			this.writeDisplay("");
			this.newOperandExpected = false;
		} else {
			displayText = this.readDisplay();
		}

		// Auswerten des betaetigten Schalters
		switch (v.getId()) {

		case R.id.btnNum_0:
			num = "0";
			break;
		case R.id.btnNum_1:
			num = "1";
			break;
		case R.id.btnNum_2:
			num = "2";
			break;
		case R.id.btnNum_3:
			num = "3";
			break;
		case R.id.btnNum_4:
			num = "4";
			break;
		case R.id.btnNum_5:
			num = "5";
			break;
		case R.id.btnNum_6:
			num = "6";
			break;
		case R.id.btnNum_7:
			num = "7";
			break;
		case R.id.btnNum_8:
			num = "8";
			break;
		case R.id.btnNum_9:
			num = "9";
			break;
		case R.id.btnNum_Period:
			if (!this.hasDecimalPoint(displayText)) {
				num = ".";
			}
			break;
		case R.id.btnNum_Invert:
			displayText = invertNumber(displayText);
			break;
		}

		this.writeDisplay(displayText + num);

	}
    
    /**
     * Aktion beim Betaetigen des Schalters 'C'
     */
    void clearOp() {
    	
    	// Status des Rechenwerkes ruecksetzen
    	this.state = State.clean;
    	
    	// Display bereinigen
    	this.writeDisplay("");
    	
    }
    
    /**
     * 
     * @param v
     */
    public void onClickBtnOp(View v) {

    	Operation op = Operation.none;
    	String result;
    	
    	this.newOperandExpected = true;
    	
    	switch (v.getId()) {
    	
    	case R.id.btnOp_Plus : op = Operation.add;  break;
    	case R.id.btnOp_Minus : op = Operation.sub; break;
    	case R.id.btnOp_Mul : op = Operation.mul; break;
    	case R.id.btnOp_Div : op = Operation.div; break;
    	case R.id.btnOp_Clear : clearOp();return;
    	case R.id.btnOp_Equals : equalsOp();return;
    	
    	
    	}     	
    	
    	this.handleOperand(op);    	

    	if (this.state == State.hasOp2) {
    		result = this.calculate(this.op);
    		this.writeDisplay(result);
    		this.handleOperand(op);
    	}
    	
    }
    
    /**
     * 
     */
    void equalsOp() {
    	
		this.setOp2(this.readDisplay());

		String result = this.calculate(this.op);

		this.writeDisplay(result);
		this.state = State.clean;
    	
    }
    
    /**
     * 
     * @param op
     */
    void handleOperand(Operation op) {
    	
    	switch (this.state) {
    	case clean :
    		this.setOp1(this.readDisplay());
    		this.op = op;
    		break;
    	case hasOp1 :
    		this.setOp2(this.readDisplay());
    		break;
		default:
			break;
    	}
    	
    }
    
    /**
     * 
     * @return
     */
    private String calculate(Operation op) {

    	double op1 = Double.parseDouble(this.op1);
    	double op2 = Double.parseDouble(this.op2);
    	double res = 0;

    	switch (op) {
    	
    	case add : res = op1 + op2; this.state = State.clean; break;  
    	case sub : res = op1 - op2; this.state = State.clean; break;
    	case mul : res = op1 * op2; this.state = State.clean; break;
    	case div : res = op1 / op2; this.state = State.clean; break;
		default:
			break;
    	
    	}
    	
    	return Double.toString(res);
    	
    }
    
}
