import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game implements Runnable {
  

	// true if the high scores are displayed in the frame
	private boolean scoresOn = false;
	
	public void run() {

		// Top-level frame
		final JFrame frame = new JFrame("Tron");
		frame.setBackground(Color.BLACK);
		frame.setPreferredSize(new Dimension(1500,1500));
		frame.setLocation(0, 0);
		frame.setResizable(false);
		//-------------------------------------------------------------------------------------------------------------

		/*Main Menu*/

		// main menu panel
		final JPanel mainMenu = new JPanel();
		mainMenu.setLayout(new BorderLayout());
		mainMenu.setBackground(Color.BLACK);


		// image on the main menu
		@SuppressWarnings("serial")
		final JComponent pict = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				//set the x and yCoordinate coordinates to 0  so that it will always appear on the top left of the screen
				Picture.draw(gc, "tron_bike1.jpg", 0, 0);
			}
		};


		// welcome label to all players
		JLabel welcome = new JLabel("WELCOME PLAYERS!",SwingConstants.CENTER);
		welcome.setFont(new Font("Algerian", Font.PLAIN, 100));
		welcome.setForeground(Color.green);

		// panel for main menu buttons
		final JPanel topMenu = new JPanel();
		topMenu.setLayout(new GridLayout(1,3));
		topMenu.setBackground(Color.BLACK);

		// button to the game menu
		final JButton play = new JButton("GAME MENU");
		play.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		play.setPreferredSize(new Dimension(100,100));
		topMenu.add(play);


		//button to exit the game
		final JButton quit = new JButton("QUIT");
		quit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		quit.setPreferredSize(new Dimension(100,100));
		topMenu.add(quit);

		// adds components to the main menu panel
		mainMenu.add(pict, BorderLayout.CENTER);
		mainMenu.add(topMenu, BorderLayout.SOUTH);
		mainMenu.add(welcome, BorderLayout.NORTH);

		// adds main menu panel to the frame
		frame.add(mainMenu);
		//---------------------------------------------------------------------------------------------------------------

		/* Menu after user enters the game menu*/

		// game menu panel that replaces the main menu panel
	  final JPanel gameMenu = new JPanel();
	  gameMenu.setLayout(new BorderLayout());
	  gameMenu.setBackground(Color.BLACK);

	  // panel that displays the image, high scores and game type buttons
	  final JPanel topGameMenu = new JPanel();
	  topGameMenu.setLayout(new GridLayout(2, 1));
	  topGameMenu.setBackground(Color.BLACK);

	  // panel that holds the buttons for each game type
	  final JPanel modes = new JPanel();
	  modes.setLayout(new GridLayout(1,3));
	  modes.setBackground(Color.BLACK);




		// button to play single player
		final JButton singlePlayer = new JButton("SINGLE PLAYER");
		singlePlayer.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		modes.add(singlePlayer);


		// button for two players
		final JButton twoPlayers = new JButton("TWO PLAYERS");
		twoPlayers.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		modes.add(twoPlayers);

		// an image to show the instruction in the game menu
		@SuppressWarnings("serial")
		final JComponent menuPict = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				Picture.draw(gc, "instructions_page1.png", 400, 0);
			}
		};

		// adds panels to topGameMenu
	  topGameMenu.add(modes);
	  topGameMenu.add(menuPict);

		// panel for highs core and  main menu buttons
		final JPanel bottomMenu = new JPanel();
		bottomMenu.setBackground(Color.BLACK);

		// buttons for high score
		final JButton highScores = new JButton("HIGH SCORE");
		highScores.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		bottomMenu.add(highScores);


		// button for main menu
		final JButton back = new JButton("MAIN MENU");
		back.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		bottomMenu.add(back);

		// adds bottomMenu and playMenuUpper to playMenu
		gameMenu.add(topGameMenu, BorderLayout.CENTER);
		gameMenu.add(bottomMenu, BorderLayout.SOUTH);
		//----------------------------------------------------------------------------------------------------------------

		/*One player Menu*/


	  // panel that holds the buttons and label for the one player mode
	  final JPanel onePlayerMenu = new JPanel();
	  onePlayerMenu.setLayout(new GridLayout(1,3));
	  onePlayerMenu.setBackground(Color.BLACK);
	  
	   // label for the score
		final JLabel score = new JLabel("   Score: 0" + "   Boost: 3",SwingConstants.CENTER);
		score.setForeground(Color.WHITE);
		score.setBackground(Color.BLACK);
		score.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		onePlayerMenu.add(score);


		// button to restart the game
		final JButton restart = new JButton("RESTART");
		restart.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		onePlayerMenu.add(restart);


		// button to go back to the game menu
		final JButton exit = new JButton("GAME MENU");
		exit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		onePlayerMenu.add(exit);

		// one player level
      final TronMapSurvival levelSurv = new TronMapSurvival(score, 1);
      levelSurv.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      //----------------------------------------------------------------------------------------------------------------

		/*Two-player Level Menu*/

	  // panel that holds the buttons and labels for two-player mode
	  final JPanel twoMenu = new JPanel();
	  twoMenu.setLayout(new GridLayout(1,4));
	  twoMenu.setBackground(Color.BLACK);
	  
	  // panel that holds the scores and boost for each player
	  final JPanel scoresTwo = new JPanel();
	  scoresTwo.setLayout(new GridLayout(2,1));
	  scoresTwo.setBackground(Color.BLACK);
	  
	  // the score label for player one
	  final JLabel scoreTwo1 = new JLabel("   Player 1: 0" + "    Boost: 3");
	  scoreTwo1.setForeground(Color.WHITE);
	  scoreTwo1.setBackground(Color.BLACK);
	  scoreTwo1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
	  //add score to the JPanel for scoreTwo
	  scoresTwo.add(scoreTwo1);

		// the score label for player two
	  final JLabel scoreTwo2 = new JLabel("   Player 2: 0" + "    Boost: 3");
	  scoreTwo2.setForeground(Color.WHITE);
	  scoreTwo2.setBackground(Color.BLACK);
	  scoreTwo2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
	  //add score to the JPanel for scoreTwo
	  scoresTwo.add(scoreTwo2);

	  //add the JPanel that holds to the two scores to the menu for the two player mode
	  twoMenu.add(scoresTwo);
	  
	  // the restart button for two-player mode
	  final JButton restartTwo = new JButton("RESTART");
	  restartTwo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
	  twoMenu.add(restartTwo);

		// the quit button for two-player mode
	  final JButton quitTwo = new JButton("QUIT");
	  quitTwo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
	  twoMenu.add(quitTwo);

	  // the two-player level
      final TronMapTwoPlayer levelTwoPlayer = new TronMapTwoPlayer(scoreTwo1, scoreTwo2, 2);
      levelTwoPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		//----------------------------------------------------------------------------------------------------------------

		/*Add action listeners*/

	  play.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {		//remove mainMenu when the button is click
			  frame.remove(mainMenu);
			  // redirect to the game menu
			  frame.add(gameMenu);
			  //update the graphics
			  frame.update(frame.getGraphics());
			  //change the construct of the gameMenu
			  gameMenu.revalidate();
		  }
	  });

	  
	  quit.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
		  	//exit the game when the quit button is pressed
			  System.exit(1);
		  }
	  });
	  
	  highScores.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
			  if (scoresOn)
			  {
			  	// if score is lower,  remove all graphics and go back to the menu pic
				  topGameMenu.removeAll();
				  topGameMenu.add(modes);
				  topGameMenu.add(menuPict);
			  }
			  else if (!scoresOn)
			  {
			  	//if score is higher, add to high score board
				  topGameMenu.remove(menuPict);
				  topGameMenu.add(levelSurv.getHighs());
			  }
			  scoresOn = !scoresOn;
			  topGameMenu.revalidate();
			  frame.repaint();
		  }
	  });

	  //for the back to main menu button
	  back.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
		  	//remove the game menu graphics and add the main menu graphics
			  frame.remove(gameMenu);
			  frame.add(mainMenu);
			  frame.update(frame.getGraphics());
		  }
	  });

	  // for the single player button
	  singlePlayer.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
		  	//remove the game menu and move to the single player menu and add all the buttons and layout needed
			  frame.remove(gameMenu);
			  frame.setLayout(new BorderLayout());
			  frame.add(levelSurv, BorderLayout.CENTER);
			  frame.add(onePlayerMenu, BorderLayout.SOUTH);
			  frame.update(frame.getGraphics());
			  levelSurv.requestFocusInWindow();
			  levelSurv.revalidate();
			  levelSurv.reset();
		  }
	  });

	 // for the restart button
	  restart.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
		  	//when the restart button is pressed
			  levelSurv.reset();
		  }
	  });

	  //exit the game
	  exit.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
			  frame.remove(levelSurv);
			  frame.remove(onePlayerMenu);
			  frame.add(gameMenu);
			  frame.update(frame.getGraphics());
			  gameMenu.revalidate();
		  }
	  });

	  //when the two player button is pressed
	  twoPlayers.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  frame.remove(gameMenu);
			  frame.setLayout(new BorderLayout());
			  frame.add(levelTwoPlayer, BorderLayout.CENTER);
			  frame.add(twoMenu, BorderLayout.SOUTH);
			  frame.update(frame.getGraphics());
			  levelTwoPlayer.requestFocusInWindow();
			  levelTwoPlayer.revalidate();
			  levelTwoPlayer.reset();
		  }
	  });

	  //restart button for the two player
	  restartTwo.addActionListener(new ActionListener()
      {
		  public void actionPerformed(ActionEvent e) {
			  levelTwoPlayer.reset();
		  }
	  });

	  // quit game for the two player mode
	  quitTwo.addActionListener(new ActionListener()
      {
		  public void actionPerformed(ActionEvent e)
          {
			  frame.remove(levelTwoPlayer);
			  frame.remove(twoMenu);
			  frame.add(gameMenu);
			  frame.update(frame.getGraphics());
			  gameMenu.revalidate();
			  levelTwoPlayer.restartGame();
		  }
	  });


	  
      // put the frame on the screen
      frame.pack();
      //ensure that the frame and operation of the game is closed
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      // start the game running
      levelSurv.reset();
      levelTwoPlayer.reset();

   }

}
