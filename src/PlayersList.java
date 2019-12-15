package Tennis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Comparator;

public class PlayersList implements java.lang.Comparable<TennisPlayers>{
	public ArrayList<TennisPlayers> players = new ArrayList<TennisPlayers>();

	
	public PlayersList() {
		
	}
	
	public ArrayList<TennisPlayers> readList() {
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
		sortList(players);
		return players;
		    
	}
	
	public ArrayList<TennisPlayers> addToList(TennisPlayers player) {
		players.add(player);
//		Collections.sort(players);
		return players;
	}
	
	public ArrayList<TennisPlayers> removeFromList(TennisPlayers player){
		players.remove(player);
//		Collections.sort(players);
		return players;
	}
	
	public ArrayList<TennisPlayers> getList(){
		return players;
	}

	public void sortList(ArrayList<TennisPlayers> players ) {
		 Collections.sort(players, new NameComparator());
	}
	

	@Override
	public int compareTo(TennisPlayers o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
 class NameComparator implements Comparator<TennisPlayers> {
	@Override
	public int compare(TennisPlayers p1, TennisPlayers p2) {
		 // parameter are of type Object, so we have to downcast it to Employee objects
        double p1Name = p1.getPoints();
        double p2Name = p2.getPoints();
        // uses compareTo method of String class to compare names of the employee
        return Double.valueOf(p2Name).compareTo(p1Name);
	}
 
}


