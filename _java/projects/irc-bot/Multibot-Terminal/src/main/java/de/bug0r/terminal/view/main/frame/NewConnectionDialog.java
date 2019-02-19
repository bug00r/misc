package de.bug0r.terminal.view.main.frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.bug0r.terminal.controller.event.listener.impl.model.ModelEvent;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEventId;
import de.bug0r.terminal.controller.impl.ControllerImpl;
import de.bug0r.terminal.controller.model.context.ConnectionData;

public class NewConnectionDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	public NewConnectionDialog(JFrame parent) {
		super(parent,true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAlias = new JLabel("Alias:");
		GridBagConstraints gbc_lblAlias = new GridBagConstraints();
		gbc_lblAlias.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlias.anchor = GridBagConstraints.EAST;
		gbc_lblAlias.gridx = 0;
		gbc_lblAlias.gridy = 0;
		getContentPane().add(lblAlias, gbc_lblAlias);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 1;
		getContentPane().add(lblPort, gbc_lblPort);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnConnect = new JButton(new CreateConnectionAction());
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.gridx = 1;
		gbc_btnConnect.gridy = 2;
		getContentPane().add(btnConnect, gbc_btnConnect);
		
	}

	public class CreateConnectionAction extends AbstractAction {

		public CreateConnectionAction() {
			super("connect");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ConnectionData data = new ConnectionData(textField.getText(), Integer.parseInt(textField_1.getText()));
			ControllerImpl.getInstance().fire(new ModelEvent(ModelEventId.CREATE_NEW_BOT_CONNECTION,data));
		}
		
	}
	
}
