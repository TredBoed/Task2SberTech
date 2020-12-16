package com.company;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

       //About cars
       //Task 0
        ArrayList<Car> arr = new ArrayList<Car>(7);
        arr.add(new Car("Lada","Sedan"));
        arr.add(new Car("Lada","HatchBack"));
        arr.add(new Car("Mercedes","Sedan"));
        arr.add(new Car("BMW","Crossover"));
        arr.add(new Car("Ford","HatchBack"));
        arr.add(new Car("Peugeot","Crossover"));
        arr.add(new Car("Toyota","Sedan"));

        Map<String, List<Car>> items = new HashMap<String, List<Car>>();

        //Group car models by type
        for (int i =0; i< arr.size(); i++)
        {
            items.computeIfAbsent(arr.get(i).getType(), k -> new LinkedList<>()).add(arr.get(i));
        }
        printGroupsFromMap(items);

       //From presentation
        String filepath= "src\\com\\company\\Data.txt";
       //Task 1 number of various words in file
        numOfWordsInFile(filepath);
       //Task 2
        printWordsSortedByLength(filepath);
       //Task 3
        howManyWordsAppearsInFile(filepath);
       //Task 4
        reversedStrings(filepath);
       //Task 5
        reversedListIterator(filepath);
       //Task 6
        printStringsFromNums(filepath);
    }

    public static void printGroupsFromMap(Map<String, List<Car>> items)
    {
        for (Map.Entry<String, List<Car>> entry: items.entrySet())
        {
            for (Car entry2: entry.getValue())
            {
                System.out.println(entry2.getModel() + " is "+entry.getKey());
            }
            System.out.println();
        }
    }
    public static void numOfWordsInFile(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        String line;
        List<String> wordset = new LinkedList<String>();

        while(in.hasNextLine()){
            line = in.nextLine();
            String words[] = line.split(" ");

            for (String s: words)
            {
                wordset.add(s);
            }
        }
        in.close();

        System.out.println("There are: "+wordset.size()+" in file");
        System.out.println();
    }

    public static void printWordsSortedByLength(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        String line;
        List<String> wordset = new LinkedList<String>();

        while(in.hasNextLine()){
            line = in.nextLine();
            String words[] = line.split(" ");

            for (String s: words)
            {
                wordset.add(s);
            }
        }
        in.close();
    //    Java 6,7
    //    Comparator<String> byLength = new Comparator<String>(){
    //        @Override
    //        public int compare (String s1, String s2) {
    //            return s1.length () - s2.length ();
    //        }
    //    };
    //    Collections.sort(wordset, byLength);


        //Java 8
        wordset.sort((first, second) -> Integer.compare(first.length(), second.length()));

        System.out.println("Sorted file by lenght");
        System.out.println(wordset);
        System.out.println();
    }

    public static void howManyWordsAppearsInFile(String filepath) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filepath));
        String line;
        Map<String, Integer> wordset = new HashMap<String, Integer>();

        while(in.hasNextLine()){
            line = in.nextLine();
            String words[] = line.split(" ");

            for (String s: words)
            {
                if(wordset.containsKey(s))
                {
                    wordset.put(s,wordset.get(s)+1);
                }
                else
                {
                    wordset.put(s, 1);
                }
            }
        }
        in.close();

        for (String word: wordset.keySet()) {
            System.out.println(word + " - " + wordset.get(word) + " times");
        }
        System.out.println();
    }
    public static void reversedStrings(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        String line;
        ArrayList<String> wordset = new ArrayList<String>();

        while(in.hasNextLine()){
               line = in.nextLine();
                wordset.add(line);
        }
        in.close();

        for(int i=wordset.size()-1; i >= 0; i--)
        {
            System.out.println(wordset.get(i));
        }
        System.out.println();
    }

    public static <ListIteraror> void reversedListIterator(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        String line;


        ArrayList<String> wordset = new ArrayList<>();

        while(in.hasNextLine()){
            line = in.nextLine();
            String words[] = line.split(" ");

            for (String s: words)
            {
                wordset.add(s);
            }
        }
        in.close();

        ListIterator<String> listIter = new ListIterator<String>(wordset);
        for(String word : listIter) {
            System.out.println(word);
        }

        System.out.println();
    }

    public static void printStringsFromNums(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        Scanner in2 = new Scanner(System.in);

        String line;
        ArrayList<String> wordset = new ArrayList<String>();

        while(in.hasNextLine()){
            line = in.nextLine();
            wordset.add(line);
        }
        in.close();

        System.out.println("Write down num or strings with spaces (if it more than one)");
        String userInput = in2.nextLine();
        String numsOfStrings[] = userInput.split(" ");

        for(int i=0; i <= numsOfStrings.length-1; i++)
        {
            System.out.println("String ("+numsOfStrings[i]+")"+" = "+ wordset.get(Integer.parseInt(numsOfStrings[i])));
        }

        System.out.println();
    }




}
