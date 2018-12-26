import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmProject;
	BufferedImage background;
	private static Player player1;
	private static Player player2;
	private static int currentPlayer;
	private JButton btnP1Attack1;
	private JButton btnP1Attack2;
	private JButton btnP1Attack3;
	private JButton btnP1Attack4;
	private JButton btnP2Attack1;
	private JButton btnP2Attack2;
	private JButton btnP2Attack3;
	private JButton btnP2Attack4;
	private static JButton[] p1ButtonList;
	private static JButton[] p2ButtonList;
	private static JLabel lblPlayer1HP;
	private static JLabel lblPlayer2HP;
	private JLabel lblHP2;
	private static JLabel lblMessage;
	static JFileChooser fileChooser;
	private static File file;
	private static boolean fileSaved = false;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	

	private void initialize() {
		frmProject = new JFrame();
		frmProject.setTitle("1400 Project");
		frmProject.setBounds(100, 100, 1023, 857);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/figter1.gif")));
		lblNewLabel.setBounds(169, 500, 326, 265);
		frmProject.getContentPane().add(lblNewLabel);
		
		JLabel lblLightning = new JLabel("");
		lblLightning.setBounds(562, 486, 246, 292);
		lblLightning.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/lightning2.gif")));
		frmProject.getContentPane().add(lblLightning);
		
		JLabel lblPlayer1 = new JLabel("Player1");
		lblPlayer1.setForeground(Color.RED);
		lblPlayer1.setFont(new Font("Viner Hand ITC", Font.BOLD, 56));
		lblPlayer1.setBounds(30, 46, 387, 120);
		frmProject.getContentPane().add(lblPlayer1);
		
		JLabel lblVs = new JLabel("Vs");
		lblVs.setFont(new Font("Viner Hand ITC", Font.BOLD, 56));
		lblVs.setForeground(Color.RED);
		lblVs.setBounds(480, 67, 72, 78);
		frmProject.getContentPane().add(lblVs);
		
		JLabel lblPlayer2 = new JLabel("Player2");
		lblPlayer2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayer2.setForeground(Color.RED);
		lblPlayer2.setFont(new Font("Viner Hand ITC", Font.BOLD, 56));
		lblPlayer2.setBounds(624, 58, 362, 97);
		frmProject.getContentPane().add(lblPlayer2);
		
		JLabel lblhp = new JLabel("HP:");
		lblhp.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblhp.setForeground(Color.RED);
		lblhp.setBounds(30, 142, 62, 47);
		frmProject.getContentPane().add(lblhp);
		
		lblHP2 = new JLabel("HP:");
		lblHP2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHP2.setForeground(Color.RED);
		lblHP2.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblHP2.setBounds(865, 135, 62, 60);
		frmProject.getContentPane().add(lblHP2);
		
		btnP1Attack1 = new JButton("Punch");
		btnP1Attack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.punch(player2);
				switchPlayer();
			}
		});
		btnP1Attack1.setEnabled(false);
		btnP1Attack1.setBounds(30, 304, 115, 29);
		frmProject.getContentPane().add(btnP1Attack1);
		
		btnP1Attack2 = new JButton("Kick");
		btnP1Attack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Attack.kick(player2);
				switchPlayer();
			}
		});
		btnP1Attack2.setEnabled(false);
		btnP1Attack2.setBounds(217, 304, 115, 29);
		frmProject.getContentPane().add(btnP1Attack2);
		
		btnP1Attack3 = new JButton("Special 1");
		btnP1Attack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.special1(player2);
				switchPlayer();
			}
		});
		btnP1Attack3.setEnabled(false);
		btnP1Attack3.setBounds(30, 416, 115, 29);
		frmProject.getContentPane().add(btnP1Attack3);
		
		btnP1Attack4 = new JButton("Special 2");
		btnP1Attack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.special2(player2);
				switchPlayer();
			}
		});
		btnP1Attack4.setEnabled(false);
		btnP1Attack4.setBounds(217, 416, 115, 29);
		frmProject.getContentPane().add(btnP1Attack4);
		
		btnP2Attack1 = new JButton("Punch");
		btnP2Attack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Attack.punch(player1);
				switchPlayer();
			}
		});
		btnP2Attack1.setEnabled(false);
		btnP2Attack1.setBounds(624, 304, 115, 29);
		frmProject.getContentPane().add(btnP2Attack1);
		
		btnP2Attack2 = new JButton("Kick");
		btnP2Attack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.kick(player1);
				switchPlayer();
			}
		});
		btnP2Attack2.setEnabled(false);
		btnP2Attack2.setBounds(830, 304, 115, 29);
		frmProject.getContentPane().add(btnP2Attack2);
		
		btnP2Attack3 = new JButton("Special 1");
		btnP2Attack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.special1(player1);
				switchPlayer();
			}
		});
		btnP2Attack3.setEnabled(false);
		btnP2Attack3.setBounds(624, 416, 115, 29);
		frmProject.getContentPane().add(btnP2Attack3);
		
		btnP2Attack4 = new JButton("Special 2");
		btnP2Attack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Attack.special2(player1);
				switchPlayer();
			}
		});
		btnP2Attack4.setEnabled(false);
		btnP2Attack4.setBounds(830, 416, 115, 29);
		frmProject.getContentPane().add(btnP2Attack4);
		
		lblMessage = new JLabel("Select New Game to Start");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Viner Hand ITC", Font.BOLD, 51));
		lblMessage.setBounds(144, 129, 706, 159);
		frmProject.getContentPane().add(lblMessage);
		
		lblPlayer1HP = new JLabel("100");
		lblPlayer1HP.setForeground(Color.RED);
		lblPlayer1HP.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblPlayer1HP.setBounds(93, 149, 72, 33);
		frmProject.getContentPane().add(lblPlayer1HP);
		
		lblPlayer2HP = new JLabel("100");
		lblPlayer2HP.setForeground(Color.RED);
		lblPlayer2HP.setFont(new Font("Viner Hand ITC", Font.BOLD, 29));
		lblPlayer2HP.setBounds(929, 149, 72, 33);
		frmProject.getContentPane().add(lblPlayer2HP);
		
		JLabel lblDamagehp = new JLabel("Damage: 5HP");
		lblDamagehp.setForeground(Color.WHITE);
		lblDamagehp.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblDamagehp.setToolTipText("");
		lblDamagehp.setVerticalAlignment(SwingConstants.TOP);
		lblDamagehp.setBounds(30, 344, 140, 20);
		frmProject.getContentPane().add(lblDamagehp);
		
		JLabel lblChance = new JLabel("Chance: 90%");
		lblChance.setForeground(Color.WHITE);
		lblChance.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblChance.setBounds(30, 369, 140, 20);
		frmProject.getContentPane().add(lblChance);
		
		JLabel lblDamagehp_1 = new JLabel("Damage: 15HP");
		lblDamagehp_1.setForeground(Color.WHITE);
		lblDamagehp_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblDamagehp_1.setBounds(217, 344, 155, 20);
		frmProject.getContentPane().add(lblDamagehp_1);
		
		JLabel lblChance_1 = new JLabel("Chance: 70%");
		lblChance_1.setForeground(Color.WHITE);
		lblChance_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblChance_1.setBounds(217, 369, 155, 20);
		frmProject.getContentPane().add(lblChance_1);
		
		JLabel lblDamagehp_2 = new JLabel("Damage: 30HP");
		lblDamagehp_2.setForeground(Color.WHITE);
		lblDamagehp_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblDamagehp_2.setBounds(30, 458, 155, 20);
		frmProject.getContentPane().add(lblDamagehp_2);
		
		JLabel lblChance_2 = new JLabel("Chance: 40%");
		lblChance_2.setForeground(Color.WHITE);
		lblChance_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblChance_2.setBounds(30, 483, 129, 20);
		frmProject.getContentPane().add(lblChance_2);
		
		JLabel lblDamagehp_3 = new JLabel("Damage: 90HP");
		lblDamagehp_3.setForeground(Color.WHITE);
		lblDamagehp_3.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblDamagehp_3.setBounds(217, 461, 155, 20);
		frmProject.getContentPane().add(lblDamagehp_3);
		
		JLabel lblChance_3 = new JLabel("Chance: 5%");
		lblChance_3.setForeground(Color.WHITE);
		lblChance_3.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		lblChance_3.setBounds(217, 483, 155, 20);
		frmProject.getContentPane().add(lblChance_3);
		
		JLabel label = new JLabel("Damage: 5HP");
		label.setForeground(Color.WHITE);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setToolTipText("");
		label.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label.setBounds(624, 344, 140, 20);
		frmProject.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Chance: 90%");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_1.setBounds(624, 369, 140, 20);
		frmProject.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Damage: 30HP");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_2.setBounds(624, 455, 155, 20);
		frmProject.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Chance: 40%");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_3.setBounds(624, 480, 129, 20);
		frmProject.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Damage: 15HP");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_4.setBounds(831, 344, 155, 20);
		frmProject.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Chance: 70%");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_5.setBounds(831, 366, 155, 20);
		frmProject.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Damage: 90HP");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_6.setBounds(831, 455, 155, 20);
		frmProject.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Chance: 5%");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Viner Hand ITC", Font.BOLD, 16));
		label_7.setBounds(831, 480, 155, 20);
		frmProject.getContentPane().add(label_7);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/background1.gif")));
		lblBackground.setBounds(0, 0, 1001, 770);
		frmProject.getContentPane().add(lblBackground);
		
		JMenuBar menuBar = new JMenuBar();
		frmProject.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					//get player names
					player1 = new Player(JOptionPane.showInputDialog("Player 1: Enter your name"));
					player2 = new Player(JOptionPane.showInputDialog("Player 2: Enter your name"));
					//set player names
					lblPlayer1.setText(player1.getName());
					lblPlayer2.setText(player2.getName());
					//set player HP to 100
					lblPlayer1HP.setText("100");
					lblPlayer2HP.setText("100");
					//set button list
					p1ButtonList = new JButton[] {btnP1Attack1, btnP1Attack2, btnP1Attack3, btnP1Attack4};
					p2ButtonList = new JButton[] { btnP2Attack1, btnP2Attack2, btnP2Attack3, btnP2Attack4};
					
					//enable player 1 attacks
					for(JButton button : p1ButtonList)
					{
						button.setEnabled(true);
					}
					lblMessage.setText(player1.getName() + ", Attack!");
					
					currentPlayer = 1;
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mntmSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//if the players haven't been created yet
				try
				{
					if(player1.equals(null) || player2.equals(null))
						throw new NullPointerException();
					//if the game has already been saved and a file exists
					if(fileSaved == true)
					{
						//save the file
						try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getPath())))
						{
							out.writeObject(player1);
							out.writeObject(player2);
							
							JOptionPane.showMessageDialog(null, "Game Saved!", "Success", JOptionPane.DEFAULT_OPTION);
						}
						//error message if theres an error
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Unable to Save Game" + ex.toString(), "Error", JOptionPane.ERROR);
						}
					}
					//if not saved already, call the save as function
					else
					{
						saveAs();
					}
				}
				catch(NullPointerException ex)
				{
					JOptionPane.showMessageDialog(null, "Players not created yet!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmSaveGame.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.addSeparator();
		mnFile.add(mntmSaveGame);
		
		JMenuItem mntmOpenGame = new JMenuItem("Open Game");
		mntmOpenGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//create file chooser and set selection, make filter
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Serialized Extension","ser");
				fileChooser.setFileFilter(filter);
				
				//open dialog, if cancel button, end operation
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.CANCEL_OPTION)
					return;
				
				//get file
				file = fileChooser.getSelectedFile();
				
				//start serialization
				try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file.getPath())))
				{
					//read players
					player1 = (Player)in.readObject();
					player2 = (Player)in.readObject();
					
					//set text on screen to new players
					lblPlayer1HP.setText(String.format("%d", player1.getHealth()));
					lblPlayer2HP.setText(String.format("%d", player2.getHealth()));
					lblPlayer1.setText(String.format("%s", player1.getName()));
					lblPlayer2.setText(String.format("%s", player2.getName()));
					
					//create button lists in case they haven't been created already
					p1ButtonList = new JButton[]{btnP1Attack1, btnP1Attack2, btnP1Attack3, btnP1Attack4};
					p2ButtonList = new JButton[]{btnP2Attack1, btnP2Attack2, btnP2Attack3, btnP2Attack4};
					
					//set p1 to current Player
					for(JButton btn : p1ButtonList)
					{
						btn.setEnabled(true);
					}
					currentPlayer = 1;
					
					//disable player 2 buttons
					for(JButton btn : p2ButtonList)
					{
						btn.setEnabled(false);
					}
					
					//set on screen message
					lblMessage.setText(player1.getName() + ", Attack!");
					
					//set file saved to true because we just opened the file so obviously its been saved before
					fileSaved = true;
				}
				// if there's an error, display an error message
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Unable to Open Game" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnFile.add(mntmOpenGame);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		mntmQuit.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.addSeparator();
		mnFile.add(mntmQuit);
	}
	
	public static void decreaseHealth(Player p, int damage)
	{
		//create new timer
		Timer t = new Timer();
		//create new timer task
		t.schedule(new TimerTask() 
		{
			//make counter for damage
			int count = damage;
			
		    @Override
		    public void run() 
		    {
		    	//if the player that got hit is player 1
		    	//get the players health
	    		int currentHealth = p.getHealth();
	    		//decrease health by 1
	    		p.setHealth(currentHealth - 1);
	    		//set the text on screen to their new health depending on the player
	    		if(p.equals(player1))
	    			lblPlayer1HP.setText(Integer.toString(p.getHealth()));
	    		else
	    			lblPlayer2HP.setText(Integer.toString(p.getHealth()));
	    			
	    		//decrease the amount of damage to be done
	    		count--;
	    		
	    		//if their health or the damage counter gets to 0
	    		if(p.getHealth() == 0 || count == 0)
	    		{
	    			//stop the timer
	    			t.cancel();
	    			//if the health specifically gets to 0
	    			if(p.getHealth() == 0)
	    			{
	    				//set text on screen to (winner) wins, pop up saving whoever won
	    				if(p.equals(player1))
	    				{
	    					lblMessage.setText(String.format("%s wins!", player2.getName()));
		    				JOptionPane.showMessageDialog(null, String.format("%s won!", player2.getName()), "Game Over", JOptionPane.DEFAULT_OPTION);
	    				}
	    				else
	    				{
	    					lblMessage.setText(String.format("%s wins!", player1.getName()));
		    				JOptionPane.showMessageDialog(null, String.format("%s won!", player1.getName()), "Game Over", JOptionPane.DEFAULT_OPTION);
	    				}
	    				
	    				//prompt for a new game
	    				int newGame = JOptionPane.showConfirmDialog(null, "Start a new game?", "Reset", JOptionPane.YES_NO_OPTION);
	    				
	    				//if yes, new game
	    				if(newGame == JOptionPane.YES_OPTION)
	    				{
	    					newGame();
	    				}
	    				
	    				//else disable all buttons and essentially leave the game dead until the select a new game
	    				else
	    				{
	    					for(JButton btn : p1ButtonList)
	    					{
	    						btn.setEnabled(false);
	    					}
	    					for(JButton btn : p2ButtonList)
	    					{
	    						btn.setEnabled(false);
	    					}
	    				}
	    			}
	    		}
		    }
		}, 0, 100);
	}
	
	public static void switchPlayer()
	{
		//if the current player is player1
		if(currentPlayer == 1)
		{
			//switch player
			currentPlayer = 2;
			//enable player2 buttons
			for(JButton btn : p2ButtonList)
			{
				btn.setEnabled(true);
			}
			//disable player1 buttons
			for(JButton btn: p1ButtonList)
			{
				btn.setEnabled(false);
			}
			
			//switch the message label onscreen
			lblMessage.setText(player2.getName() + ", Attack");
		}
		//if current player is player 2
		else
		{
			//switch player to player 1
			currentPlayer = 1;
			//enable player 1 buttons
			for(JButton btn : p1ButtonList)
			{
				btn.setEnabled(true);
			}
			//disable player 2 buttons
			for(JButton btn: p2ButtonList)
			{
				btn.setEnabled(false);
			}
			
			//change label on screen
			lblMessage.setText(player1.getName() + ", Attack");
		}
	}
	
	public static void newGame()
	{
		//set player 1 buttons enabled
		for(JButton btn : p1ButtonList)
		{
			btn.setEnabled(true);
		}
		//disable player 2 buttons
		for(JButton btn : p2ButtonList)
		{
			btn.setEnabled(false);
		}
		
		//setup on screen text like health and names and whatnot
		lblPlayer1HP.setText("100");
		lblPlayer2HP.setText("100");
		player1.setHealth(100);
		player2.setHealth(100);
	}
	
	public static void saveAs()
	{
		//create fileChooser, set selection mode, set recommended file name
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setSelectedFile(new File("game.ser"));
		
		//open fileChooser, end if they press cancel
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.CANCEL_OPTION)
			return;
		
		//get file
		file = fileChooser.getSelectedFile();
		
		//start serialization, write objects
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.getPath())))
		{
			out.writeObject(player1);
			out.writeObject(player2);
			
			//success message if success
			JOptionPane.showMessageDialog(null, "Game Saved!", "Success", JOptionPane.DEFAULT_OPTION);
			//set fileSaved to true because we just saved it
			fileSaved = true;
		}
		//throw error message if fail
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Unable to Save Game" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
