package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.Test;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneCenter;
	private JPanel panelSouth;
	private JButton btnStart;
	private JButton btnStop;
	private JTextArea textArea;
	private GUIKontorler guiKontr;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(GUIKontorler guiKontr) {
		this.guiKontr=guiKontr;
		setTitle("Because the Night");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPaneCenter(), BorderLayout.CENTER);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
	}

	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setViewportView(getTextArea());
		}
		return scrollPaneCenter;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setPreferredSize(new Dimension(100, 50));
			panelSouth.setLayout(null);
			panelSouth.add(getBtnStart());
			panelSouth.add(getBtnStop());
		}
		return panelSouth;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiKontr.inicijalizujThreds(textArea);
					guiKontr.startThreads();
				}
			});
			btnStart.setBounds(65, 12, 117, 25);
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guiKontr.stopThreads();
				}
			});
			btnStop.setBounds(233, 12, 117, 25);
		}
		return btnStop;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
