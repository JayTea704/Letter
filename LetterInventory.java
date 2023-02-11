//Programmer: John Bedlington
//Date: 2/9/2023
//Class: CS &145
//Assignment: Lab 3
//This program will implement a class called LetterInventory that
// can be used to keep track of an inventory of letters of the alphabet.

public class LetterInventory {

    private int size;
    private int[] elemData;
    private String original;

    public static final int MAX_NUM = 26;

    // constructs an inventory for the given string input, and the
    // total count of letters will be recorded
    public LetterInventory (String data) {

        elemData = new int[MAX_NUM];
        data = data.toLowerCase();
        original = data;

        //for loop counts the # of letters in the string
        for (int i = 0; i < data.length(); i++){

            if (Character.isLetter(data.charAt(i))){
                elemData[data.charAt(i) - 'a']++;

                if(data.charAt(i) == 'q'){
                    elemData['u' - 'a']++;
                }
            size++;
            }

        }

    } //end of LetterInventory method

    // returns the sum of chars in inventory
    public int size(){
        return size;
    }

    //returns original string
    public String getOriginal(){
        return original;
    }

    //return true if inventory is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //returns the count of given character in the inventory
    //throws IllegalArgumentException when the letter is a non-alphabetic letter
    public int get(char letter){

        if(!Character.isLetter(letter)) {
            throw new IllegalArgumentException("letter: " + letter);
            return elemData[Character.toLowerCase(letter) - 'a'];
        }

    } //end of get method

    //return a string of sorted letters of alphabet, surrounded with square brackets
    public String toString(){

        String result = "[";

        for (int i = 0; i < MAX_NUM; i++){
            for (int k = 0; k < elemData[i]; k++)
                result += (char)('a' + i);
        }
        return result + "]";
    } // end of toString method

    // take in a char and an int, change the number of count for a single alphabet
    //throws IllegalArgumentException when the letter is a non-alphabetic letter or when it is negative
    public void set(char letter, int value){
        if (!Character.isLetter(letter) || value < 0)
            throw new IllegalArgumentException("letter: " + letter + ", value: " + value);
            size += value - elemData[Character.toLowerCase(letter) - 'a'];
            elemData[Character.toLowerCase(letter) - 'a'] = value;

    }// end of set method

    //creates a LetterInventory object then combines with another into one large inventory
    public LetterInventory add(LetterInventory other){
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < MAX_NUM; i++)
            sum.elemData[i] = this.elemData[i] + other.elemData[i];
        sum.size = this.size + other.size;
        return sum;
    } //end of addLetterInventory method

    // return a LetterInventory object of difference of other two
    // will return null if output is less than 0
    public LetterInventory subtract(LetterInventory other){

        LetterInventory result = new LetterInventory("");

        for (int i = 0; i < MAX_NUM; i++){
            result.elemData[i] = this.elemData[i] -
                    other.elemData[i];
            if (result.elemData[i] < 0)
                return null;
            result.size += result.elemData[i];
        }
        return result;
    } //end of subtract Letterinventory method
} //end of class
