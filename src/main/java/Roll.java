/**
 * @author xza
 */
public class Roll
{
    private final int[] dice;

    public Roll(final int... dice)
    {
        this.dice = dice;
    }

    public int[] dice()
    {
        return dice;
    }
}
