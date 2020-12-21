package lab1;

class Palindrome {
  public static void main(String[] args) {
    String palindromes = "Palindromes: ";

    for (String arg : args) {
      if (isPalindrome(arg)) {
        palindromes += arg + " ";
      }
    }

    System.out.println(palindromes);
  }


  public static String reverseString(String str) {
    String result = "";

    int length = str.length() - 1;

    for (int i = length; i >= 0; i--) {
      result += str.charAt(i);
    }

    return result;
  }


  public static boolean isPalindrome(String str) {
    return str.equals(reverseString(str));
  }
}
