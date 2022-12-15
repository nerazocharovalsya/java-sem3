package task12;

public class DeleteCommand implements Command{
    StringBuilder str;
    StringBuilder lastStr;

    public DeleteCommand(StringBuilder str) {
        this.str = str;
    }

    public void execute(String str, int...args)
    {
        lastStr = new StringBuilder(this.str);
        this.str.delete(args[0], args[1]);
    }

    public void undo()
    {
        str.replace(0, str.length(), lastStr.toString());
    }
}
