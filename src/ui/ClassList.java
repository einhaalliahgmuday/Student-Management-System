package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableCellRenderer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ClassList extends JFrame implements ActionListener{

    private JPanel panel1, panel2;
    private JLabel cListLbl, yearLbl, semLbl;
    private JComboBox year, sem;
    private JButton viewBtn, FLoadBtn, GSystemBtn;
    private JTable table;
    private JScrollPane pane;
    private TableColumnModel column;

    public ClassList()
    {
setTitle("Student Management System");
	setSize(1050, 650);
	setLayout(null);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	cListLbl = new JLabel("Class List");
	cListLbl.setBounds(440, 10, 250, 50);
	cListLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
	cListLbl.setForeground(new Color(255, 255, 255));
		
	yearLbl = new JLabel("School Year");
	yearLbl.setBounds(185, 80, 140, 30);
	yearLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
	yearLbl.setForeground(new Color(255, 255, 255));
		
	semLbl = new JLabel("Semester");
	semLbl.setBounds(450, 80, 140, 30);
	semLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
	semLbl.setForeground(new Color(255, 255, 255));
		
        year = new JComboBox();
String[] yearChoices = {"2020","2021","2022","2023"};
JComboBox year = new JComboBox(yearChoices);
year.setBounds(325, 81, 60, 30);
year.setFont(new Font("Tahoma", Font.BOLD, 12));

sem = new JComboBox();
String[] semChoices = {"First","Second"};
JComboBox sem = new JComboBox(semChoices);
sem.setBounds(560, 81, 70, 30);
sem.setFont(new Font("Tahoma", Font.BOLD, 12));

                //Buttons
viewBtn = new JButton("View");
viewBtn.setBounds(700, 80, 250, 30);
		viewBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
FLoadBtn = new JButton("Faculty Load >");
FLoadBtn.setBounds(905, 15, 120, 30);
FLoadBtn.addActionListener(this);

GSystemBtn = new JButton("< Grading System");
GSystemBtn.setBounds(10, 15, 135, 30);
GSystemBtn.addActionListener(this);

		panel1 = new JPanel();
		panel1.setBounds(0, 0, 1050, 150);
		panel1.setLayout(null);
		panel1.setBackground(new Color(187, 37, 61));
		panel1.add(cListLbl);
		panel1.add(yearLbl);
		panel1.add(semLbl);
                panel1.add(year);
                panel1.add(sem);
                panel1.add(viewBtn);
                panel1.add(FLoadBtn);
                panel1.add(GSystemBtn);

                //TABLE DATA
                String data[][] = {
                {"1","DICT 2-1","COMP 40013","Object Oriented Programming","M/M 10:00AM-1:00PM/1:30PM-3:30PM","6"},
                {"2","BST 2-1","COMP 40013","Object Oriented Programming","SAT/SAT 8:0AM-12:00PM/2:00AM-7:00PM","6"}
                };
                
                String column[] = {"#","Section","Section Code","Subject Description","Schedule","         "};
                
                //TABLE PROPERTIES
                table = new JTable(data, column);
                table.setGridColor(Color.gray);
                table.setFont(new Font("Tahoma", Font.PLAIN, 13));
                table.setAutoCreateRowSorter(false);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                
                //SET ROW & COLUMN SIZE
                table.getColumnModel().getColumn(0).setPreferredWidth(30);
                table.getColumnModel().getColumn(1).setPreferredWidth(80);
                table.getColumnModel().getColumn(2).setPreferredWidth(90);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                table.getColumnModel().getColumn(4).setPreferredWidth(400);
                table.getColumnModel().getColumn(5).setPreferredWidth(100);
                table.setRowHeight(100);
                
                pane = new JScrollPane(table);
                pane.setPreferredSize(new Dimension(900, 240));
                
                //DATA SET CENTER ALIGNMENT
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
                table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
                table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
                table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
                table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
                
//                table.getColumn(2).setHeaderValue("<html><b>Section</b>");

                panel2 = new JPanel();
                panel2.setBounds(0, 150, 1050, 500);
//		panel2.setLayout(null);
		panel2.setBackground(new Color(245, 225, 187));
                panel2.add(pane, BorderLayout.CENTER);

                add(panel2);
                add(panel1);
setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
dispose();
        if(e.getSource() == GSystemBtn)
        {
            GradingSystem gSystem = new GradingSystem();
            gSystem.setVisible(true);
        }
        else if(e.getSource() == FLoadBtn)
        {
            FacultyLoad fLoad = new FacultyLoad();
            fLoad.setVisible(true);
        }
    }
}
