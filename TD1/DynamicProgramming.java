public class DynamicProgramming {

    public static void main(String [] args) {

        Permutations("ABC");
    }

    public static void Permutations(String uniqueCharStr){

        //Initialize the memoization table
        boolean[][] a = new boolean[uniqueCharStr.length()][uniqueCharStr.length()];

        for (int len = 2; len <= uniqueCharStr.length(); len++){
            for (int i = 0; i <= uniqueCharStr.length()-len; i++){
                int j = i + len - 1;
                if (len == 2){

                    //Generate all the permutation of substring of length 2
                    System.out.println(uniqueCharStr.charAt(i) + "" + uniqueCharStr.charAt(j));
                }else {
                    //Check if the permutations have already been computed for a substring
                    if (!a[i][j]){
                        for (int k = i; k <= j; k++){
                            uniqueCharStr = swap(uniqueCharStr, i, k);

                            generatePermutations(uniqueCharStr,a,i+1,j);

                            uniqueCharStr = swap(uniqueCharStr, i ,k);
                        }
                        //Mark this substring as proceeded
                        a[i][j] = true;
                    }
                }
            }
        }

       /* for (int i = 0; i < uniqueCharStr.length(); i++){
            a[i][i] = true;
        }*/

        //Generate all the permutations
        generatePermutations(uniqueCharStr,a,0,uniqueCharStr.length()-1);
    }

   public static void generatePermutations(String uniqueCharStr, boolean[][] a, int i, int j){
        if (i == j - 1){
            System.out.println(uniqueCharStr);
        }else {

            //Check if the permutations have already been computed for a substring
            if (!a[i][j]){
                for (int k = i; k <= j; k++){

                    uniqueCharStr = swap(uniqueCharStr,i,k);

                    //Using the recursive way to go through all the substring uniqueCharStr[i+1...j]
                    generatePermutations(uniqueCharStr,a,i+1,j);

                    //Swap the characters back to the original format
                    uniqueCharStr = swap(uniqueCharStr,i, k);
                }
                //Mark this substring as proceeded
                a[i][j]  = true;
            }
        }
    }
    private static String swap(String uniqueCharStr, int i, int j){
        char[] a = uniqueCharStr.toCharArray();
        char ch;
        ch      = a[i];
        a[i]    = a[j];
        a[j]    = ch;

        return new String(a);
    }

}
