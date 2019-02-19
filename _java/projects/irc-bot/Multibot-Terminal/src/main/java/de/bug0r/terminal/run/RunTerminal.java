package de.bug0r.terminal.run;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.bug0r.terminal.app.Application;

public class RunTerminal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}
		Application app = Application.getInstance();
		app.start();

	}

}
