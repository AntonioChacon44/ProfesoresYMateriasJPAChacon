package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.AsignaturaController;
import controller.AsignaturaPorDocenteController;
import controller.DocenteController;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ventana_principal {

	private JFrame frame;
	private JTextField jtfFiltrar;
	private JButton btnFiltrar;
	private JComboBox<Docente> jcbDocente;
	private JButton btnCargarMaterias;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPaneIzq;
	private JScrollPane scrollPaneDer;
	private JButton btnGuardar;
	private JPanel panel_1;
	private JButton btnIzqTodo;
	private JButton btnIzq;
	private JButton btnDer;
	private JButton btnDerTodo;
	
	private JList jlistaAsignaturasIzq;
	private JList jlistaAsignaturasDer;
	private DefaultListModel<Asignatura> modelListAsignaturasIzq;
	private DefaultListModel<Asignatura> modelListAsignaturasDer;
	private List<Asignatura> asignaturas = AsignaturaController.findAllAsignaturas();
	private List<Asignatura> listaProvisional = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_principal window = new Ventana_principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 511, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0};
////		gridBagLayout.columnWidths = new int[]{0, 0};
////		gridBagLayout.rowHeights = new int[]{0, 0};
////		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
////		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jtfFiltrar = new JTextField();
		jtfFiltrar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_jtfFiltrar = new GridBagConstraints();
		gbc_jtfFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltrar.gridx = 0;
		gbc_jtfFiltrar.gridy = 1;
		frame.getContentPane().add(jtfFiltrar, gbc_jtfFiltrar);
		jtfFiltrar.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarDocentes();
			}
		});
		btnFiltrar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 1;
		frame.getContentPane().add(btnFiltrar, gbc_btnFiltrar);
		
		jcbDocente = new JComboBox<Docente>();
		jcbDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jcbDocente.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_jcbDocente = new GridBagConstraints();
		gbc_jcbDocente.insets = new Insets(0, 0, 5, 5);
		gbc_jcbDocente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDocente.gridx = 0;
		gbc_jcbDocente.gridy = 2;
		frame.getContentPane().add(jcbDocente, gbc_jcbDocente);
		
		btnCargarMaterias = new JButton("Cargar materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAsignaturasPorDocente();
			}
		});
		btnCargarMaterias.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnCargarMaterias = new GridBagConstraints();
		gbc_btnCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarMaterias.gridx = 1;
		gbc_btnCargarMaterias.gridy = 2;
		frame.getContentPane().add(btnCargarMaterias, gbc_btnCargarMaterias);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel_1 = new JLabel("Asignaturas no seleccionadas");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Asignaturas seleccionadas");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jlistaAsignaturasIzq = new JList(this.getDefaultListModelIzq());

		this.jlistaAsignaturasIzq.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		scrollPaneIzq = new JScrollPane(jlistaAsignaturasIzq);
		GridBagConstraints gbc_scrollPaneIzq = new GridBagConstraints();
		gbc_scrollPaneIzq.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneIzq.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneIzq.gridx = 0;
		gbc_scrollPaneIzq.gridy = 1;
		panel.add(scrollPaneIzq, gbc_scrollPaneIzq);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.columnWidths = new int[]{0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0};
