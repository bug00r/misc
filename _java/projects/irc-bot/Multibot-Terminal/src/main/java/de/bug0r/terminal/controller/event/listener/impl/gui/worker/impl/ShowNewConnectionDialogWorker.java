package de.bug0r.terminal.controller.event.listener.impl.gui.worker.impl;

import javax.swing.JDialog;

import de.bug0r.terminal.controller.event.listener.worker.Worker;
import de.bug0r.terminal.view.toolkit.ViewComponent;
import de.bug0r.terminal.view.toolkit.ViewToolkit;

public class ShowNewConnectionDialogWorker implements Worker {

	@Override
	public void doIt(Object data) {
		if ( dialog == null ) dialog = (JDialog) ViewToolkit.getInstance().getComponent(ViewComponent.BOT_CONNECT_DLG);
		new Thread(new Runnable(){

			@Override
			public void run() {
				ShowNewConnectionDialogWorker.this.dialog.setVisible(true);		
			}
			
		}).start();
	}

	private JDialog dialog;
	
}
