package V;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import M.EmpolyeeDB;
import M.EmpolyeeManager;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;


public class Employee extends JFrame
{

	private JPanel contentPane;
	private JTextField employeeID;
	private JTextField Salary;
	private JTextField SalaryTo;
	private JTable table;
	private JComboBox Department;
	private JDateChooser HireDateFrom;
	private JDateChooser HireDateTo;
	private JButton btnSearch;
	private JButton btnClear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(
							UIManager.getSystemLookAndFeelClassName());
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employee()
	{
		setTitle("HR : Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 704);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBounds(10, 22, 187, 31);
		panel_1.setBorder(new LineBorder(new Color(100, 149, 237), 2)); 
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Search Employees ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 47, 791, 225);
		panel.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(109, 31, 46, 14);
		panel.add(lblId);
		
		JLabel lblDepartment = new JLabel("Department ");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartment.setBounds(66, 65, 96, 14);
		panel.add(lblDepartment);
		
		JLabel lblHireDate = new JLabel("Hire Date");
		lblHireDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireDate.setBounds(70, 103, 92, 14);
		panel.add(lblHireDate);
		
		JLabel label = new JLabel("-");
		label.setBounds(338, 105, 46, 14);
		panel.add(label);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setBounds(66, 143, 96, 14);
		panel.add(lblSalary);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(338, 145, 46, 14);
		panel.add(label_1);
		
		employeeID = new JTextField();
		employeeID.setBounds(206, 30, 86, 20);
		employeeID.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(employeeID);
		employeeID.setColumns(10);
		
		Department = new JComboBox();
		Department.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240", "250", "260", "270"}));
		Department.setBounds(206, 64, 86, 20);
		Department.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(Department);
		
		HireDateFrom = new JDateChooser();
		HireDateFrom.setBounds(206, 97, 103, 20);
		HireDateFrom.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(HireDateFrom);
		
		HireDateTo = new JDateChooser();
		HireDateTo.setBounds(370, 97, 110, 20);
		HireDateTo.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(HireDateTo);
		
		Salary = new JTextField();
		Salary.setBounds(206, 142, 86, 20);
		Salary.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(Salary);
		Salary.setColumns(10);
		
		SalaryTo = new JTextField();
		SalaryTo.setBounds(370, 142, 86, 20);
		SalaryTo.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(SalaryTo);
		SalaryTo.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
				employeeID.setText("");
				Department.setSelectedItem("0");
				HireDateFrom.setDateFormatString("");
				Salary.setText("");
				SalaryTo.setText("");
			}
		});
		btnSearch.setBounds(220, 191, 89, 23);
		btnSearch.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(btnSearch);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeID.setText("");
				Department.setSelectedItem("");
				HireDateFrom.setDateFormatString("");
				Salary.setText("");
				SalaryTo.setText("");
				
				load();
			}
		});
		btnClear.setBounds(367, 191, 89, 23);
		btnClear.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 295, 791, 342);
		scrollPane.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnClear.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		load();
	}
	ArrayList<EmpolyeeDB> list;

	public void load()
	{
		list = EmpolyeeManager.getAllEmpolyee();
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("EMPLOYEE_ID");
		model.addColumn("FIRST_NAME");
		model.addColumn("EMAIL");
		model.addColumn("DEPARTMENT_NAME");
		model.addColumn("SALARY");
		/**model.addColumn("HIRE_DATE");
		model.addColumn("DEPARTMENT_ID");**/
		//, c.HIRE_DATE, c.DEPARTMENT_ID 
		for (EmpolyeeDB c : list)
		{
			model.addRow(new Object[]
			{ c.EMPLOYEE_ID, c.FIRST_NAME, c.EMAIL, c.DEPARTMENT_NAME, c.SALARY });
		}
		
		table.setModel(model);
	}
	public void search()
	{
		list = EmpolyeeManager.searchEmpolyee(employeeID.getText(),Salary.getText(),SalaryTo.getText(),
				(String)Department.getSelectedItem());
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("EMPLOYEE_ID");
		model.addColumn("FIRST_NAME");
		model.addColumn("EMAIL");
		model.addColumn("DEPARTMENT_NAME");
		model.addColumn("SALARY");

		for (EmpolyeeDB c : list)
		{
			model.addRow(new Object[]
			{ c.EMPLOYEE_ID, c.FIRST_NAME, c.EMAIL, c.DEPARTMENT_NAME, c.SALARY });
		}
		
		table.setModel(model);
		
		
	}
	
}

