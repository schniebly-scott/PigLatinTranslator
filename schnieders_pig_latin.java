import java.util.*;
import java.text.*;
public class schnieders_pig_latin
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        builder(s);
        System.out.println("\nWould you like to enter a new sentence? (1=yes or 2=no)");
        int choice=s.nextInt();
        s.nextLine();
        if(choice==1)
            builder(s);
        else if(choice==2)
            System.exit(0);
        else
            System.out.print("Not a choice");
    }
    public static void builder(Scanner s) 
    {
        Random r = new Random();
        
        String sentence;
        
        int word, lastSpace;
        char temp1;
        lastSpace = 0;
        word = 0;
        System.out.print("Enter a sentence to translate into pig latin:  ");
        sentence = s.nextLine();
        for (int x=0; x<sentence.length(); x++)
        {
            temp1 = sentence.charAt(x);
            if (temp1 == ' ')
            {
                word +=1;
            }
        }
        word += 1;
        String[] words = new String[word];
        lastSpace = 0;
        word = 0;
        
        for (int x=0; x<sentence.length(); x++)
        {
            temp1 = sentence.charAt(x);
            if (temp1 == ' ')
            {
                words[word] = sentence.substring(lastSpace, x);
                lastSpace = x+1;
                word +=1;
            }
        }
        words[word] = sentence.substring(lastSpace, sentence.length());
        
        for (int x = 0;x<words.length; x++)
        {
            pigWord(words[x], x);
            
        }
        
    }
    
    public static void pigWord(String word, int pos)
    {
        char[] letters = new char[word.length()+2];
        char temp1 = ' ';
        char temp2 = ' ';
        char temp3 = ' ';
        int tempTrack;
        tempTrack = 1;
        word = word.toLowerCase();
        boolean cut = false;
        int letterPos = 0;
        for (int x=0;x<word.length(); x++)
        {
            if (word.charAt(x) == 'a' || word.charAt(x) == 'e' || word.charAt(x) == 'i' || word.charAt(x) == 'o' || word.charAt(x) == 'u')
            {
                
                cut = true;
            }
            if (cut == true)
            {
                letters[letterPos] = word.charAt(x);
                letterPos += 1;
            }
            else
            {
                if (tempTrack == 1)
                {
                    temp1 = word.charAt(x);
                }
                else if (tempTrack == 2)
                {
                    temp2 = word.charAt(x);
                }
                else if (tempTrack == 3)
                {
                    temp3 = word.charAt(x);
                }
                tempTrack +=1;
            }
        }
        if (tempTrack == 4)
        {
            letters[word.length()-3] = temp1;
            letters[word.length()-2] = temp2;
            letters[word.length()-1] = temp3;
        }
        if (tempTrack == 3)
        {
            letters[word.length()-2] = temp1;
            letters[word.length()-1] = temp2;
        }
        if (tempTrack == 2)
        {
            letters[word.length()-1] = temp1;
        }
        letters[word.length()] = 'a';
        letters[word.length()+1] = 'y';
        for (int x = 0; x< letters.length; x++)
        {
            System.out.print(letters[x]);
            
        }
        System.out.print(" ");
    }
}


