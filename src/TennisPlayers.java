package Tennis;
import java.util.ArrayList;
import java.util.List;
public class TennisPlayers  {
	
	private String name;
	private String state;
	
	private int age;
	private double numberMatches;
	private double numberWins;
	private int seasonPoints;
	private double percentage;
	
	
	public TennisPlayers() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getState() {
		return this.state;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getAge() {
		return this.age;
	}
	
	public void setPoints(int points) {
		this.seasonPoints += points;
	}
	
	public void resetPoints() {
		this.seasonPoints = 0;
	}
	
	public int getPoints() {
		return this.seasonPoints;
	}
	
	
	public double getPercentage() {
		return this.percentage;
	}

	public void setPercentage(double percent) {
		this.percentage = percent;
	}
	
	public void addWin() {
		numberMatches++;
		numberWins++;
		this.setPercentage((numberWins)/(numberMatches));
		
	}
	
	public void addLoss() {
		numberMatches++;
		this.setPercentage((numberWins)/(numberMatches));
	}


	
	
//	@Override
//	public int compareTo(TennisPlayers comparePlayer) {
//		String compareName = ((TennisPlayers)comparePlayer).getName();
//        /* For Ascending order*/
//        return this.name.compareTo(compareName);
//
//        /* For Descending order do like this */
//        //return compareage-this.studentage
//	}
//
//	
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
}
