package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Things that make words hard to read are:
        //- Occurrences of "ch", "ei", "ie" (ex. "ei" in "Receive")
        //- More than two vowels in a row (ex. "uai" in "Acquaintance")
        //- Double consonants (ex. "mm" and "tt" in "Committee")
        //In addition, sentences are hard to read if such words are close to each other.
        //
        //Calculate a score for a sentence using the following rules:
        //- 1 point for each string that makes a word hard to read
        //- 2 points for each pair of words that have difficult to read strings
        //- 1 point for two words that have difficult to read strings and are separated by one other word
        System.out.println("This is a program that evaluates the difficulty of reading a sentence in English.");
        System.out.println("Please insert a sentence! ");
	Scanner sc = new Scanner(System.in);
	String sentence = sc.nextLine();

	    int d=theTwoWords(sentence);
	    int e=theTwoWordsPlusSpace(sentence);
	    int a =theOccurences(sentence);
        int b =isDoubleConsonant(sentence);
        int c= moreThanTwoVowels(sentence);
        int total= a+b+c;
        System.out.println(e +" puncte de la cuvinte cu spatiu.");
        System.out.println(d + " puncte de la cuvinte alaturate.");
        System.out.println(total + " puncte de la reguli.");
        int raspFinal = total+d+e;
        System.out.println(raspFinal+ " este totalul!");
    }
    public static int theTwoWords (String sentence){
        String[] da = sentence.split("\\s+");
        int t=0;
        for(int x=0;x<= da.length-2;x++){
            if((theOccurences(da[x])!=0 ||isDoubleConsonant(da[x])!=0||moreThanTwoVowels(da[x])!=0)&&
                    (theOccurences(da[x+1])!=0 ||isDoubleConsonant(da[x+1])!=0||moreThanTwoVowels(da[x+1])!=0)){
                t+=2;
            }
        }
        return t;
    }
    public static int theTwoWordsPlusSpace (String sentence){
        String[] da = sentence.split("\\s+");
        int t=0;
        for(int x=0;x<= da.length-3;x++){
            if((theOccurences(da[x])!=0 ||isDoubleConsonant(da[x])!=0||moreThanTwoVowels(da[x])!=0)&&
                    (theOccurences(da[x+1])==0 ||isDoubleConsonant(da[x+1])==0||moreThanTwoVowels(da[x+1])==0)&&
            (theOccurences(da[x+2])!=0 ||isDoubleConsonant(da[x+2])!=0||moreThanTwoVowels(da[x+2])!=0))
            {
                t++;
            }
        }
        return t;
    }
    public static int theOccurences(String sentence){
        char[] caractere = sentence.toCharArray();
        int sum=0;
        int x=0;
        for( x=0 ;x<=caractere.length-2;x++) {
            if ((caractere[x] == 'c' && caractere[x+1] == 'h')||
                    (caractere[x] == 'e'&& caractere[x + 1] == 'i')||
                    (caractere[x] == 'i'&& caractere[x + 1] == 'e')){
                sum += 1;
            }
        }
        return sum;
    }
    public static int isDoubleConsonant (String sentence){
        int sum=0;
        char[] caractere = sentence.toCharArray();
        char[] consonants = {'q','w','r','t','y','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        for(int i:consonants){
            for(int x=0 ;x<=caractere.length-2;x++) {
                if (caractere[x]==caractere[x+1]&&caractere[x]==i){
                    sum += 1;
                    }
                }
            }
        return sum;
    }
    public static int moreThanTwoVowels (String sentence){
        int sum=0;
        int z=0;
        String[] cuvinte = sentence.split("\\s+");
//        char[] caractere = sentence.toCharArray();
        char[] vowels = {'e','u','i','o','a','y'};
        for(int x=0;x<=cuvinte.length-1;x++){
            char[] caractere = cuvinte[x].toCharArray();
             for(int i:vowels) {if(z==1){x++;break;}
                  for(int j:vowels){
                      for(int k:vowels){
                         for(int f=0;f<=caractere.length-3;f++){
                               if(caractere[f]==i&&
                                   caractere[f+1]==j&&
                                         caractere[f+2]==k){
                                              sum++;
                                              z++;
                               }
                         }
                      }
                  }
             }
        }
        return sum;
    }
}
