package de.bug0r.terminal.view.toolkit.item.impl;

import javax.swing.JDialog;
import javax.swing.JFrame;

import de.bug0r.terminal.view.main.frame.NewConnectionDialog;
import de.bug0r.terminal.view.toolkit.ViewComponent;
import de.bug0r.terminal.view.toolkit.ViewToolkit;
import de.bug0r.terminal.view.toolkit.item.ComponentBuilder;

public class ConnectionDialogBuilder implements ComponentBuilder {

	@Override
	public Object create() {
		JFrame parent = (JFrame) ViewToolkit.getInstance().getComponent(ViewComponent.MAIN_FRAME);
		if ( connectioDialog == null ) connectioDialog = new NewConnectionDialog(parent);
		return connectioDialog;
	}

	private JDialog connectioDialog;
	
}
