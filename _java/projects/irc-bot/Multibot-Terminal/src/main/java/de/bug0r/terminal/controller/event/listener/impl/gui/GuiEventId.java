package de.bug0r.terminal.controller.event.listener.impl.gui;

import de.bug0r.terminal.controller.event.EventId;

public enum GuiEventId implements EventId {
	SHOW_MAIN_FRAME, 
	SHOW_NEW_CON_DLG;

	@Override
	public Object get() {
		return this;
	}

}
