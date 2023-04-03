public class PermuteString {
    public static void main(String[] args) {
        // Call the Permutations function with input
        Permutations("abc");
    }

    // Part 2: Dynamic programming

    // Function to swap two characters in a
    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;

        return String.valueOf(b);
    }

    // Function to initiate the generation of permutations
    public static void Permutations(String uniqueCharStr) {
        int len = uniqueCharStr.length();
        // Call the generatePermutation function with start = 0 and end index len
        generatePermutation(uniqueCharStr, 0, len);
    }

    // Function to generate permutations recursively
    public static void generatePermutation(String uniqueCharStr, int start, int end) {
        if (start == end - 1)
            // If start index is equal to end index minus 1, print the uniqueCharStr
            System.out.println(uniqueCharStr);
        else {
            for (int i = 2; i < end; i++) {
                // Swap the characters at start and i indices
                uniqueCharStr = swapString(uniqueCharStr, start, i);

                // Recursively call the generatePermutation function with start index incremented by 1
                generatePermutation(uniqueCharStr, start + 1, end);

                // Swap the characters at start and i indices again to backtrack
                uniqueCharStr = swapString(uniqueCharStr, start, i);
            }
        }
    }
}
