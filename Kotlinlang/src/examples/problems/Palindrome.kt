package examples.problems

/**
 * Your task is to implement a palindrome test.
 *
 * A string is called a palindrome when it reads the same way left-to-right
 * and right-to-left.
 *
 * See http://en.wikipedia.org/wiki/Palindrome
 *
 * LeetCode-面试算法经典-Kotlin实现
 *
 * @author Edwin.Wu
 * @version 2018/2/5 下午6:16
 * @since JDK1.8
 */
fun isPalindrome(s: String): Boolean {
    // Write your solution here

    var left = 0
    var right = s.length - 1

    var l: Char
    var r: Char

    while (left < right) {
        while (left < s.length && !isAlphanumericCharacters(s[left])) { // 从左向右找数字与字母
            left++
        }
        while (right >= 0 && !isAlphanumericCharacters(s[right])) { // 从右向左找数字与字母
            right--
        }
        if (left < right) {
            l = s[left]
            r = s[right]
            if (l == r) {
                left++
                right--
            } else {
                return false
            }
        }
    }
    return true
}

private fun isAlphanumericCharacters(c: Char): Boolean {
    return c in '0'..'9' || c in 'a'..'z' || c in 'A'..'Z'
}
