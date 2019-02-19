package de.bug0r.terminal.view.toolkit.item;

public class NullBuilder implements ComponentBuilder {

	@Override
	public Object create() {
		return new Object();
	}

}
