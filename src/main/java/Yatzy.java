import java.util.Arrays;

public class Yatzy
{

    public static final int NUMBERS = 6;
    public static final int DICES = 5;

    public int chance()
    {
        return Arrays.stream(dice).sum();
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[NUMBERS];
        for (int die : dice)
        {
            counts[die - 1]++;
        }
        for (int i = 0; i < NUMBERS; i++)
        {
            if (counts[i] == DICES)
            {
                return 50;
            }
        }
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        if (d1 == 1)
        {
            sum++;
        }
        if (d2 == 1)
        {
            sum++;
        }
        if (d3 == 1)
        {
            sum++;
        }
        if (d4 == 1)
        {
            sum++;
        }
        if (d5 == 1)
        {
            sum++;
        }

        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        if (d1 == 2)
        {
            sum += 2;
        }
        if (d2 == 2)
        {
            sum += 2;
        }
        if (d3 == 2)
        {
            sum += 2;
        }
        if (d4 == 2)
        {
            sum += 2;
        }
        if (d5 == 2)
        {
            sum += 2;
        }
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5)
    {
        int s;
        s = 0;
        if (d1 == 3)
        {
            s += 3;
        }
        if (d2 == 3)
        {
            s += 3;
        }
        if (d3 == 3)
        {
            s += 3;
        }
        if (d4 == 3)
        {
            s += 3;
        }
        if (d5 == 3)
        {
            s += 3;
        }
        return s;
    }

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dice = new int[DICES];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int fours()
    {
        int sum;
        sum = 0;
        for (int at = 0; at < DICES; at++)
        {
            if (dice[at] == 4)
            {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < DICES; i++)
        {
            if (dice[i] == 5)
            {
                s = s + 5;
            }
        }
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < DICES; at++)
        {
            if (dice[at] == NUMBERS)
            {
                sum = sum + NUMBERS;
            }
        }
        return sum;
    }

    public static int scorePair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[NUMBERS];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int at;
        for (at = 0; at < NUMBERS; at++)
        {
            if (counts[NUMBERS - at - 1] >= 2)
            {
                return (NUMBERS - at) * 2;
            }
        }
        return 0;
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[NUMBERS];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < NUMBERS; i += 1)
        {
            if (counts[NUMBERS - i - 1] >= 2)
            {
                n++;
                score += (NUMBERS - i);
            }
        }
        if (n == 2)
        {
            return score * 2;
        }
        else
        {
            return 0;
        }
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < NUMBERS; i++)
        {
            if (tallies[i] >= 4)
            {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[NUMBERS];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < NUMBERS; i++)
        {
            if (t[i] >= 3)
            {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
        {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1 && tallies[5] == 1)
        {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[NUMBERS];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != NUMBERS; i += 1)
        {
            if (tallies[i] == 2)
            {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != NUMBERS; i += 1)
        {
            if (tallies[i] == 3)
            {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3)
        {
            return _2_at * 2 + _3_at * 3;
        }
        else
        {
            return 0;
        }
    }
}
