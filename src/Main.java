package Tennis;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Scanner;
public class Main {
	static ArrayList<TennisPlayers> players = new ArrayList<TennisPlayers>();

	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		boolean loop = true;
		PlayersList obj = new PlayersList();
		players = obj.readList();
		
	do {
		
		
		int menu = 0;
		System.out.println("Enter a command: \n(1) Edit or view list  \n(2) Find someone to play with \n(3) Record a result \n(4) Reset Season \n(5) Save list");
		menu = input.nextInt();
		
		if(menu == 0) {
			System.out.println("program terminated");
			System.exit(0);
		}
		
		if(menu == 1) {
		
		System.out.println("Choose an option: \n(1) Add a player \n(2) Remove a player \n(3) View players \n(4) Change Information");
		int option = input.nextInt();
		
		if(option == 1) {
			
			
			
			TennisPlayers player = new TennisPlayers();
			System.out.println("Enter a name: ");
			String name = input3.nextLine();
			System.out.println("Enter a state: ");
			String state = input3.nextLine();
			System.out.println("Enter an age: ");
			int age = input.nextInt();
			System.out.println("Enter a points(1.0 - 5.0): ");
			int points = input.nextInt();
			player.setName(name);
			player.setAge(age);
			player.setPoints(points);
			player.setState(state);
			players = obj.addToList(player);
					}
		
		if(option == 2) {
			
			System.out.println("Enter the name of the player: ");
			input.nextLine();
			String name = input.nextLine();
			players = obj.removeFromList(findPlayer(name));
			
			
		}
		
		if(option == 3) {
			int i = 1;
			for(TennisPlayers player : players) {
				System.out.printf("%8s%25s%15s%6d%10.5s%10.2f",i+".",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
				System.out.println();
				i++;
			}
			System.out.println();
		}
		
		if(option == 4) {
			System.out.println("Enter the name of the player: ");
			String name = input3.nextLine();
			System.out.println("What would you like to change? (1) name (2) state (3) age (4) points");
			int choice = input.nextInt();
			if(choice == 1) {
				System.out.println("Enter a new name: ");
				String name2 = input3.nextLine();
				(findPlayer(name)).setName(name2);
			}
			if(choice == 2) {
				System.out.println("Enter a new state: ");
				String state = input2.nextLine();
				(findPlayer(name)).setState(state);
			}
			if(choice == 3) {
				System.out.println("Enter a new age: ");
				int age = input.nextInt();
				(findPlayer(name)).setAge(age);
			}
			if(choice == 4) {
				System.out.println("Enter a new points: ");
				int points = input.nextInt();
				(findPlayer(name)).setPoints(points);
			}
			}
		
		}
		if(menu == 2) {
			boolean match = false;
			System.out.println("Would you like to search based on location (1), points (2), age(3), or winning percentage(4)? ");
			int choice = input2.nextInt();
			if(choice == 1) {
				System.out.println("Enter your location: ");
				String location = input3.nextLine();
				for(TennisPlayers player : players) {
					if(player.getState().equals(location)) {
						System.out.printf("%25s%15s%6d%10.5s%10.2f",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
						System.out.println();
						match = true;
					}
				}
				System.out.println();
			}
		
			if(choice == 2) {
				System.out.println("Enter your points: ");
				double skill = input3.nextDouble();
				for(TennisPlayers player : players) {
					if(player.getPoints() == skill) {
						System.out.printf("%25s%15s%6d%10.5s%10.2f",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
						System.out.println();
						match = true;
					}
				}
				System.out.println();
			}
			if(choice == 3) {
				System.out.println("Enter your age: ");
				int age = input3.nextInt();
				for(TennisPlayers player : players) {
					if(player.getAge() == age) {
						System.out.printf("%25s%15s%6d%10.5s%10.2f",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
						System.out.println();
						match = true;
					}
				}
				System.out.println();
			}
			if(choice == 4) {
				System.out.println("Enter a minimum winning percentage: ");
				double percentage = input3.nextDouble();
				for(TennisPlayers player : players) {
					if(player.getPercentage() >= percentage) {
						System.out.printf("%25s%15s%6d%10.5s%10.2f",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
						System.out.println();
						match = true;
					}
				}
				System.out.println();
			}
			if(match == false) {
				System.out.println("No players matched your search.");
			}
			System.out.println();
			
		}
		
		
		if(menu == 3) {
			recResult();
		}
		
		if(menu == 4) {
			
			resetSeason(players);
		}
		
		if(menu == 5) {
					
					saveList(players);
				}
		
		
		
	}while(loop);
		
	}
	
	public static TennisPlayers findPlayer(String name) {
		
		for(TennisPlayers player : players) {
			if((player.getName()).equals(name)) {
				return player;
			}
		}
		return null;	
	}
	
	public static boolean playerExists(String name) {
		for(TennisPlayers player : players) {
			if((player.getName()).equals(name)) {
				return true;
			}
		}
		return false;	
	}
	
	public static void recResult() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of the first player: ");
		String fPlayer = input.nextLine();
		System.out.println("Enter the name of the second"
				+ " player: ");
		String sPlayer = input.nextLine();
		if(fPlayer.equals(sPlayer)) {
			System.out.println("Error. Please enter two different players.\n");
		}
		if(playerExists(fPlayer) == false || playerExists(sPlayer) == false) {
			System.out.println("One or more of those player don't exist. Please enter two different players.\n");
		}
		else {
		System.out.println("Did the first(1) or second(2) player win the match?");
		int winner = input.nextInt();
		
		if(winner == 1) {
			(findPlayer(fPlayer)).addWin();
			(findPlayer(sPlayer)).addLoss();
		}
		if(winner == 2) {
			(findPlayer(sPlayer)).addWin();
			(findPlayer(fPlayer)).addLoss();
		}
	}
	}
	
	public static void resetSeason(ArrayList<TennisPlayers> players) {
		
		for(TennisPlayers player : players ) {
			player.resetPoints();
		}
		System.out.println("Done");
		saveList(players);
	}
	
	public static void saveList(ArrayList<TennisPlayers> players) {		
		
		String pathname = "list.txt";
	    File file = new File(pathname);
	    PrintWriter output = null;
	    try
	    {
	       output = new PrintWriter(file);
	    }
	    catch (FileNotFoundException ex)
	    {
	       System.out.println("Cannot create " + pathname);
	       System.exit(1);  // quit the program
	    }
	    for(TennisPlayers player : players) {
		    output.printf("%25s%15s%6d%10.5s%10.2f",player.getName(),player.getState(),player.getAge(),player.getPoints(),player.getPercentage());
		    output.println();
		}
	    output.close();

		
	}

}
