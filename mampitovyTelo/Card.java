package mampitovyTelo;

public class Card {
    private short unicodeColor = 0;
    private String value = "" ;

    public Card(short unicodeColor, String value){
        this.unicodeColor = unicodeColor;
        this.value = value;
    }   

    private char color(){
        return (char)this.unicodeColor;
    }

    public boolean isEquals(Card card){
        if(this.unicodeColor == card.unicodeColor && this.value == card.value){
            return true;
        }
        return false;
    }

    public void print(){
        System.out.printf("|%s  %c|",this.value,this.color());
    }
}


