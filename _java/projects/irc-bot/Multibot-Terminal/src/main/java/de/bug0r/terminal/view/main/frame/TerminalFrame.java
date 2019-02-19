package de.bug0r.terminal.view.main.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEvent;
import de.bug0r.terminal.controller.event.listener.impl.gui.GuiEventId;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEvent;
import de.bug0r.terminal.controller.event.listener.impl.model.ModelEventId;
import de.bug0r.terminal.controller.impl.ControllerImpl;

public class TerminalFrame extends JFrame {
	private JTextField textField;
	public TerminalFrame() {
		setTitle("Bug0r Bot Ctrl Deck");
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(640, 480));
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(100);
		getContentPane().add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_1.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(new PerofmCommandAction());
		panel_1.add(btnNewButton, BorderLayout.EAST);
		
		this.pack();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem(new OpenConDlgAction());
		mnFile.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		mnFile.add(mntmExit);
	}
	
	public class OpenConDlgAction extends AbstractAction {

		public OpenConDlgAction() {
			super("New Connection");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerImpl.getInstance().fire(new GuiEvent(GuiEventId.SHOW_NEW_CON_DLG, null));
		}
		
	}
	
	public class PerofmCommandAction extends AbstractAction {

		public PerofmCommandAction() {
			super("perform");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerImpl.getInstance().fire(new ModelEvent(ModelEventId.REQUEST_TO_SERVER, textField.getText() ));
		}
		
	}

}
