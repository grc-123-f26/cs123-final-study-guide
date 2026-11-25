import java.util.Map;

/**
 * Each method below corresponds to one problem on the study guide.
 * Replace the body of each method with your solution. Attempt each
 * problem on paper first!
 */
public class StudyGuide {

  /**
   * Returns the sum of all the elements in the list at odd indexes.
   * The head is at index 0.
   *
   * Example:
   * 4 -> 8 -> 15 -> 16 -> 23 -> 42 -> 11 -> 29 -> 34
   * returns 95 (8 + 16 + 42 + 29)
   *
   * @param head the head of a linked list of integers; will not be null
   * @return the sum of the elements at odd indexes, or 0 if there are none
   */
  public static int sumOddIndexes(ListNode head) {
    return 0;
  }

  /**
   * Returns the largest of only the last 3 values of the list.
   *
   * Example:
   * 7 -> 3 -> 19 -> 21 -> 14 -> 33 -> 8 -> 26 -> 11 -> 5
   * returns 26 (the last 3 values are 26, 11, 5)
   *
   * @param head the head of a linked list of integers; the list will
   *             contain at least 4 values
   * @return the largest of the last 3 values in the list
   */
  public static int maxOfLastThree(ListNode head) {
    return 0;
  }

  /**
   * Returns the sum of the leaf nodes with even values in the tree.
   * Odd nodes and branch nodes are not included.
   *
   * Example:
   *            12
   *          /    \
   *         6      18
   *        / \    /  \
   *       4   8  16   20
   *      /              \
   *     3                22
   * returns 46 (8 + 16 + 22)
   *
   * @param root the root of a binary tree of integers; will not be null
   * @return the sum of the even-valued leaf nodes, or 0 if there are none
   */
  public static int sumEvenLeaves(TreeNode root) {
      return 0;
  }

  /**
   * Returns the sum of the branch nodes with odd values in the tree.
   * Even nodes and leaf nodes are not included.
   *
   * Example:
   *            15
   *          /    \
   *         9      4
   *        / \    /  \
   *       8   11 21   30
   *      / \       \
   *     2   6       23
   * returns 45 (15 + 9 + 21)
   *
   * @param root the root of a binary tree of integers; will not be null
   * @return the sum of the odd-valued branch nodes, or 0 if there are none
   */
  public static int sumOddBranches(TreeNode root) {
    return 0;
  }

  /**
   * Returns a map containing each value in the list along with the
   * number of times it shows up.
   *
   * Example:
   * 4 -> 34 -> 4 -> 16 -> 4 -> 16 -> 29 -> 8 -> 8
   * returns { 4: 3, 8: 2, 16: 2, 29: 1, 34: 1 } (order is unimportant)
   *
   * @param head the head of a linked list of integers; will not be null
   * @return a map from each value in the list to its number of occurrences
   */
  public static Map<Integer, Integer> countOccurrences(ListNode head) {
    return null;
  }

  /**
   * Returns which has a higher range: the given linked list or the given
   * tree. The range of a data structure is the difference between its
   * highest value and its lowest value.
   *
   * Example:
   * List: 7 -> 8 -> -2 -> 9 -> 21        (range 21 - -2 = 23)
   * Tree:          12
   *              /    \
   *             6      18
   *            / \    /
   *           4   16 8                   (range 18 - 4 = 14)
   * returns "list"
   *
   * @param head the head of a linked list of integers; will not be null
   * @param root the root of a binary tree of integers; will not be null
   * @return "list" if the list has a higher range, "tree" if the tree
   *         has a higher range (there will not be a tie)
   */
  public static String higherRange(ListNode head, TreeNode root) {
    return null;
  }

  /**
   * Returns which has a higher average value: the given linked list or
   * the given tree.
   *
   * Example:
   * List: 7 -> 8 -> -2 -> 9 -> 21        (average 43 / 5 = 8.6)
   * Tree:          12
   *              /    \
   *             6      18
   *            / \    /
   *           4   8  16                  (average 64 / 6 = 10.67)
   * returns "tree"
   *
   * @param head the head of a linked list of integers; will not be null
   * @param root the root of a binary tree of integers; will not be null
   * @return "list" if the list has a higher average, "tree" if the tree
   *         has a higher average (there will not be a tie)
   */
  public static String higherAverage(ListNode head, TreeNode root) {
    return null;
  }
}