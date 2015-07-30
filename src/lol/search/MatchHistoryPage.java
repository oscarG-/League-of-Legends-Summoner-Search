
package lol.search;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class will create the page that holds the 10 recent matches with information. 
 * @author Oscar
 */
public class MatchHistoryPage {
    
    private final GameStaticData objGameStaticData;
    //values taken from other classes
    private final JFrame masterFrame;
    private final String summonerName;
    private final long summonerLevel;
    private final ArrayList<ImageIcon> championIcons;
    private final ArrayList<ArrayList<Integer>> itemIdMasterList; //list with lists of items picked in each match
    private final ArrayList<Integer> killsList; //list with the kills from the 10 matches
    
    public MatchHistoryPage(JFrame frame, Summoner_ByName objSBN, Game_ById objGBI, LoLStaticData_AllChampions objAC){
        System.out.println("CONSTRUCTOR - MatchHistoryPage(arg, arg, arg, arg)");
        this.objGameStaticData = new GameStaticData(); //used to set background
        this.masterFrame = frame;
        /*Set background*/
        JLabel backgroundLabel = new JLabel(objGameStaticData.getBackgroundImageIcon());
        this.masterFrame.add(backgroundLabel);
        //values carried over
        this.summonerName = objSBN.getName();
        this.summonerLevel = objSBN.getSummonerLevel();
        this.championIcons = objAC.getChampionIcons();
        this.itemIdMasterList = objGBI.getItemIdMasterList();
        this.killsList = objGBI.getKillsList();
        printCarriedValues(); //check to confirm necessary values have been carried over successfully
        System.out.println("END - MatchHistoryPage(arg, arg, arg, arg)\n");
        
        //check to see if the champion icons are correct
        backgroundLabel.setLayout(new FlowLayout());
        for(int i = 0; i < championIcons.size(); i++){
            backgroundLabel.add(new JLabel(championIcons.get(i)));
        }
        this.masterFrame.revalidate();
    }
    
    private void printCarriedValues(){
        System.out.println("METHOD - MatchHistoryPage/printCarriedValues()\n    Carried over values:");
        System.out.println("        Name: " + this.summonerName);
        System.out.println("        Level: " + this.summonerLevel);
        if(!this.championIcons.isEmpty()){
            System.out.println("        championIcons has been initialized.");
        }
        else{
            System.out.println("        championIcons has NOT been initialized.");
        }
        if(!this.itemIdMasterList.isEmpty()){
            System.out.println("        itemIdMasterList has been initialized.");
        }
        else{
            System.out.println("        itemIdMasterList has NOT been initialized.");
        }
        System.out.println("        Kills List: " + this.killsList);
    }
    
}