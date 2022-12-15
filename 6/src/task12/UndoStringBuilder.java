package task12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

public class UndoStringBuilder {
    StringBuilder stringBuilder;
    ArrayList<Command> commands;

    public void undo() {
        if (commands.isEmpty()) {
            System.out.println("Нет команд для отмены");
            return;
        }
        commands.get(commands.size()-1).undo();
        commands.remove(commands.size()-1);
    }

    public UndoStringBuilder(String s){
        this.stringBuilder = new StringBuilder(s);
        commands = new ArrayList<Command>(0);
    }

    public void insert(String s, int... args){
        InsertCommand insertCommand = new InsertCommand(this.stringBuilder);
        insertCommand.execute(s, args);
        commands.add(insertCommand);
    }

    public void delete(int... args){
        DeleteCommand deleteCommand = new DeleteCommand(this.stringBuilder);
        deleteCommand.execute("NULL", args);
        commands.add(deleteCommand);
    }

    public void append(String str)
    {
        AppendCommand appendCommand = new AppendCommand(this.stringBuilder);
        appendCommand.execute(str);
        commands.add(appendCommand);
    }

    public String toString()
    {
        return stringBuilder.toString();
    }

    public boolean equals(UndoStringBuilder str)
    {
        return this.stringBuilder.equals(str);
    }

    public static void main(String[] args){
        UndoStringBuilder stringBuilder = new UndoStringBuilder("mirea");
        stringBuilder.append("hello");
        stringBuilder.undo();
        System.out.println(stringBuilder.toString());
    }
}