//		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnIzqTodo = new JButton(">>");
		btnIzqTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoIzq();
			}
		});
		btnIzqTodo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnIzqTodo = new GridBagConstraints();
		gbc_btnIzqTodo.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzqTodo.gridx = 0;
		gbc_btnIzqTodo.gridy = 0;
		panel_1.add(btnIzqTodo, gbc_btnIzqTodo);
		
		btnIzq = new JButton(">");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarIzq();
			}
		});
		btnIzq.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnIzq = new GridBagConstraints();
		gbc_btnIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzq.gridx = 0;
		gbc_btnIzq.gridy = 1;
		panel_1.add(btnIzq, gbc_btnIzq);
		
		btnDer = new JButton("<");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarDer();
			}
		});
		btnDer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnDer = new GridBagConstraints();
		gbc_btnDer.insets = new Insets(0, 0, 5, 0);
		gbc_btnDer.gridx = 0;
		gbc_btnDer.gridy = 2;
		panel_1.add(btnDer, gbc_btnDer);
		
		btnDerTodo = new JButton("<<");
		btnDerTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoDer();
			}
		});
		btnDerTodo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnDerTodo = new GridBagConstraints();
		gbc_btnDerTodo.gridx = 0;
		gbc_btnDerTodo.gridy = 3;
		panel_1.add(btnDerTodo, gbc_btnDerTodo);
		
		jlistaAsignaturasDer = new JList(this.getDefaultListModelDer());

		this.jlistaAsignaturasDer.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		scrollPaneDer = new JScrollPane(jlistaAsignaturasDer);
		GridBagConstraints gbc_scrollPaneDer = new GridBagConstraints();
		gbc_scrollPaneDer.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneDer.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDer.gridx = 2;
		gbc_scrollPaneDer.gridy = 1;
		panel.add(scrollPaneDer, gbc_scrollPaneDer);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);
	}
	
	private void llenarDocentes () {
		try {
			jcbDocente.removeAllItems();
		} catch (Exception e) {
		}
		for (Docente m : DocenteController.findByNombre(jtfFiltrar.getText())) {
			jcbDocente.addItem(m);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelIzq () {
		this.modelListAsignaturasIzq = new DefaultListModel<Asignatura>();
		return this.modelListAsignaturasIzq;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelDer () {
		this.modelListAsignaturasDer = new DefaultListModel<Asignatura>();
		return this.modelListAsignaturasDer;
	}
	
	/**
	 * 
	 */
	private void cargarAsignaturasPorDocente () {
		
		modelListAsignaturasDer.removeAllElements();
		modelListAsignaturasIzq.removeAllElements();
		List<Asignaturaspordocente> listaPorDocente = AsignaturaPorDocenteController.findByIdDocente((Docente) jcbDocente.getSelectedItem());
		System.out.println(listaPorDocente);

		
	}
	
	/**
	 * 
	 */
	private void pasarTodoIzq () {
		modelListAsignaturasDer.removeAllElements();
		modelListAsignaturasIzq.removeAllElements();
		modelListAsignaturasIzq.addAll(asignaturas);
	}
	
	/**
	 * 
	 */
	private void pasarTodoDer () {
		modelListAsignaturasIzq.removeAllElements();
		modelListAsignaturasDer.removeAllElements();
		modelListAsignaturasDer.addAll(asignaturas);
	}
	
	/**
	 * 
	 */
	private void pasarIzq () {
		modelListAsignaturasIzq.addAll(jlistaAsignaturasDer.getSelectedValuesList());
		for (int i = this.jlistaAsignaturasDer.getSelectedIndices().length - 1; i >= 0; i--) {
			this.modelListAsignaturasDer.removeElementAt(this.jlistaAsignaturasDer.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void pasarDer () {
		modelListAsignaturasDer.addAll(jlistaAsignaturasIzq.getSelectedValuesList());
		for (int i = this.jlistaAsignaturasIzq.getSelectedIndices().length - 1; i >= 0; i--) {
			this.modelListAsignaturasIzq.removeElementAt(this.jlistaAsignaturasIzq.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void guardar () {
		listaProvisional.removeAll(listaProvisional);
		for (int i = 0; i < modelListAsignaturasDer.size(); i++) {
			listaProvisional.add(modelListAsignaturasDer.getElementAt(i));
		}
		for (Asignatura e : listaProvisional) {
			Asignaturaspordocente v = AsignaturaPorDocenteController.findBySomeId((Docente) jcbDocente.getSelectedItem(), e);
			
			if (v != null) {
				v.setAsignatura(e);
				
				AsignaturaPorDocenteController.insert(v);
				System.out.println("Se ha insertado correctamente");
			} else {
				
			}
			
				
			
		}
	}

}
