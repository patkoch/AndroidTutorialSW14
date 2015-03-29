package com.example.sw14;

import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements OnClickListener {

	private Button buttonOne;
	private Button buttonTwo;
	private Button buttonThree;
	private Button buttonFour;
	private Button buttonFive;
	private Button buttonSix;
	private Button buttonTest;
	private Button buttonSeven;
	private Button buttonEigth;
	private Button buttonNine;
	private Button buttonZero;

	private Button buttonAddition;
	private Button buttonSubtraction;
	private Button buttonMultiplication;
	private Button buttonDivision;

	private Button buttonClear;
	private Button buttonEqual;

	private EditText inputField;

	private int numberOne;

	private String showTextToUser;

	private int operationFlag;

	public static final int ADD = 0;
	public static final int SUB = 1;
	public static final int MUL = 2;
	public static final int DIV = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// use this method for initializing the activity

		// set the GUI of the activity
		setContentView(R.layout.activity_calculator);

		// retrieve the widgets (buttons, inputfield)

		this.buttonOne = (Button) this.findViewById(R.id.buttonOne);
		this.buttonTwo = (Button) this.findViewById(R.id.buttonTwo);
		this.buttonThree = (Button) this.findViewById(R.id.buttonThree);
		this.buttonFour = (Button) this.findViewById(R.id.buttonFour);
		this.buttonFive = (Button) this.findViewById(R.id.buttonFive);
		this.buttonSix = (Button) this.findViewById(R.id.buttonSix);
		this.buttonSeven = (Button) this.findViewById(R.id.buttonSeven);
		this.buttonEigth = (Button) this.findViewById(R.id.buttonEigth);
		this.buttonNine = (Button) this.findViewById(R.id.buttonNine);

		this.buttonZero = (Button) this.findViewById(R.id.buttonZero);

		this.buttonAddition = (Button) this.findViewById(R.id.buttonPlus);
		this.buttonSubtraction = (Button) this.findViewById(R.id.buttonMinus);
		this.buttonMultiplication = (Button) this
				.findViewById(R.id.buttonMultiplication);
		this.buttonDivision = (Button) this.findViewById(R.id.buttonDivision);

		this.buttonClear = (Button) this.findViewById(R.id.buttonClear);
		this.buttonEqual = (Button) this.findViewById(R.id.buttonEqual);

		this.inputField = (EditText) this.findViewById(R.id.inputField);

		// set the buttons clickable

		buttonOne.setOnClickListener(this);
		buttonTwo.setOnClickListener(this);
		buttonThree.setOnClickListener(this);
		buttonFour.setOnClickListener(this);
		buttonFive.setOnClickListener(this);
		buttonSix.setOnClickListener(this);
		buttonSeven.setOnClickListener(this);
		buttonEigth.setOnClickListener(this);
		buttonNine.setOnClickListener(this);
		buttonZero.setOnClickListener(this);

		buttonAddition.setOnClickListener(this);
		buttonSubtraction.setOnClickListener(this);
		buttonMultiplication.setOnClickListener(this);
		buttonDivision.setOnClickListener(this);

		buttonClear.setOnClickListener(this);
		buttonEqual.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		Button buttonClicked = (Button) arg0;

		if (buttonClicked.getId() == buttonAddition.getId()) {
			// get the first number
			this.numberOne = Integer.valueOf(this.inputField.getText()
					.toString());

			// delete content of the inputfield
			this.inputField.setText("");
			// set flag

			this.operationFlag = ADD;
		} else if (buttonClicked.getId() == buttonSubtraction.getId()) {

			this.numberOne = Integer.valueOf(this.inputField.getText()
					.toString());

			this.inputField.setText("");
			this.operationFlag = SUB;
		} else if (buttonClicked.getId() == buttonMultiplication.getId()) {

			this.numberOne = Integer.valueOf(this.inputField.getText()
					.toString());
			this.inputField.setText("");
			this.operationFlag = MUL;
		} else if (buttonClicked.getId() == buttonDivision.getId()) {

			this.numberOne = Integer.valueOf(this.inputField.getText()
					.toString());
			this.inputField.setText("");
			this.operationFlag = DIV;
		} else if (buttonClicked.getId() == buttonClear.getId()) {
			this.inputField.setText("");
		} else if (buttonClicked.getId() == buttonEqual.getId()) {
			int numberTwo, result = 0;

			numberTwo = Integer.valueOf(this.inputField.getText().toString());

			switch (this.operationFlag) {

			case ADD:
				result = this.numberOne + numberTwo;
				break;
			case SUB:
				result = this.numberOne - numberTwo;
				break;
			case MUL:
				result = this.numberOne * numberTwo;
				break;
			case DIV:
				result = this.numberOne / numberTwo;
				break;
			}

			this.inputField.setText(String.valueOf(result));

		} else {
			Log.d("TAG", "Number was clicked");
			this.showTextToUser = this.inputField.getText().toString();
			this.showTextToUser += buttonClicked.getText().toString();
			this.inputField.setText(this.showTextToUser);
		}

	}

}
