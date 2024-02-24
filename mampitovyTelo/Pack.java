package mampitovyTelo;
import java.util.ArrayList;

public class Pack {

    public Pack(int pack_size){
        this.setcardColors();
        this.cardValuess();
        for(int i = 0; i < pack_size; i++){
            for(short color : this.cardColors){
                for(String value : this.cardValues){
                    packItems.add(new Card(color, value));
                }
            }
        }
    }

    private void setcardColors(){
        this.cardColors.add(HEART_UNICODE);
        this.cardColors.add(DIAMOND_UNICODE);
        this.cardColors.add(SPADe_UNICODE);
        this.cardColors.add(CLUB_UNICODE);
    }

    private void cardValuess(){
        this.cardValues.add("A");
        this.cardValues.add("K");
        this.cardValues.add("D");
        this.cardValues.add("J");
        for(int i = 10; i >= 2 ; i--){
            this.cardValues.add(String.valueOf(i));
        }
    }

    public ArrayList<Short> getCardColors(){

        return this.cardColors;
    }

    

    public ArrayList<String> getcardValues(){

        return this.cardValues;
    }

    public void removeCard(Card card){
        int index = 0;
        for(int i = 0; i < this.packItems.size(); i++){
            if(this.packItems.get(i).isEquals(card)){
                this.packItems.remove(index);

                return;
            }
            index++;
        }
    }

    public boolean exists(Card card){
        for(Card c : this.packItems){
            if(card.isEquals(c)){
                
                return true;
            }
        }
        return false;
    }

    private static final short HEART_UNICODE = 9829;
    private static final short DIAMOND_UNICODE = 9830; 
    private static final short SPADe_UNICODE = 9824;
    private static final short CLUB_UNICODE = 9827;

    private ArrayList<Short> cardColors = new ArrayList<Short>();
    private ArrayList<String> cardValues = new ArrayList<String>();
    public ArrayList<Card> packItems = new ArrayList<Card>();
}
