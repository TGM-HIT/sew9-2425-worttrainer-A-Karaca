package aKaraca;

/**
 * SpellingTrainer Class
 * Has a List of paired words and imageURLs called Items, Select one of these Items manually or randomized.
 * Can Return the selected Item.
 * Can compare input with selected Item and adds to the players statistics.
 * @author Ali Karaca
 * @version 14-02-25
 */
public class SpellingTrainer {
    private String[][] wordList;
    private int selectedIndex;
    // 0: Correct, 1: Wrong, 2: Total
    private int[] playerStats;
    private int listLength;
    /**
     * Contructor for the Rechtschreibtrainer class
     */
    public SpellingTrainer() {
        listLength = 10;
        wordList = new String[listLength][2];
        wordList[0][0] = "Haus";
        wordList[0][1] = "URLPlaceholder";
        wordList[1][0] = "Auto";
        wordList[1][1] = "URLPlaceholder";
        wordList[2][0] = "Schule";
        wordList[2][1] = "URLPlaceholder";
        wordList[3][0] = "Stuhl";
        wordList[3][1] = "URLPlaceholder";
        wordList[4][0] = "Tisch";
        wordList[4][1] = "URLPlaceholder";
        wordList[5][0] = "Hund";
        wordList[5][1] = "URLPlaceholder";
        wordList[6][0] = "Katze";
        wordList[6][1] = "URLPlaceholder";
        wordList[7][0] = "Maus";
        wordList[7][1] = "URLPlaceholder";
        wordList[8][0] = "Buch";
        wordList[8][1] = "URLPlaceholder";
        wordList[9][0] = "Stift";
        wordList[9][1] = "URLPlaceholder";


        playerStats = new int[3];
        playerStats[0] = 0;
        playerStats[1] = 0;
        playerStats[2] = 0;

        selectedIndex = -1;
    }

    /**
     * Returns the Statistics of the player
     * @return Statistics of the player as a String
     */
    public String getStats(){
        return "Correct: " + playerStats[0] + " Wrong: " + playerStats[1] + " Total: " + playerStats[2];
    }

    /**
     * Returns the Word and URL combination of the currently selected Item
     * @return Word and URL combination as String Array
     * @throws Exception if no item is selected
     */
    public String[] getCurrentItem() throws Exception {
        if(selectedIndex == -1){
            throw new Exception("No item selected");
        }
        return wordList[selectedIndex];
    }

    /**
     * Compares the player input with the currently selected item then adds to the player stats
     * @param playerInput The input of the player as String
     * @throws Exception if no item is selected
     */
    public void compareItem(String playerInput) throws Exception {
        if(selectedIndex == -1){
            throw new Exception("No item selected");
        }
        if(wordList[selectedIndex][0].equals(playerInput)){
            playerStats[0]++;
        }else{
            playerStats[1]++;
        }
        playerStats[2]++;
    }

    /**
     * Selects the item with the given index, currently available: 0-9
     * @param index The index of the item to be selected as int
     * @throws Exception if the given index does not exist
     */
    public void selectItem(int index) throws Exception {
        if(index < 0 || index > listLength-1){
            throw new Exception("Index does not exist");
        }
        selectedIndex = index;
    }

    /**
     * Randomly selects an item
     */
    public void randomizeItem() {
        selectedIndex = (int) (Math.random() * wordList.length);
    }


}
