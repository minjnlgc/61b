public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> w = wordToDeque(word);
        return isPalindromeHelper(w);
    }

    private boolean isPalindromeHelper(Deque<Character> w) {
        if (w.size() <= 1) {
            return true;
        } else if (w.removeLast() != w.removeFirst()) {
            return false;
        }
        return isPalindromeHelper(w);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> w = wordToDeque(word);
        return isPalindromeCCHelper(w, cc);
    }

    private boolean isPalindromeCCHelper(Deque<Character> w, CharacterComparator cc) {
        if (w.size() <= 1) {
            return true;
        } else if (!cc.equalChars(w.removeFirst(), w.removeLast())) {
            return false;
        }
        return isPalindromeCCHelper(w, cc);
    }
}
