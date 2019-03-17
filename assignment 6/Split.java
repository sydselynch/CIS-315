import java.util.*;
import java.io.*;

public class Split {

    static Set<String> dictionary = new HashSet<String>();
    static Boolean[] memo;
    static ArrayList<String> validString;
    static ArrayList<Boolean> splitArray;
    static Boolean[] iterSplitArray;
    static int[] validIndices;

    public static void initializeDictionary(String file) {
        File inputFile = new File(file);
        String currentLine;

        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                currentLine = scanner.next();
                dictionary.add(currentLine.trim());
            }
            scanner.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean dict(String w) {
        // Looks up given word, returns true if w in dictionary
        if (dictionary.contains(w)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean stringSplitRecursive(int i, String s) {
        int size = s.length();
        validString = new ArrayList<String>(size);

        if (i == (size)) {
            return true;
        }

        // If we've already determined a substring can be split, return true
        if (memo[i] == true) {
            return true;
        }

        for (int j = i; j < size; j++) {
            if (dict(s.substring(i, j+1)) && stringSplitRecursive(j+1, s)) {
                memo[i] = true;
                validString.add(s.substring(i, j+1));
                return true;
            }
        }

        return false;
    }

	public static boolean stringSplitIterative(String s) {
        int size = s.length();
        iterSplitArray = new Boolean[size+1];
        validString = new ArrayList<String>(size+1);
        validIndices = new int[size+1];

        // Initialize our bool array to all false
        for (int i = 0; i <= size; i++) {
            iterSplitArray[i] = false;
        }

        // Base case
        iterSplitArray[0] = true;

        for (int i = 0; i < size; i++) {
            if (iterSplitArray[i] == true) {
                for (int j = i; j < size; j++) {
                    // Valid substring in dict
                    if (dict(s.substring(i, j+1))) {
                        iterSplitArray[j+1] = true;
                        validIndices[j+1] = i;
                    }
                }
            }
        }

        for (int i = 0; i < size + 1; i++) {
            System.out.println("Current index: " + i + "Current index value " + validIndices[i]);
        }
        
		// If the word can be split, traverse backwards through valid substrings of s and build the phrase        
        if (iterSplitArray[size]) {
        	int i = size;
        	while (i > 0) {
        		validString.add(s.substring(validIndices[i], i));
        		i = validIndices[i];
        	}
        }

        // Index at size determines whether word can be split
        return iterSplitArray[size];
    }


    public static void main(String[] args) {
        initializeDictionary("diction10k.txt");
        Scanner scanner = new Scanner(System.in);
        int loops = scanner.nextInt();
        String currentWord;
        boolean canSplit;
        int count = 1;


        for (int i = 0; i < loops; i++) {
            currentWord = scanner.next();
            memo = new Boolean[currentWord.length()+1];
            for (int k = 0; k < currentWord.length(); k++) {
                memo[k] = false;
            }
            System.out.println("Phrase: " + count);
            System.out.println(currentWord);
            System.out.println("Recursive Memoization Attempt: ");

            canSplit = stringSplitRecursive(0, currentWord);
            if (canSplit) {
                System.out.println("True, the word can be split.");
                for (int j = validString.size() - 1; j >= 0; j--) {
                    System.out.print(validString.get(j) + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("False, the word cannot be split.");
            }
            System.out.println();
            System.out.println("Iterative Attempt: ");

            canSplit = stringSplitIterative(currentWord);
            if (canSplit) {
                System.out.println("True, the word can be split.");
                for (int j = validString.size() - 1; j >= 0; j--) {
                    System.out.print(validString.get(j) + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("False, the word cannot be split.");
            }
            System.out.println();
            count++;

        }
    }
}