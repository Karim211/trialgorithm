package pack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import pack.Tri;


public class HomePanel {
	
	private JFrame frame;
	private JPanel panel;
	
	private JScrollPane scPaneB,scPaneA;
	private JTextPane txtpnB,txtpnA;
	
	private JLabel lblAB, lblAA;
	
	private JLabel lblTitle, lblTitlep2, lblCTri, lblCFA;
	private JLabel lblHpo, lblHpc, lblKeyFI, lblSA, lblExTi, lblET;
	
	private JTextField tfKeyFI, tfKeyH, tfSA;
	private JRadioButton rbtnTrInsert, rbtnTriFusion, rbtnTriBul, rbtnTriTas, rbtnTriFusionInsert;
	
	private JButton btnFA,btnTri;
	private JRadioButton rbtnFARand, rbtnFAIncreas, rbtnFADecreas, rbtnFAHand, rbtnI, rbtnD, rbtnR, rbtnL;
	private ButtonGroup btngTri, btngFA, btngID, btngRL;
	
	private ArrayList<Integer> tIinitial,tTrie;
	private boolean boolID=true, boolRL=true;
	private long t1,t2,te=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePanel window = new HomePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HomePanel() {
		initialize();
		personalize();
		addalize();
		functionalize();	
	}
	
	public void initialize() {
		frame = new JFrame();
		//***********************************Second panel*********************************
		panel = new JPanel();
		//***********************************ScrollPane+TextPane*********************************
		scPaneB = new JScrollPane();scPaneA = new JScrollPane();
		txtpnB = new JTextPane();txtpnA = new JTextPane();
		//***********************************Label*************************************
		lblTitle = new JLabel("Application of Tri Algorithm");
		lblAB = new JLabel("Array Before :");
		lblAA = new JLabel("Array After :");
		
		lblExTi = new JLabel("Execution Time : ");
		lblET = new JLabel(" ##  "+te+"  ## s");
		
		lblTitlep2 = new JLabel("Mode");
		lblCTri = new JLabel("Choose the Tri :");
		lblCFA = new JLabel("Choose Filling Array :");
		lblKeyFI = new JLabel("Key:") ;
		lblHpo = new JLabel("[");
		lblHpc = new JLabel("]");
		lblSA = new JLabel("Size Array:");
		//***********************************TextFileds**************************************
		tfKeyFI= new JTextField("20");
		tfKeyH= new JTextField();
		tfSA = new JTextField("100");
		//***********************************Button****************************************
		btnFA = new JButton("Fill Array");	
		btnTri = new JButton("Tri Array");
		//***********************************JRadioButton**************************************
		rbtnTrInsert = new JRadioButton("Tri Insertion (L)");
		rbtnTriFusion = new JRadioButton("Tri Fusion (R)");
		rbtnTriBul = new JRadioButton("Tri Bull");
		rbtnTriTas = new JRadioButton("Tri Tas");
		rbtnTriFusionInsert = new JRadioButton("Tri Fusion+Insertion (L/R)");
		btngTri = new ButtonGroup();
		
		rbtnFARand = new JRadioButton("Random");
		rbtnFAIncreas = new JRadioButton("Increasing");
		rbtnFADecreas = new JRadioButton("Decreasing");
		rbtnFAHand = new JRadioButton("With Hand");
		btngFA = new ButtonGroup();
		
		rbtnI = new JRadioButton("Increase");
		rbtnD = new JRadioButton("Decrease");
		btngID = new ButtonGroup();
		rbtnR = new JRadioButton("Recursif");
		rbtnL = new JRadioButton("Loop");
		btngRL = new ButtonGroup();
				
				
				
	}
	public void personalize() {
		frame.setTitle("Application of Tri Algorithm");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(150, 80, 1000, 640);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//***********************************Second panel*********************************
		panel.setBackground(new Color(153, 153, 153));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 220, 613);	
		//***********************************ScrollPane+TextPane*********************************
		txtpnB.setText("[A1,A2,A3]");
		scPaneB.setBounds(232, 100, 742, 215);
		txtpnB.setEnabled(false);
		scPaneA.setBounds(232, 354, 742, 215);
		txtpnA.setEnabled(false);
		//***********************************Label*************************************
		lblAB.setBounds(240, 80, 150, 15);
		lblAA.setBounds(240, 335, 150, 15);
		lblET.setBounds(750, 450, 200, 15);
		lblExTi.setBounds(700, 328, 300, 15);
		
		
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitle.setBounds(500, 27, 385, 15);
		lblTitlep2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitlep2.setBounds(80, 30, 50, 15);
		lblCTri.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCTri.setBounds(30, 240, 140, 15);
		lblKeyFI.setBounds(30, 360, 50, 15);
		lblHpo.setFont(new Font("Dialog", Font.BOLD, 18));
		
