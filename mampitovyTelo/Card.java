package mampitovyTelo;
import java.util.ArrayList;

public class Card {
    
    public Card(short unicodeColor, String value){
        this.unicodeColor = unicodeColor;
        this.value = value;
    }   

    public int getValue(){
        if(this.value == "K")
            return 13;
        if(this.value == "D")
            return 12;
        if(this.value == "J")
            return 11;
        if(this.value == "A")
            return 1;

        return Integer.parseInt(this.value);
    }
    
    private char color(){
        return (char)this.unicodeColor;
    }

    public boolean isEquals(Card card){
        
        return (this.unicodeColor == card.unicodeColor && this.value == card.value);
    }

    public boolean isEqualsValues(Card card){
        
        return (this.value == card.value);
    }

    public void print(){
        System.out.printf("|%s  %c|\n",this.value,this.color());
    }

    public static boolean differentsColors(ArrayList<Card> Cards){
        int current_card_index = 0;
        for(Card card : Cards){
            for(int i = 0; i < Cards.size(); i++){
                if(current_card_index != i){
                    if(card.color() == Cards.get(i).color()){

                        return false;
                    }
                }
            }
            current_card_index++;
        }

        return true;
    }

    private short unicodeColor = 0;
    private String value = "" ;
}


