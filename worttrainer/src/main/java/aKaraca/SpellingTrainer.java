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
    //false: last comparision resulted in a Wrong, true: last comparision resulted in a Correct
    private boolean lastScore;
    /**
     * Contructor for the Rechtschreibtrainer class
     */
    public SpellingTrainer() {
        listLength = 10;
        wordList = new String[listLength][2];
        wordList[0][0] = "Haus";
        wordList[0][1] = "https://www.hanse-haus.de/fileadmin/_processed_/8/b/csm_fertighaus-variant-25-192-hero_967fcf8499.jpg";
        wordList[1][0] = "Auto";
        wordList[1][1] = "https://image.stern.de/35341676/t/JG/v1/w1440/r1.7778/-/e-auto-elektroauto-vw-id-7-pro-s.jpg";
        wordList[2][0] = "Baum";
        wordList[2][1] = "https://biberberti.com/wp-content/uploads/2021/08/04-px-alter-Baum.jpg";
        wordList[3][0] = "Laptop";
        wordList[3][1] = "https://gfx3.senetic.com/akeneo-catalog/f/6/e/6/f6e64a862fe63da6a23c2f90d2e0ed5f3f3a1775_1626671_5V8_00009_image1.jpg";
        wordList[4][0] = "Tisch";
        wordList[4][1] = "https://www.steinershopping.at/media/mf_webp/jpg/media/catalog/product/cache/3c0b12cec63083e386fe3f6df73f2f21/vv_img/2/4/240_abc_1_1_1.webp";
        wordList[5][0] = "Hund";
        wordList[5][1] = "https://www.tierschutzbund.de/fileadmin/_processed_/7/c/csm_schwarzer_Hund_auf_Wiese_c_xkunclova-Shutterstock_01_5566a80d25.jpg";
        wordList[6][0] = "Katze";
        wordList[6][1] = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Cat_August_2010-4.jpg/640px-Cat_August_2010-4.jpg";
        wordList[7][0] = "Maus";
        wordList[7][1] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeATPVhMq73dqTDjrg3kGpyISJOcm7VOxyFw&s";
        wordList[8][0] = "Buch";
        wordList[8][1] = "https://wasliestdu.de/dateien/styles/680x380/public/artikel/die-leere-nach-einem-guten-buch.jpg?itok=JmYo77_N";
        wordList[9][0] = "Stift";
        wordList[9][1] = "https://einguterplan.de/wp-content/uploads/2024/08/EGStift-farbiger-Hintergrund-1024x1024.jpg";

        lastScore = false;

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
            lastScore = true;
        }else{
            playerStats[1]++;
            lastScore = false;
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

    public void resetScore(){
        playerStats[0] = 0;
        playerStats[1] = 0;
        playerStats[2] = 0;
    }

    public boolean getLastScoreChange(){
        return lastScore;
    }
}
