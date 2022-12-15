package task12;

public class InsertCommand implements Command{
    StringBuilder str;
    StringBuilder lastStr;

    public InsertCommand(StringBuilder str)
    {
        this.str = str;
    }

    public void execute(String str, int...args)
    {
        lastStr = new StringBuilder(this.str);
        this.str.insert(args[0], str);
    }

    public void undo()
    {
        str.replace(0, str.length(), lastStr.toString());
    }

}
