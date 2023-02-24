import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        
        Player[] players = new Player[4];
        
        for(int i = 0; i < players.length ; i++){
            int playerId = sc.nextInt();
            sc.nextLine();
            String skill = sc.nextLine();
            String level = sc.nextLine();
            int points = sc.nextInt();
            sc.nextLine();
            players[i] = new Player (playerId,skill,level,points);
        }
        
        String skillput = sc.nextLine();
        String levelput = sc.nextLine();

        int result1 = findPointsForGivenSkill(players,skillput);
        if(result1 > 0){
             System.out.println(result1);
        }
        else{
            System.out.println("The given Skill is not available");
        }
        
        Player result = getPlayerBasedOnLevel(players,skillput,levelput);
        if(result == null){
            System.out.println("no");
        }
        
        else{
            System.out.println(result.getPlayerId());
        }
    }
    
    public static int findPointsForGivenSkill(Player[] players, String skillput){
        int sum = 0;
        for(int  i = 0; i < players.length; i++){
            if(players[i].getSkill().equalsIgnoreCase(skillput)){
                sum = players[i].getPoints() + sum;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum;
    }
    
    
    public static Player getPlayerBasedOnLevel(Player[] players, String skillput, String levelput){
        for(int i = 0; i < players.length ; i++){
            if(players[i].getSkill().equalsIgnoreCase(skillput) && players[i].getLevel().equalsIgnoreCase(levelput)){
                if(players[i].getPoints() >= 20){
                    return players[i];
                }
            }
        }
        
        return null;
    }
}

class Player {
    private int playerId;
    private String skill;
    private String level;
    private int points;
    
    public int getPlayerId(){
        return playerId;
    }
    public void setPlayerId(int playerId){
        this.playerId = playerId;   
    }
    
    public String getSkill(){
        return skill;
    }
    
    public void setSkill(String skill){
        this.skill = skill;
    }
    
    public String getLevel(){
        return level;
    }
    
    public void setLevel(String level){
        this.level = level;
    }
    
    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        this.points = points;   
    }
    
    public Player(int playerId, String skill, String level, int points){
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }
    
}