		lblCFA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCFA.setBounds(20, 80, 200, 15);
		lblSA.setBounds(20, 100, 100, 20);
		lblHpo.setBounds(5, 200, 10, 20);
		lblHpc.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHpc.setBounds(200, 200, 10, 20);
		//***********************************TextFileds**************************************
		tfSA.setBounds(100, 100, 60, 18);
		tfKeyH.setBounds(15, 200, 182, 20);
		tfKeyFI.setBounds(65, 360, 40, 17);
		
		//***********************************Button****************************************
		btnFA.setBackground(new Color(153, 153, 153));
		btnFA.setBounds(380, 322, 100, 25);
		btnTri.setBackground(new Color(153, 153, 153));
		btnTri.setBounds(530, 322, 100, 25);
		//***********************************JRadioButton**************************************
		rbtnFARand.setBackground(new Color(153, 153, 153));
		rbtnFARand.setSelected(true);
		tfKeyH.setEnabled(false);tfSA.setEditable(true);// --------------------------Begin Choose
		rbtnFARand.setBounds(8, 120, 100, 20);
		rbtnFAIncreas.setBackground(new Color(153, 153, 153));
		rbtnFAIncreas.setBounds(8, 140, 100, 20);
		rbtnFADecreas.setBackground(new Color(153, 153, 153));
		rbtnFADecreas.setBounds(8, 160, 120, 20);
		rbtnFAHand.setBackground(new Color(153, 153, 153));
		rbtnFAHand.setBounds(8, 180, 100, 20);
		
		rbtnTriBul.setBackground(new Color(153, 153, 153));
		rbtnTriBul.setSelected(true);
		tfKeyFI.setEnabled(false);						//-------------------------------Begin Choose
		rbtnTriBul.setBounds(8, 260, 157, 20);
		rbtnTrInsert.setBackground(new Color(153, 153, 153));
		rbtnTrInsert.setBounds(8, 300, 144, 20);
		rbtnTriFusion.setBounds(8, 280, 157, 20);
		rbtnTriFusion.setBackground(new Color(153, 153, 153));
		rbtnTriTas.setBounds(8, 320, 157, 20);
		rbtnTriTas.setBackground(new Color(153, 153, 153));
		rbtnTriFusionInsert.setBackground(new Color(153, 153, 153));
		rbtnTriFusionInsert.setBounds(8, 340, 200, 20);
		
