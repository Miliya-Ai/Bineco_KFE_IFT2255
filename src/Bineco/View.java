package Bineco;

import java.util.ArrayList;

public class View {

	private ArrayList<View> history;
	private int viewIndex;
	private Controller controller;

	public void display() {
		// TODO - implement View.display
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param option
	 */
	public void navigate(View option) {
		// TODO - implement View.navigate
		throw new UnsupportedOperationException();
	}

	public void exit() {
		// TODO - implement View.exit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param view
	 */
	public void addView2History(View view) {
		// TODO - implement View.addView2History
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param viewIndex
	 */
	public void setViewIndex(int viewIndex) {
		this.viewIndex = viewIndex;
	}

	/**
	 * 
	 * @param msg
	 */
	public void printMsg(String msg) {
		// TODO - implement View.printMsg
		throw new UnsupportedOperationException();
	}

}