import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = new Yatzy(new Roll(2, 3, 4, 5, 1)).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(new Roll(3, 3, 4, 5, 1)).chance());
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(new Roll(4, 4, 4, 4, 4)).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(new Roll(6, 6, 6, 6, 6)).yatzy());
        assertEquals(0, new Yatzy(new Roll(6, 6, 6, 6, 3)).yatzy());
    }

    @Test public void test_1s() {
        assertTrue(new Yatzy(new Roll(1,2,3,4,5)).ones() == 1);
        assertTrue(new Yatzy(new Roll(2,1,3,4,5)).ones() == 1);
        assertEquals(2, new Yatzy(new Roll(1,2,1,4,5)).ones());
        assertEquals(0, new Yatzy(new Roll(6,2,2,4,5)).ones());
        assertEquals(4, new Yatzy(new Roll(1,2,1,1,1)).ones());
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(new Roll(1,2,3,2,6)).twos());
        assertEquals(10, new Yatzy(new Roll(2,2,2,2,2)).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(new Roll(1,2,3,2,3)).threes());
        assertEquals(6, new Yatzy(new Roll(3,2,1,2,3)).threes());
        assertEquals(12, new Yatzy(new Roll(2,3,3,3,3)).threes());
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, new Yatzy(new Roll(4,4,5,5,4)).fours());
        assertEquals(12, new Yatzy(new Roll(4,4,5,4,5)).fours());
        assertEquals(12, new Yatzy(new Roll(4,4,4,5,5)).fours());
        assertEquals(8, new Yatzy(new Roll(4,4,5,5,5)).fours());
        assertEquals(4, new Yatzy(new Roll(4,5,5,5,5)).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(new Roll(4,4,4,5,5)).fives());
        assertEquals(15, new Yatzy(new Roll(4,4,5,5,5)).fives());
        assertEquals(20, new Yatzy(new Roll(4,5,5,5,5)).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(new Roll(4,4,4,5,5)).sixes());
        assertEquals(6, new Yatzy(new Roll(4,4,6,5,5)).sixes());
        assertEquals(18, new Yatzy(new Roll(6,5,6,6,5)).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(new Roll(3, 4, 3, 5, 6)).pair());
        assertEquals(0, new Yatzy(new Roll(1, 4, 3, 5, 6)).pair());
        assertEquals(10, new Yatzy(new Roll(5, 3, 3, 3, 5)).pair());
        assertEquals(10, new Yatzy(new Roll(5, 3, 3, 5, 5)).pair());
        assertEquals(12, new Yatzy(new Roll(5, 3, 6, 6, 5)).pair());
        assertEquals(8, new Yatzy(new Roll(4, 4, 4, 6, 5)).pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(0, new Yatzy(new Roll(1, 3, 5, 4, 5)).twoPair());
        assertEquals(16, new Yatzy(new Roll(3, 3, 5, 4, 5)).twoPair());
        assertEquals(16, new Yatzy(new Roll(3, 3, 5, 5, 5)).twoPair());
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(0, new Yatzy(new Roll(3, 2, 3, 4, 5)).threeOfAKind());
        assertEquals(9, new Yatzy(new Roll(3, 3, 3, 4, 5)).threeOfAKind());
        assertEquals(15, new Yatzy(new Roll(5, 3, 5, 4, 5)).threeOfAKind());
        assertEquals(9, new Yatzy(new Roll(3, 3, 3, 3, 5)).threeOfAKind());
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, new Yatzy(new Roll(3, 3, 3, 3, 5)).fourOfAKind());
        assertEquals(0, new Yatzy(new Roll(1, 3, 3, 3, 5)).fourOfAKind());
        assertEquals(20, new Yatzy(new Roll(5, 5, 5, 4, 5)).fourOfAKind());
        assertEquals(12, new Yatzy(new Roll(3, 3, 3, 3, 3)).fourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(new Roll(1,2,3,4,5)).smallStraight());
        assertEquals(15, new Yatzy(new Roll(2,3,4,5,1)).smallStraight());
        assertEquals(0, new Yatzy(new Roll(1,2,2,4,5)).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(new Roll(6,2,3,4,5)).largeStraight());
        assertEquals(20, new Yatzy(new Roll(2,3,4,5,6)).largeStraight());
        assertEquals(0, new Yatzy(new Roll(1,2,2,4,5)).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(new Roll(6,2,2,2,6)).fullHouse());
        assertEquals(0, new Yatzy(new Roll(2,3,4,5,6)).fullHouse());
    }

    @Test
    public void testOccurencesReturn2() {
        Yatzy yatzy = new Yatzy(new Roll(2, 1, 3, 2, 4));

        Long occurenceOfTwo = yatzy.occurences().get(2);
        assertEquals(2L, (long)occurenceOfTwo);
    }


}
