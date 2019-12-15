package Tennis;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Bracket extends Main{

	public static ArrayList<TennisPlayers> players = new ArrayList<TennisPlayers>();
	public static ArrayList<TennisPlayers> round2 = new ArrayList<TennisPlayers>();
	public static ArrayList<TennisPlayers> round3 = new ArrayList<TennisPlayers>();
	public static ArrayList<TennisPlayers> round4 = new ArrayList<TennisPlayers>();
	public static ArrayList<TennisPlayers> round5 = new ArrayList<TennisPlayers>();


	static boolean ttype = false;
	private JFrame frame;
	private static int counter = 0, count1 = 0;
	private int check = 0, check2 = 0, check3 = 0;

	/**
	 * Launch the application.
	 */
	
	public void getPlayers() {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		String pathname = "list.txt";
	    File file = new File(pathname);
		 try
		    {
		       
			 input = new Scanner(file);   
		    
		     while(input.hasNext()) {
		    	 	String fName = input.next();
					String lName = input.next();
					String name = fName + " "+ lName;
					String state = input.next();
					if(state.equals("South")||state.equals("United")||state.equals("Czech")) {
						state = state+ " "+input.next();
					}
					int age = input.nextInt();
					int points = input.nextInt();
					double percentage = input.nextDouble();
					TennisPlayers player = new TennisPlayers();
					player.setName(name);
					player.setState(state);
					player.setAge(age);
					player.setPoints(points);
					player.setPercentage(percentage);
					
					players.add(player);
					
		    	 }
		    	
					
		    }
		     catch (FileNotFoundException ex)
	 		    {
	 		        System.out.println("*** Cannot open " + pathname + " ***");
	 		        System.exit(1);  // quit the program
	 		    } 
		    
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bracket setup = new Bracket(1);
					//setup.frame.setVisible(true);
					
					Bracket window = new Bracket(2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Bracket(int n) {
		
			
		
//			JFrame frame = new JFrame("Tournament Picker");
//		    frame.setVisible(true);
//			frame.getContentPane().setBackground(Color.WHITE);
//		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setSize(500, 500);
//		    frame.setLocation(430, 100);
//
//		    JPanel panel = new JPanel();
//
//		    frame.add(panel);
//
//		    JLabel lbl = new JLabel("Select a tournament type");
//		    lbl.setVisible(true);
//		    panel.add(lbl);
//
//		    String[] choices1 = {"-----", "Grand Slam","Master 1000", "ATP Finals"};
//
//		    final JComboBox<String> cb1 = new JComboBox<String>(choices1);
//
//		    cb1.setVisible(true);
//		    panel.add(cb1);
//            String type = (String)cb1.getSelectedItem();
//
//		    JButton btn1 = new JButton("OK");
//		    panel.add(btn1);
//	        while(ttype == false) {	
//
//		    btn1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					 ttype = true;
//				}
//			});
//        }
//		   
//		if(ttype) {
//			if(type.equals("Grand Slam")) {
//		    String[] choices2 = {"-----", "French Open","US Open", "Wimbeldon","Australia Open"};
//
//		    final JComboBox<String> cb2 = new JComboBox<String>(choices2);
//
//		    cb2.setVisible(true);
//		    panel.add(cb2);
//		    String type1 = (String)cb1.getSelectedItem();
//		    
//		    JButton btn = new JButton("OK");
//		    panel.add(btn);
//		    btn.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
//				}
//			});
//			
//		}
//
//		if(type.equals("Masters 1000")) {
//			String[] choices2 = {"-----", "Indian Wells","Miami Open", "Monte-Carlo","Madrid Open", "Cincinatti Master", "Shanghai Master"};
//
//		    final JComboBox<String> cb2 = new JComboBox<String>(choices2);
//
//		    cb2.setVisible(true);
//		    panel.add(cb2);
//		    String type2 = (String)cb1.getSelectedItem();
//
//		    
//		    JButton btn2 = new JButton("OK");
//		    panel.add(btn2);
//		    btn2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
//				}
//			});
//			}
//		
//		if(type.equals("Grand Slam")) {
//
//		}		
//		    }
//		
//	}
		if(n == 2) {
		getPlayers();
		execute();
		}
	}
	
	public void execute() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public boolean roundDone(int check) {
		if(check == 8) {
			return true;
		}
		return false;
	}
	
	public boolean round2Done(int check) {
		if(check == 4) {
			return true;
		}
		return false;
	}
	
	public boolean round3Done(int check) {
		if(check == 2) {
			return true;
		}
		return false;
	}
	
	private void initialize() {
		counter++;
	
		frame = new JFrame("French Open");
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
	if(counter >= 1) {
		
		if(counter == 1) {
			for(int i = 0; i < 16 ; i++) {
				round2.add(null);
			}
		}
		
		JButton btnNewButton = new JButton((players.get(13)).getName());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(2, players.get(13));
				if(roundDone(check)) {
					execute();
				}
				}
			}
		});
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 24;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_11 =  new JButton((players.get(0).getName()));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(0, players.get(0));
				if(roundDone(check)) {
					execute();
				}
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 0;
		gbc_btnNewButton_11.gridy = 10;
		frame.getContentPane().add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_15 =  new JButton((players.get(3).getName()));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(3, players.get(3));
				if(roundDone(check)) {
					execute();
				}
			
				}
				}
		});
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_15.gridx = 12;
		gbc_btnNewButton_15.gridy = 10;
		frame.getContentPane().add(btnNewButton_15, gbc_btnNewButton_15);
		
		JButton btnNewButton_2 =  new JButton((players.get(14).getName()));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(1, players.get(14));
				if(roundDone(check)) {
					execute();
				}
			
				}
				}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 12;
		gbc_btnNewButton_2.gridy = 24;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_10 = new JButton((players.get(15).getName()));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {	
				check++; 
				round2.set(0,players.get(15));
				if(roundDone(check)) {
					execute();
				}
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 12;
		frame.getContentPane().add(btnNewButton_10, gbc_btnNewButton_10);
		
		JButton btnNewButton_14 =  new JButton((players.get(12).getName()));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(3, players.get(12));
				if(roundDone(check)) {
					execute();
				}
				}
				}
		});
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_14.gridx = 12;
		gbc_btnNewButton_14.gridy = 12;
		frame.getContentPane().add(btnNewButton_14, gbc_btnNewButton_14);
		
		JButton btnNewButton_9 =  new JButton((players.get(7).getName()));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(7, players.get(7));
				if(roundDone(check)) {
					execute();
				}
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 0;
		gbc_btnNewButton_9.gridy = 14;
		frame.getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton_13 =  new JButton((players.get(6).getName()));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(6, players.get(6));
				if(roundDone(check)) {
					execute();
				}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_13.gridx = 12;
		gbc_btnNewButton_13.gridy = 14;
		frame.getContentPane().add(btnNewButton_13, gbc_btnNewButton_13);
		
		
		JButton btnNewButton_8 =  new JButton((players.get(8).getName()));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(7, players.get(8));
				if(roundDone(check)) {
					execute();
				}
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 16;
		frame.getContentPane().add(btnNewButton_8, gbc_btnNewButton_8);
		

		JButton btnNewButton_12 =  new JButton((players.get(9).getName()));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(6, players.get(9));
				if(roundDone(check)) {
					execute();
				}
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 12;
		gbc_btnNewButton_12.gridy = 16;
		frame.getContentPane().add(btnNewButton_12, gbc_btnNewButton_12);
		
		
		JButton btnNewButton_7 =  new JButton((players.get(4).getName()));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(4, players.get(4));
				}
				if(roundDone(check)) {
					execute();
				}
				}
			
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 18;
		frame.getContentPane().add(btnNewButton_7, gbc_btnNewButton_7);
		
		
		JButton btnNewButton_5 =  new JButton((players.get(5).getName()));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(5, players.get(5));
			}
				if(roundDone(check)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 12;
		gbc_btnNewButton_5.gridy = 18;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		JButton btnNewButton_6 =  new JButton((players.get(11).getName()));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(4, players.get(11));
				}
				if(roundDone(check)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 20;
		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		
		
		JButton btnNewButton_4 =  new JButton((players.get(10).getName()));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 1) {
				check++; 
				round2.set(5, players.get(10));
				}
				if(roundDone(check)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 12;
		gbc_btnNewButton_4.gridy = 20;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		
		JButton btnNewButton_1 =  new JButton((players.get(2).getName()));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter == 1) {	
				check++; 
				round2.set(2, players.get(2));
			}
			if(roundDone(check)) {
				execute();
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 22;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		JButton btnNewButton_3 =  new JButton((players.get(1).getName()));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter == 1) {
				check++; 
				round2.set(1, players.get(1));
			}
			if(roundDone(check)) {
				execute();
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 12;
		gbc_btnNewButton_3.gridy = 22;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		//*******************************************************************//
	if(counter < 2 ) {
		JButton btnNewButton_20 =  new JButton();
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				}
				
			}
		);
		
		JButton btnNewButton_30 = new JButton();
		btnNewButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_30 = new GridBagConstraints();
		gbc_btnNewButton_30.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_30.gridx = 1;
		gbc_btnNewButton_30.gridy = 11;
		frame.getContentPane().add(btnNewButton_30, gbc_btnNewButton_30);
		GridBagConstraints gbc_btnNewButton_20 = new GridBagConstraints();
		gbc_btnNewButton_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_20.gridx = 11;
		gbc_btnNewButton_20.gridy = 11;
		frame.getContentPane().add(btnNewButton_20, gbc_btnNewButton_20);
		
		JButton btnNewButton_17 =  new JButton();
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_17.gridx = 1;
		gbc_btnNewButton_17.gridy = 15;
		frame.getContentPane().add(btnNewButton_17, gbc_btnNewButton_17);
		
		JButton btnNewButton_21 =  new JButton();
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_21.gridx = 11;
		gbc_btnNewButton_21.gridy = 15;
		frame.getContentPane().add(btnNewButton_21, gbc_btnNewButton_21);
		
		JButton btnNewButton_18 =  new JButton();
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_18 = new GridBagConstraints();
		gbc_btnNewButton_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_18.gridx = 1;
		gbc_btnNewButton_18.gridy = 19;
		frame.getContentPane().add(btnNewButton_18, gbc_btnNewButton_18);
		
		JButton btnNewButton_22 =  new JButton();
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_22.gridx = 11;
		gbc_btnNewButton_22.gridy = 19;
		frame.getContentPane().add(btnNewButton_22, gbc_btnNewButton_22);
		
		JButton btnNewButton_19 =  new JButton();
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		GridBagConstraints gbc_btnNewButton_19 = new GridBagConstraints();
		gbc_btnNewButton_19.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_19.gridx = 1;
		gbc_btnNewButton_19.gridy = 23;
		frame.getContentPane().add(btnNewButton_19, gbc_btnNewButton_19);
		
		JButton btnNewButton_23 =  new JButton();
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_23.gridx = 11;
		gbc_btnNewButton_23.gridy = 23;
		frame.getContentPane().add(btnNewButton_23, gbc_btnNewButton_23);
	}
		
		//********************************************************************//
	if(counter < 3) {	
		JButton btnNewButton_26 =  new JButton();
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_26 = new GridBagConstraints();
		gbc_btnNewButton_26.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_26.gridx = 2;
		gbc_btnNewButton_26.gridy = 13;
		frame.getContentPane().add(btnNewButton_26, gbc_btnNewButton_26);
		
		JButton btnNewButton_27 =  new JButton();
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_27 = new GridBagConstraints();
		gbc_btnNewButton_27.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_27.gridx = 10;
		gbc_btnNewButton_27.gridy = 13;
		frame.getContentPane().add(btnNewButton_27, gbc_btnNewButton_27);
		
		JButton btnNewButton_25 =  new JButton();
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_25 = new GridBagConstraints();
		gbc_btnNewButton_25.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_25.gridx = 2;
		gbc_btnNewButton_25.gridy = 21;
		frame.getContentPane().add(btnNewButton_25, gbc_btnNewButton_25);
		
		JButton btnNewButton_24 =  new JButton();
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_24 = new GridBagConstraints();
		gbc_btnNewButton_24.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_24.gridx = 10;
		gbc_btnNewButton_24.gridy = 21;
		frame.getContentPane().add(btnNewButton_24, gbc_btnNewButton_24);
	}
		
		//****************************************************************//
	if(counter < 4) {	
		JButton btnNewButton_28 =  new JButton();
		btnNewButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_28 = new GridBagConstraints();
		gbc_btnNewButton_28.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_28.gridx = 6;
		gbc_btnNewButton_28.gridy = 16;
		frame.getContentPane().add(btnNewButton_28, gbc_btnNewButton_28);
		
		JButton btnNewButton_29 =  new JButton();
		btnNewButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_29 = new GridBagConstraints();
		gbc_btnNewButton_29.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_29.gridx = 6;
		gbc_btnNewButton_29.gridy = 18;
		frame.getContentPane().add(btnNewButton_29, gbc_btnNewButton_29);
	}
	}
		
	if(counter >= 2) {
	
	if(counter == 2) {
		for(int i = 0; i<8; i++) {
			round3.add(null);
		}
	}
		
		JButton btnNewButton_20 =  new JButton(round2.get(3).getName());
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(3, round2.get(3));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		
		JButton btnNewButton_30 = new JButton(round2.get(0).getName());
		btnNewButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(0, round2.get(0));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_30 = new GridBagConstraints();
		gbc_btnNewButton_30.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_30.gridx = 1;
		gbc_btnNewButton_30.gridy = 11;
		frame.getContentPane().add(btnNewButton_30, gbc_btnNewButton_30);
		GridBagConstraints gbc_btnNewButton_20 = new GridBagConstraints();
		gbc_btnNewButton_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_20.gridx = 11;
		gbc_btnNewButton_20.gridy = 11;
		frame.getContentPane().add(btnNewButton_20, gbc_btnNewButton_20);
		
		JButton btnNewButton_17 =  new JButton(round2.get(7).getName());
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(0, round2.get(7));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_17.gridx = 1;
		gbc_btnNewButton_17.gridy = 15;
		frame.getContentPane().add(btnNewButton_17, gbc_btnNewButton_17);
		
		JButton btnNewButton_21 =  new JButton(round2.get(6).getName());
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(3, round2.get(6));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_21.gridx = 11;
		gbc_btnNewButton_21.gridy = 15;
		frame.getContentPane().add(btnNewButton_21, gbc_btnNewButton_21);
		
		JButton btnNewButton_18 =  new JButton(round2.get(4).getName());
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(2, round2.get(4));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_18 = new GridBagConstraints();
		gbc_btnNewButton_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_18.gridx = 1;
		gbc_btnNewButton_18.gridy = 19;
		frame.getContentPane().add(btnNewButton_18, gbc_btnNewButton_18);
		
		JButton btnNewButton_22 =  new JButton(round2.get(5).getName());
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(1, round2.get(5));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_22.gridx = 11;
		gbc_btnNewButton_22.gridy = 19;
		frame.getContentPane().add(btnNewButton_22, gbc_btnNewButton_22);
		
		JButton btnNewButton_19 =  new JButton(round2.get(2).getName());
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(2, round2.get(2));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_19 = new GridBagConstraints();
		gbc_btnNewButton_19.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_19.gridx = 1;
		gbc_btnNewButton_19.gridy = 23;
		frame.getContentPane().add(btnNewButton_19, gbc_btnNewButton_19);
		
		JButton btnNewButton_23 =  new JButton(round2.get(1).getName());
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 2) {
					check2++; 
					round3.set(1, round2.get(1));
				}
				if(round2Done(check2)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_23.gridx = 11;
		gbc_btnNewButton_23.gridy = 23;
		frame.getContentPane().add(btnNewButton_23, gbc_btnNewButton_23);
	}
	
	if(counter >= 3) {
		
		if(counter == 3) {
			for(int i = 0; i < 4; i ++) {
				round4.add(null);
			}
		}
		
		JButton btnNewButton_26 =  new JButton(round3.get(0).getName());
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 3) {
					check3++; 
					round4.set(0, round3.get(0));
				}
				if(round3Done(check3)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_26 = new GridBagConstraints();
		gbc_btnNewButton_26.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_26.gridx = 2;
		gbc_btnNewButton_26.gridy = 13;
		frame.getContentPane().add(btnNewButton_26, gbc_btnNewButton_26);
		
		JButton btnNewButton_27 =  new JButton(round3.get(3).getName());
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 3) {
					check3++; 
					round4.set(1, round3.get(3));
				}
				if(round3Done(check3)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_27 = new GridBagConstraints();
		gbc_btnNewButton_27.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_27.gridx = 10;
		gbc_btnNewButton_27.gridy = 13;
		frame.getContentPane().add(btnNewButton_27, gbc_btnNewButton_27);
		
		JButton btnNewButton_25 =  new JButton(round3.get(2).getName());
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 3) {
					check3++; 
					round4.set(0, round3.get(2));
				}
				if(round3Done(check3)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_25 = new GridBagConstraints();
		gbc_btnNewButton_25.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_25.gridx = 2;
		gbc_btnNewButton_25.gridy = 21;
		frame.getContentPane().add(btnNewButton_25, gbc_btnNewButton_25);
		
		JButton btnNewButton_24 =  new JButton(round3.get(1).getName());
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 3) {
					check3++; 
					round4.set(1, round3.get(1));
				}
				if(round3Done(check3)) {
					execute();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_24 = new GridBagConstraints();
		gbc_btnNewButton_24.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_24.gridx = 10;
		gbc_btnNewButton_24.gridy = 21;
		frame.getContentPane().add(btnNewButton_24, gbc_btnNewButton_24);
		
	}
	
	if(counter >= 4) {	
		
		JButton btnNewButton_28 =  new JButton(round4.get(0).getName());
		btnNewButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 4) { 
					round5.add(round4.get(0));
					execute();

				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_28 = new GridBagConstraints();
		gbc_btnNewButton_28.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_28.gridx = 6;
		gbc_btnNewButton_28.gridy = 16;
		frame.getContentPane().add(btnNewButton_28, gbc_btnNewButton_28);
		
		JButton btnNewButton_29 =  new JButton(round4.get(1).getName());
		btnNewButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter == 4) { 
					round5.add(round4.get(1));
					execute();

				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_29 = new GridBagConstraints();
		gbc_btnNewButton_29.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_29.gridx = 6;
		gbc_btnNewButton_29.gridy = 18;
		frame.getContentPane().add(btnNewButton_29, gbc_btnNewButton_29);
	
	}
	
	if(counter >= 5) {
		
		
		JLabel lblNewLabel = new JLabel(round5.get(0).getName() + " has ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 15;
		gbc_lblNewLabel.gridy = 17;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel alblNewLabel = new JLabel("won the tournament!");
		alblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_alblNewLabel = new GridBagConstraints();
		gbc_alblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_alblNewLabel.gridx = 15;
		gbc_alblNewLabel.gridy = 18;
		frame.getContentPane().add(alblNewLabel, gbc_alblNewLabel);
		
		System.out.println("RESULTS");
		System.out.println("-------");
		System.out.println(round5.get(0).getName() + " has won the French Open!");
		System.out.println("Check list.txt for updated rankings!");


		
		countPoints();
	}
	
	
	
	}	
	public static void countPoints() {
		
		ArrayList<TennisPlayers> dupe = new ArrayList<TennisPlayers>();
		
		
		(round5.get(0)).setPoints(2000);
		dupe.add(round5.get(0));
		
		for( int i = 0; i < 2 ; i++) {
			if(!checkDupe(round4.get(i), dupe)) {
				round4.get(i).setPoints(1200);
				dupe.add(round4.get(i));
			}
		}
		
		for(int i = 0; i < 4; i ++) {
			if(!checkDupe(round3.get(i), dupe)) {
				round3.get(i).setPoints(720);
				dupe.add(round3.get(i));
			}
		}
		
		for(int i = 0; i < 8; i++ ) {
			if(!checkDupe(round2.get(i), dupe)) {
				round2.get(i).setPoints(360);
				dupe.add(round2.get(i));
			}
		}
		
		for(int i = 0; i < 16; i++) {
			if(!checkDupe(players.get(i), dupe)) {
				players.get(i).setPoints(180);
				dupe.add(players.get(i));
			}
		}
		
		for(TennisPlayers p : players) {
			if(!checkDupe(p, dupe)) {
				p.setPoints(45);
				dupe.add(p);
			}
		}
		
		PlayersList obj = new PlayersList();
		obj.sortList(players);
		saveList(players);
		
	}
		
	public static boolean checkDupe(TennisPlayers player , ArrayList<TennisPlayers> dupe)  {
		
		for(TennisPlayers player1 : dupe)
		{
		if(player != null) {
			if((player1.getName()).equals(player.getName())) {
				return true;
			}
		}
		}
		return false;
	}
	
		
		
		

}