		rbtnI.setBackground(new Color(153, 153, 153));
		rbtnI.setSelected(true);
		rbtnI.setBounds(10, 390, 90, 20);
		rbtnD.setBackground(new Color(153, 153, 153));
		rbtnD.setBounds(10, 410, 90, 20);
		rbtnR.setBackground(new Color(153, 153, 153));
		rbtnR.setBounds(100, 390, 80, 20);
		rbtnR.setSelected(true);
		rbtnL.setBackground(new Color(153, 153, 153));
		rbtnL.setBounds(100, 410, 80, 20);
		
	}
	public void addalize() {
		frame.getContentPane().setLayout(null);
		//***********************************Second panel*********************************
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		//***********************************ScrollPane+TextPane*********************************
		frame.getContentPane().add(scPaneB);
		frame.getContentPane().add(scPaneA);
		scPaneB.setViewportView(txtpnB);scPaneA.setViewportView(txtpnA);
		//***********************************Label*************************************
		frame.getContentPane().add(lblAB);frame.getContentPane().add(lblAA);
		frame.getContentPane().add(lblET);
		frame.getContentPane().add(lblExTi);
		
		
		frame.getContentPane().add(lblTitle);
		panel.add(lblTitlep2);
		panel.add(lblCTri);
		panel.add(lblKeyFI);
		panel.add(lblCFA);
		panel.add(lblSA);
		panel.add(lblHpo);
		panel.add(lblHpc);
		//***********************************TextFileds**************************************
		panel.add(tfKeyFI);panel.add(tfSA);panel.add(tfKeyH);
		//***********************************Button****************************************
		frame.getContentPane().add(btnFA);
		frame.getContentPane().add(btnTri);	
		//***********************************JRadioButton**************************************
		panel.add(rbtnFARand);
		panel.add(rbtnFAIncreas);
		panel.add(rbtnFADecreas);
		panel.add(rbtnFAHand);
		btngFA.add(rbtnFARand);
		btngFA.add(rbtnFAIncreas);
		btngFA.add(rbtnFADecreas);
		btngFA.add(rbtnFAHand);
		
		
		panel.add(rbtnTrInsert);
		panel.add(rbtnTriFusion);
		panel.add(rbtnTriBul);
		panel.add(rbtnTriFusionInsert);
		panel.add(rbtnTriTas);
		
		btngTri.add(rbtnTrInsert);
		btngTri.add(rbtnTriFusion);
		btngTri.add(rbtnTriBul);
		btngTri.add(rbtnTriTas);
		btngTri.add(rbtnTriFusionInsert);
		
		panel.add(rbtnI);
		panel.add(rbtnD);
		btngID.add(rbtnI);
		btngID.add(rbtnD);
		panel.add(rbtnR);
		panel.add(rbtnL);
		btngRL.add(rbtnR);
		btngRL.add(rbtnL);
	
	}
	public void functionalize() {

		btnFA.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					tIinitial = new ArrayList<Integer>();
					int x = Integer.parseInt(tfSA.getText());
					
					if (rbtnFARand.isSelected()) {
						for(int i=0;i<=x;i++) {
							tIinitial.add((int)(Math.random()*100));
						}
					}else if (rbtnFAIncreas.isSelected()) {
						for(int i=0;i<x;i++) {
							tIinitial.add(i);
						}
					}else if (rbtnFADecreas.isSelected()) {
						for(int i=0;i<=x;i++) {
							tIinitial.add(-i);
						}
					}else {
						String tab = new String(tfKeyH.getText());
						int i=0,n;
						String c="";
						while(tab.charAt(i)!=';') {
							while (tab.charAt(i)!=',') {
								c=c+tab.charAt(i);i++;	
							}
							//System.out.println("1_t["+i+"]"+t.get(i)+"tab[]:"+tab.charAt(i));
							n=Integer.parseInt(c);
							tIinitial.add(n);
							//System.out.println("2_t["+i+"]"+t.get(i)+"tab[]:"+tab.charAt(i));
						}
					}
					txtpnB.setText(tIinitial.toString());
					System.out.println(" x="+x);			
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
		});
		
		btnTri.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					tTrie = (ArrayList<Integer>) tIinitial.clone();
					System.out.println(tTrie.toString());
					t1=System.nanoTime();//currentTimeMillis();
					if (rbtnTriBul.isSelected()) {
						Tri.Tri_Bull(tTrie,boolRL, boolID);
					}else if (rbtnTriFusion.isSelected()) {
						Tri.Tri_Fusion(tTrie, boolID) ;
					}else if (rbtnTrInsert.isSelected()) {
						Tri.Tri_Insertion(tTrie, boolID);
					}else if (rbtnTriTas.isSelected()) {
						Tri.Tri_Tas(tTrie, boolID);
					}else{
						Tri.Tri_Fusion_Insertion(tTrie, boolID, Integer.parseInt(tfKeyFI.getText()));
					}
					t2=System.nanoTime();//currentTimeMillis();
					te=t2-t1;
					lblExTi.setForeground(Color.RED);   //setForeground(Color.DARK_GRAY);
					lblExTi.setText("Execution Time : ##  "+te/1000+" Ms ##");// = new JLabel("Execution Time : "+te);
					//lblET.setText("Execution Time : ##  "+te+"  ##");
					 
					txtpnA.setText(tTrie.toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
		});
	
		
		
		//----------------------------------RADIO BUTTON FUNCTION FILLING ARRAY---------------------------------------------
		
		rbtnFARand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyH.setEnabled(false);tfSA.setEditable(true);
				}
		});
		rbtnFAIncreas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyH.setEnabled(false);tfSA.setEditable(true);
				}
		});
		rbtnFADecreas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyH.setEnabled(false);tfSA.setEditable(true);
				}
		});
		rbtnFAHand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyH.setEnabled(true);tfSA.setEditable(false);
				}
		});
		
		//----------------------------------RADIO BUTTON FUNCTION TRI---------------------------------------------
		
		rbtnTriBul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyFI.setEnabled(false);
				rbtnR.setEnabled(true);rbtnL.setEnabled(true);
				}
			});
		rbtnTrInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyFI.setEnabled(false);
				rbtnL.setSelected(true);
				rbtnR.setEnabled(false);rbtnL.setEnabled(false);
				}
		});
		rbtnTriFusion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyFI.setEnabled(false);
				rbtnR.setSelected(true);
				rbtnR.setEnabled(false);rbtnL.setEnabled(false);
				}
		});
		rbtnTriTas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyFI.setEnabled(false);
				rbtnR.setSelected(true);
				rbtnR.setEnabled(false);rbtnL.setEnabled(false);
				}
		});
		rbtnTriFusionInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tfKeyFI.setEnabled(true);
				rbtnR.setSelected(true);
				rbtnR.setEnabled(false);rbtnL.setEnabled(false);
				}
		});
		
		rbtnI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolID=true;
				
			}
		});
		rbtnD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolID=false;
			}
		});
		rbtnR.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolRL=true;
			}
		});
		rbtnL.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolRL=false;
			}
		});


	}
    
	public void setTxtpnB(JTextPane txtpnB) {
		this.txtpnB = txtpnB;
	}
	public void setTxtpnA(JTextPane txtpnA) {
		this.txtpnA = txtpnA;
	}
}
