package ch.zsg.reservation.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import ch.zsg.reservation.controller.ReservationSystem;
import ch.zsg.reservation.managers.KundenManager;
import ch.zsg.reservation.model.Kunde;
import javax.swing.border.BevelBorder;

public class View extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReservationSystem controller;
	private JTextField name, telefon, adresse, plz, ort;
	private JComboBox comboFahrt, comboKunde;
	private JButton save = new JButton("Save"), clear = new JButton("Clear");
	private JSpinner spinnerTisch, spinnerMitnahme;
	private final JList list = new JList();
	private final JList reservationen = new JList();
	private final ButtonGroup klasse = new ButtonGroup();
	private JRadioButton rdbtnErste;

	public View(ReservationSystem controller) {
		this.controller = controller;

		getContentPane().setLayout(null);


		// Tab Structure
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setLocation(6, 6);
		tabbedPane.setSize(560, 480);

		JLayeredPane kundenPanel = new JLayeredPane();
		JLayeredPane reservationsPanel = new JLayeredPane();

		tabbedPane.addTab("Reservierungen", null, reservationsPanel, null);
		tabbedPane.addTab("Kunden verwalten", null, kundenPanel, null);
		getContentPane().add(tabbedPane);


		// Reservation Tab Layout
		reservationsPanel.setLayout(new GridLayout(2, 1, 5, 5));
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		topPanel.setLayout(new GridLayout(6, 2, 5, 5));
		JLabel label_3 = new JLabel("Reservation für");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		topPanel.add(label_3);
		reservationsPanel.add(topPanel);

		comboFahrt = new JComboBox();
		topPanel.add(comboFahrt);

		JLabel lblNewLabel = new JLabel("Kunde");
		topPanel.add(lblNewLabel);

		comboKunde = new JComboBox();
		topPanel.add(comboKunde);

		JLabel lblTischpltze = new JLabel("TischPl\u00E4tze");
		topPanel.add(lblTischpltze);

		spinnerTisch = new JSpinner();
		topPanel.add(spinnerTisch);

		JLabel lblKlasse = new JLabel("Mitfahrpl\u00E4tze");
		topPanel.add(lblKlasse);

		spinnerMitnahme = new JSpinner();
		topPanel.add(spinnerMitnahme);

		JLabel lblKlasse_1 = new JLabel("Klasse");
		topPanel.add(lblKlasse_1);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		topPanel.add(panel);

		rdbtnErste = new JRadioButton("Erste");
		klasse.add(rdbtnErste);
		panel.add(rdbtnErste);

		JRadioButton rdbtnZweite = new JRadioButton("Zweite");
		rdbtnZweite.setSelected(true);
		klasse.add(rdbtnZweite);
		panel.add(rdbtnZweite);

		JButton btnClear = new JButton("Zur\u00FCcksetzten");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View.this.resetBtnClick();
			}
		});
		topPanel.add(btnClear);

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View.this.reserveBtnClick();
			}
		});
		topPanel.add(btnSpeichern);
		reservationsPanel.add(bottomPanel);
		bottomPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 567, 200);
		bottomPanel.add(scrollPane);
		reservationen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(reservationen);
		reservationen.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		reservationen.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		kundenPanel.setSize(400, 400);
		kundenPanel.setLayout(null);
		JLabel label = new JLabel("Name");
		label.setBounds(216, 7, 142, 28);
		kundenPanel.add(label);
		JLabel label_1 = new JLabel("Telefon");
		label_1.setBounds(216, 47, 142, 21);
		kundenPanel.add(label_1);
		JLabel label_2 = new JLabel("Adresse");
		label_2.setBounds(216, 80, 142, 28);
		kundenPanel.add(label_2);
		clear.setBounds(216, 160, 142, 28);
		kundenPanel.add(clear);
		save.setBounds(389, 160, 142, 28);
		kundenPanel.add(save);
		list.setBounds(6, 6, 198, 417);
		kundenPanel.add(list);

		// Tab Kunde Listener
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int index = list.locationToIndex(e.getPoint());
					if (index == 0) {
						View.this.clearBtnClick();
					} else {
						View.this.showKunde(index-1);
					}
				}
			}
		});

		// Create Kunde List
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);

		JLabel lblPlzOrt = new JLabel("PLZ / Ort");
		lblPlzOrt.setBounds(216, 120, 61, 28);
		kundenPanel.add(lblPlzOrt);

		name = new JTextField();
		name.setBounds(397, 12, 134, 28);
		kundenPanel.add(name);
		name.setColumns(10);

		telefon = new JTextField();
		telefon.setBounds(397, 43, 134, 28);
		kundenPanel.add(telefon);
		telefon.setColumns(10);

		adresse = new JTextField();
		adresse.setBounds(397, 80, 134, 28);
		kundenPanel.add(adresse);
		adresse.setColumns(10);

		plz = new JTextField();
		plz.setBounds(324, 120, 61, 28);
		kundenPanel.add(plz);
		plz.setColumns(10);

		ort = new JTextField();
		ort.setBounds(397, 120, 134, 28);
		kundenPanel.add(ort);
		ort.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("History", null, layeredPane, null);
		
		JList historyList = new JList();
		historyList.setBounds(0, 0, 0, 0);
		layeredPane.add(historyList);
		historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				View.this.saveBtnClick();
			}
		});

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				View.this.clearBtnClick();
			}
		});
		this.updateKunden();
		this.fillFahrten();
		this.updateReservationen();
	}


	protected void resetBtnClick() {
		// TODO Implement me
	}


	private String[] buildList() {
		KundenManager KundenTemp = (KundenManager) controller.getKundenVerwaltung().clone();
		KundenTemp.add(0, controller.getKundenVerwaltung().getGeneric());
		return KundenTemp.getNames();
	}

	private void showKunde(int index) {
		Kunde active = controller.getKundenVerwaltung().get(index);
		name.setText(active.getName());
		adresse.setText(active.getAdresse().getStrasse());
		plz.setText(active.getAdresse().getPlz());
		ort.setText(active.getAdresse().getOrt());
		telefon.setText(active.getTelefon());
	}

	private void clearBtnClick() {
		name.setText("");
		adresse.setText("");
		telefon.setText("");
		ort.setText("");
		plz.setText("");
	}

	private void reserveBtnClick() {
		controller.getReservationsVerwaltung().create(
				controller.getReservierbareFahrtenVerwaltung().get(comboFahrt.getSelectedIndex()),
				controller.getKundenVerwaltung().get(comboKunde.getSelectedIndex()),
				(Integer)spinnerTisch.getValue(),
				(Integer)spinnerMitnahme.getValue(),
				(rdbtnErste.isSelected()) ? 1 : 2
		);
		this.updateReservationen();
	}

	private void saveBtnClick() {
		int index = list.getSelectedIndex();
		if (index == 0) {
			controller.getKundenVerwaltung().create(name.getText(), adresse.getText(), ort.getText(), plz.getText(), telefon.getText());
		} else {
			controller.getKundenVerwaltung().update(index-1, name.getText(), adresse.getText(), ort.getText(), plz.getText(), telefon.getText());
		}
		this.updateKunden();
	}

	private void updateKunden() {
		list.setListData(this.buildList());

		DefaultComboBoxModel cbModelKunden = new DefaultComboBoxModel(controller.getKundenVerwaltung().getNames());
		comboKunde.setModel(cbModelKunden);
	}

	private void updateReservationen() {
		reservationen.setListData(controller.getReservationsVerwaltung().getNames());
	}

	private void fillFahrten() {
		DefaultComboBoxModel cbModelFahrten = new DefaultComboBoxModel(controller.getReservierbareFahrtenVerwaltung().getNames());
		comboFahrt.setModel(cbModelFahrten);
	}
}
