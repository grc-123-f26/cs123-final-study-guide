import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class StudyGuideTest {

    /**
     * Builds a linked list from the given values, in order, and returns its head.
     */
    private static ListNode list(int... values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }
        return head;
    }

    // =====================================================================
    // Problem 1: sumOddIndexes
    // =====================================================================

    @Test
    public void sumOddIndexes_studyGuideExample() {
        // index:  0    1    2     3     4     5     6     7     8
        //         4 -> 8 -> 15 -> 16 -> 23 -> 42 -> 11 -> 29 -> 34
        // odd:         8          16          42          29
        ListNode head = list(4, 8, 15, 16, 23, 42, 11, 29, 34);
        assertEquals(95, StudyGuide.sumOddIndexes(head));
    }

    @Test
    public void sumOddIndexes_singleNode() {
        // index:  0
        //         17
        // odd:    (none)
        ListNode head = list(17);
        assertEquals(0, StudyGuide.sumOddIndexes(head));
    }

    @Test
    public void sumOddIndexes_twoNodes() {
        // index:  0     1
        //         31 -> -6
        // odd:          -6
        ListNode head = list(31, -6);
        assertEquals(-6, StudyGuide.sumOddIndexes(head));
    }

    @Test
    public void sumOddIndexes_evenLengthWithNegatives() {
        // index:  0     1     2     3      4    5
        //         -5 -> 12 -> -9 -> -14 -> 3 -> 27
        // odd:          12          -14         27
        ListNode head = list(-5, 12, -9, -14, 3, 27);
        assertEquals(25, StudyGuide.sumOddIndexes(head));
    }

    @Test
    public void sumOddIndexes_allOddIndexValuesNegative() {
        // index:  0     1     2     3      4    5
        //         40 -> -3 -> 22 -> -18 -> 7 -> -11
        // odd:          -3          -18         -11
        ListNode head = list(40, -3, 22, -18, 7, -11);
        assertEquals(-32, StudyGuide.sumOddIndexes(head));
    }

    @Test
    public void sumOddIndexes_repeatedValuesAtEvenIndexesIgnored() {
        // index:  0     1     2     3     4
        //         13 -> -7 -> 13 -> -7 -> 13
        // odd:          -7          -7
        ListNode head = list(13, -7, 13, -7, 13);
        assertEquals(-14, StudyGuide.sumOddIndexes(head));
    }

    // =====================================================================
    // Problem 2: maxOfLastThree
    // =====================================================================

    @Test
    public void maxOfLastThree_studyGuideExample() {
        // 7 -> 3 -> 19 -> 21 -> 14 -> 33 -> 8 -> [26 -> 11 -> 5]
        // last 3: 26, 11, 5
        ListNode head = list(7, 3, 19, 21, 14, 33, 8, 26, 11, 5);
        assertEquals(26, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_largestIsLastValue() {
        // 50 -> -2 -> [6 -> 3 -> 19]
        // last 3: 6, 3, 19   (50 is not in the last 3)
        ListNode head = list(50, -2, 6, 3, 19);
        assertEquals(19, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_largestIsThirdToLast() {
        // 8 -> -40 -> [77 -> 12 -> -5]
        // last 3: 77, 12, -5
        ListNode head = list(8, -40, 77, 12, -5);
        assertEquals(77, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_exactlyFourValues() {
        // 99 -> [14 -> -3 -> 6]
        // last 3: 14, -3, 6   (99 is not in the last 3)
        ListNode head = list(99, 14, -3, 6);
        assertEquals(14, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_allNegative() {
        // -12 -> -45 -> [-7 -> -30 -> -19]
        // last 3: -7, -30, -19
        ListNode head = list(-12, -45, -7, -30, -19);
        assertEquals(-7, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_duplicateInLastThree() {
        // 5 -> 63 -> [21 -> 21 -> -8]
        // last 3: 21, 21, -8   (63 is not in the last 3)
        ListNode head = list(5, 63, 21, 21, -8);
        assertEquals(21, StudyGuide.maxOfLastThree(head));
    }

    @Test
    public void maxOfLastThree_longListWithLargerValuesEarlier() {
        // 3 -> 91 -> -4 -> 88 -> 17 -> 56 -> -22 -> [40 -> 9 -> 34]
        // last 3: 40, 9, 34
        ListNode head = list(3, 91, -4, 88, 17, 56, -22, 40, 9, 34);
        assertEquals(40, StudyGuide.maxOfLastThree(head));
    }

    // =====================================================================
    // Problem 3: sumEvenLeaves
    // =====================================================================

    @Test
    public void sumEvenLeaves_studyGuideExample() {
        //            12
        //          /    \
        //         6      18
        //        / \    /  \
        //       4   8  16   20
        //      /              \
        //     3                22
        // leaves: 3, 8, 16, 22   even leaves: 8, 16, 22
        TreeNode root = new TreeNode(12,
                new TreeNode(6,
                        new TreeNode(4, new TreeNode(3), null),
                        new TreeNode(8)),
                new TreeNode(18,
                        new TreeNode(16),
                        new TreeNode(20, null, new TreeNode(22))));
        assertEquals(46, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_singleEvenNode() {
        //     14
        // leaves: 14   even leaves: 14
        TreeNode root = new TreeNode(14);
        assertEquals(14, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_singleOddNode() {
        //     9
        // leaves: 9   even leaves: (none)
        TreeNode root = new TreeNode(9);
        assertEquals(0, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_noEvenLeavesButEvenBranches() {
        //         10
        //        /  \
        //       7    20
        //           /
        //          13
        // leaves: 7, 13   even leaves: (none)
        // (10 and 20 are even, but they are branches)
        TreeNode root = new TreeNode(10,
                new TreeNode(7),
                new TreeNode(20, new TreeNode(13), null));
        assertEquals(0, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_negativeValues() {
        //           5
        //         /   \
        //       -8     11
        //       / \      \
        //     -3   -6     40
        // leaves: -3, -6, 40   even leaves: -6, 40
        // (-8 is even, but it is a branch)
        TreeNode root = new TreeNode(5,
                new TreeNode(-8, new TreeNode(-3), new TreeNode(-6)),
                new TreeNode(11, null, new TreeNode(40)));
        assertEquals(34, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_zigzagChain() {
        //     2
        //      \
        //       15
        //      /
        //    24
        //      \
        //      -10
        // leaves: -10   even leaves: -10
        TreeNode root = new TreeNode(2, null,
                new TreeNode(15,
                        new TreeNode(24, null, new TreeNode(-10)),
                        null));
        assertEquals(-10, StudyGuide.sumEvenLeaves(root));
    }

    @Test
    public void sumEvenLeaves_fullTreeIncludingZeroLeaf() {
        //            31
        //          /    \
        //        17      6
        //       /  \    /  \
        //      44  12  0   -2
        // leaves: 44, 12, 0, -2   even leaves: 44, 12, 0, -2
        TreeNode root = new TreeNode(31,
                new TreeNode(17, new TreeNode(44), new TreeNode(12)),
                new TreeNode(6, new TreeNode(0), new TreeNode(-2)));
        assertEquals(54, StudyGuide.sumEvenLeaves(root));
    }

    // =====================================================================
    // Problem 4: sumOddBranches
    // =====================================================================

    @Test
    public void sumOddBranches_studyGuideExample() {
        //            15
        //          /    \
        //         9      4
        //        / \    /  \
        //       8   11 21   30
        //      / \       \
        //     2   6       23
        // branches: 15, 9, 4, 8, 21   odd branches: 15, 9, 21
        TreeNode root = new TreeNode(15,
                new TreeNode(9,
                        new TreeNode(8, new TreeNode(2), new TreeNode(6)),
                        new TreeNode(11)),
                new TreeNode(4,
                        new TreeNode(21, null, new TreeNode(23)),
                        new TreeNode(30)));
        assertEquals(45, StudyGuide.sumOddBranches(root));
    }

    @Test
    public void sumOddBranches_singleOddNode() {
        //     27
        // branches: (none, 27 is a leaf)
        TreeNode root = new TreeNode(27);
        assertEquals(0, StudyGuide.sumOddBranches(root));
    }

    @Test
    public void sumOddBranches_onlyRootIsBranch() {
        //        33
        //       /  \
        //     -5    18
        // branches: 33   odd branches: 33
        // (-5 is odd, but it is a leaf)
        TreeNode root = new TreeNode(33, new TreeNode(-5), new TreeNode(18));
        assertEquals(33, StudyGuide.sumOddBranches(root));
    }

    @Test
    public void sumOddBranches_noOddBranchesButOddLeaves() {
        //         16
        //        /  \
        //       8    22
        //      / \     \
        //     3   9     41
        // branches: 16, 8, 22   odd branches: (none)
        // (3, 9, and 41 are odd, but they are leaves)
        TreeNode root = new TreeNode(16,
                new TreeNode(8, new TreeNode(3), new TreeNode(9)),
                new TreeNode(22, null, new TreeNode(41)));
        assertEquals(0, StudyGuide.sumOddBranches(root));
    }

    @Test
    public void sumOddBranches_zigzagChain() {
        //     7
        //      \
        //       -3
        //       /
        //     12
        //     /
        //    5
        // branches: 7, -3, 12   odd branches: 7, -3
        // (5 is odd, but it is a leaf)
        TreeNode root = new TreeNode(7, null,
                new TreeNode(-3,
                        new TreeNode(12, new TreeNode(5), null),
                        null));
        assertEquals(4, StudyGuide.sumOddBranches(root));
    }

    @Test
    public void sumOddBranches_negativeOddBranches() {
        //            -11
        //           /   \
        //         -7     20
        //         / \    / \
        //       14  -1 -9   6
        //             \
        //              35
        // branches: -11, -7, 20, -1   odd branches: -11, -7, -1
        // (-9 and 35 are odd, but they are leaves)
        TreeNode root = new TreeNode(-11,
                new TreeNode(-7,
                        new TreeNode(14),
                        new TreeNode(-1, null, new TreeNode(35))),
                new TreeNode(20, new TreeNode(-9), new TreeNode(6)));
        assertEquals(-19, StudyGuide.sumOddBranches(root));
    }

    // =====================================================================
    // Problem 5: countOccurrences
    // =====================================================================

    @Test
    public void countOccurrences_studyGuideExample() {
        // 4 -> 34 -> 4 -> 16 -> 4 -> 16 -> 29 -> 8 -> 8
        // { 4: 3, 8: 2, 16: 2, 29: 1, 34: 1 }
        ListNode head = list(4, 34, 4, 16, 4, 16, 29, 8, 8);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(4, 3);
        expected.put(8, 2);
        expected.put(16, 2);
        expected.put(29, 1);
        expected.put(34, 1);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    @Test
    public void countOccurrences_singleNode() {
        // 42
        // { 42: 1 }
        ListNode head = list(42);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(42, 1);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    @Test
    public void countOccurrences_allSameValue() {
        // 7 -> 7 -> 7 -> 7
        // { 7: 4 }
        ListNode head = list(7, 7, 7, 7);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(7, 4);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    @Test
    public void countOccurrences_allDistinct() {
        // 19 -> -3 -> 56 -> 0 -> 8
        // { 19: 1, -3: 1, 56: 1, 0: 1, 8: 1 }
        ListNode head = list(19, -3, 56, 0, 8);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(19, 1);
        expected.put(-3, 1);
        expected.put(56, 1);
        expected.put(0, 1);
        expected.put(8, 1);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    @Test
    public void countOccurrences_negativesAndZeroNotAdjacent() {
        // -4 -> 10 -> 0 -> -4 -> 25 -> 0 -> 10 -> -4
        // { -4: 3, 10: 2, 0: 2, 25: 1 }
        ListNode head = list(-4, 10, 0, -4, 25, 0, 10, -4);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(-4, 3);
        expected.put(10, 2);
        expected.put(0, 2);
        expected.put(25, 1);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    @Test
    public void countOccurrences_repeatsAtBothEnds() {
        // 61 -> 3 -> 3 -> -12 -> 61
        // { 61: 2, 3: 2, -12: 1 }
        ListNode head = list(61, 3, 3, -12, 61);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(61, 2);
        expected.put(3, 2);
        expected.put(-12, 1);
        assertEquals(expected, StudyGuide.countOccurrences(head));
    }

    // =====================================================================
    // Problem 6: higherRange
    // =====================================================================

    @Test
    public void higherRange_studyGuideExample() {
        // List: 7 -> 8 -> -2 -> 9 -> 21
        //       range: 21 - -2 = 23
        //
        // Tree:          12
        //              /    \
        //             6      18
        //            / \    /
        //           4   16 8
        //       range: 18 - 4 = 14
        ListNode head = list(7, 8, -2, 9, 21);
        TreeNode root = new TreeNode(12,
                new TreeNode(6, new TreeNode(4), new TreeNode(16)),
                new TreeNode(18, new TreeNode(8), null));
        assertEquals("list", StudyGuide.higherRange(head, root));
    }

    @Test
    public void higherRange_treeWins() {
        // List: 30 -> 25 -> 41 -> 28
        //       range: 41 - 25 = 16
        //
        // Tree:          3
        //              /   \
        //           -15     9
        //              \   / \
        //              27 44  -6
        //       range: 44 - -15 = 59
        ListNode head = list(30, 25, 41, 28);
        TreeNode root = new TreeNode(3,
                new TreeNode(-15, null, new TreeNode(27)),
                new TreeNode(9, new TreeNode(44), new TreeNode(-6)));
        assertEquals("tree", StudyGuide.higherRange(head, root));
    }

    @Test
    public void higherRange_singleNodeList() {
        // List: 100
        //       range: 100 - 100 = 0
        //
        // Tree:     5
        //          / \
        //         2   8
        //       range: 8 - 2 = 6
        ListNode head = list(100);
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(8));
        assertEquals("tree", StudyGuide.higherRange(head, root));
    }

    @Test
    public void higherRange_singleNodeTree() {
        // List: -9 -> 4
        //       range: 4 - -9 = 13
        //
        // Tree:     64
        //       range: 64 - 64 = 0
        ListNode head = list(-9, 4);
        TreeNode root = new TreeNode(64);
        assertEquals("list", StudyGuide.higherRange(head, root));
    }

    @Test
    public void higherRange_treeIsNotABinarySearchTree() {
        // List: -100 -> 50 -> 3
        //       range: 50 - -100 = 150
        //
        // Tree:          20
        //              /    \
        //            -1      5
        //            / \      \
        //          88   12    -70
        //       range: 88 - -70 = 158
        // (the max is NOT the rightmost node and the min is NOT the leftmost)
        ListNode head = list(-100, 50, 3);
        TreeNode root = new TreeNode(20,
                new TreeNode(-1, new TreeNode(88), new TreeNode(12)),
                new TreeNode(5, null, new TreeNode(-70)));
        assertEquals("tree", StudyGuide.higherRange(head, root));
    }

    @Test
    public void higherRange_allNegative() {
        // List: -8 -> -50 -> -3 -> -27
        //       range: -3 - -50 = 47
        //
        // Tree:       -10
        //            /   \
        //         -14     -2
        //            \
        //            -30
        //       range: -2 - -30 = 28
        ListNode head = list(-8, -50, -3, -27);
        TreeNode root = new TreeNode(-10,
                new TreeNode(-14, null, new TreeNode(-30)),
                new TreeNode(-2));
        assertEquals("list", StudyGuide.higherRange(head, root));
    }

    // =====================================================================
    // Problem 7: higherAverage
    // =====================================================================

    @Test
    public void higherAverage_studyGuideExample() {
        // List: 7 -> 8 -> -2 -> 9 -> 21
        //       average: 43 / 5 = 8.6
        //
        // Tree:          12
        //              /    \
        //             6      18
        //            / \    /
        //           4   8  16
        //       average: 64 / 6 = 10.67
        ListNode head = list(7, 8, -2, 9, 21);
        TreeNode root = new TreeNode(12,
                new TreeNode(6, new TreeNode(4), new TreeNode(8)),
                new TreeNode(18, new TreeNode(16), null));
        assertEquals("tree", StudyGuide.higherAverage(head, root));
    }

    @Test
    public void higherAverage_listWins() {
        // List: 40 -> 55 -> -5 -> 70
        //       average: 160 / 4 = 40.0
        //
        // Tree:     10
        //          /  \
        //         3    22
        //             /
        //           -8
        //       average: 27 / 4 = 6.75
        ListNode head = list(40, 55, -5, 70);
        TreeNode root = new TreeNode(10,
                new TreeNode(3),
                new TreeNode(22, new TreeNode(-8), null));
        assertEquals("list", StudyGuide.higherAverage(head, root));
    }

    @Test
    public void higherAverage_singleNodes() {
        // List: 7
        //       average: 7 / 1 = 7.0
        //
        // Tree:     -3
        //       average: -3 / 1 = -3.0
        ListNode head = list(7);
        TreeNode root = new TreeNode(-3);
        assertEquals("list", StudyGuide.higherAverage(head, root));
    }

    @Test
    public void higherAverage_bothNegative() {
        // List: -20 -> 15 -> -35 -> 4 -> -9
        //       average: -45 / 5 = -9.0
        //
        // Tree:     -1
        //          /  \
        //        -6    2
        //       average: -5 / 3 = -1.67
        ListNode head = list(-20, 15, -35, 4, -9);
        TreeNode root = new TreeNode(-1, new TreeNode(-6), new TreeNode(2));
        assertEquals("tree", StudyGuide.higherAverage(head, root));
    }

    @Test
    public void higherAverage_listWinsByLessThanOne() {
        // List: 12 -> 7 -> -4 -> 24
        //       average: 39 / 4 = 9.75
        //
        // Tree:      9
        //          /   \
        //        20     14
        //        /     /
        //       3     0
        //       average: 46 / 5 = 9.2
        // (integer division would make both averages 9)
        ListNode head = list(12, 7, -4, 24);
        TreeNode root = new TreeNode(9,
                new TreeNode(20, new TreeNode(3), null),
                new TreeNode(14, new TreeNode(0), null));
        assertEquals("list", StudyGuide.higherAverage(head, root));
    }

    @Test
    public void higherAverage_treeWinsByLessThanOne() {
        // List: 13 -> 0 -> 6
        //       average: 19 / 3 = 6.33
        //
        // Tree:      15
        //           /  \
        //         -2    8
        //         /
        //        6
        //       average: 27 / 4 = 6.75
        // (integer division would make both averages 6)
        ListNode head = list(13, 0, 6);
        TreeNode root = new TreeNode(15,
                new TreeNode(-2, new TreeNode(6), null),
                new TreeNode(8));
        assertEquals("tree", StudyGuide.higherAverage(head, root));
    }
}