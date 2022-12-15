package task12;

public class AppendCommand implements Command {
    StringBuilder str;
    StringBuilder lastStr;

    public AppendCommand(StringBuilder str)
    {
        this.str = str;
    }

    public void execute(String str, int...args)
    {
        lastStr = new StringBuilder(this.str);
        this.str.append(str);
    }

    public void undo()
    {
        str.replace(0, str.length(), lastStr.toString());
    }

}
