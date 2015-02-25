import java.util.Arrays;

public class Yatzy
{

    public static final int NUMBERS = 6;
    public static final int DICES = 5;

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

    public int chance()
    {
        return Arrays.stream(dice).sum();
    }

    public int yatzy()
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

    public int ones()
    {
        return countValue(1);
    }

    private int countValue(final int value)
    {
        return (int) Arrays.stream(dice).filter(d -> d == value).count() * value;
    }

    public int twos()
    {
        return countValue(2);
    }

    public int threes()
    {
        return countValue(3);
    }

    public int fours()
    {
        return countValue(4);
    }

    public int fives()
    {
        return countValue(5);
    }

    public int sixes()
    {
        return countValue(6);
    }

    public int scorePair()
    {
        int[] counts = new int[NUMBERS];
        counts[dice[0] - 1]++;
        counts[dice[2-1] - 1]++;
        counts[dice[3-1] - 1]++;
        counts[dice[4-1] - 1]++;
        counts[dice[5-1] - 1]++;
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

    public int twoPair()
    {
        int[] counts = new int[NUMBERS];
        counts[dice[1-1] - 1]++;
        counts[dice[2-1] - 1]++;
        counts[dice[3-1] - 1]++;
        counts[dice[4-1] - 1]++;
        counts[dice[5-1] - 1]++;
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

    public int fourOfAKind()
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[dice[1-1] - 1]++;
        tallies[dice[2-1] - 1]++;
        tallies[dice[3-1] - 1]++;
        tallies[dice[4-1] - 1]++;
        tallies[dice[5-1] - 1]++;
        for (int i = 0; i < NUMBERS; i++)
        {
            if (tallies[i] >= 4)
            {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public int threeOfAKind()
    {
        int[] t;
        t = new int[NUMBERS];
        t[dice[1-1] - 1]++;
        t[dice[2-1] - 1]++;
        t[dice[3-1] - 1]++;
        t[dice[4-1] - 1]++;
        t[dice[5-1] - 1]++;
        for (int i = 0; i < NUMBERS; i++)
        {
            if (t[i] >= 3)
            {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public int smallStraight()
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[dice[1-1] - 1] += 1;
        tallies[dice[2-1] - 1] += 1;
        tallies[dice[3-1] - 1] += 1;
        tallies[dice[4-1] - 1] += 1;
        tallies[dice[5-1] - 1] += 1;
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

    public int largeStraight()
    {
        int[] tallies;
        tallies = new int[NUMBERS];
        tallies[dice[1-1] - 1] += 1;
        tallies[dice[2-1] - 1] += 1;
        tallies[dice[3-1] - 1] += 1;
        tallies[dice[4-1] - 1] += 1;
        tallies[dice[5-1] - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1 && tallies[5] == 1)
        {
            return 20;
        }
        return 0;
    }

    public int fullHouse()
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[NUMBERS];
        tallies[dice[1-1] - 1] += 1;
        tallies[dice[2-1] - 1] += 1;
        tallies[dice[3-1] - 1] += 1;
        tallies[dice[4-1] - 1] += 1;
        tallies[dice[5-1] - 1] += 1;

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
