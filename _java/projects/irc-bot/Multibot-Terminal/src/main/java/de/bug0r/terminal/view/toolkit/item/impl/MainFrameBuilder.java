package de.bug0r.terminal.view.toolkit.item.impl;

import javax.swing.JDialog;
import javax.swing.JFrame;

import de.bug0r.terminal.view.main.frame.NewConnectionDialog;
import de.bug0r.terminal.view.main.frame.TerminalFrame;
import de.bug0r.terminal.view.toolkit.ViewComponent;
import de.bug0r.terminal.view.toolkit.ViewToolkit;
import de.bug0r.terminal.view.toolkit.item.ComponentBuilder;

public class MainFrameBuilder implements ComponentBuilder {

	@Override
	public Object create() {
		if ( frame == null ) frame = new TerminalFrame();
		return frame;
	}

	private JFrame frame;
}
