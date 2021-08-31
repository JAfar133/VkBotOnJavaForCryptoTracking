package core;

import core.commands.*;

import java.util.HashSet;

/**
 * @author Arthur Kupriyanov
 */
public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Unknown("unknown"));
        commands.add(new GetCryptoCourse("Узнать курс"));
        commands.add(new GetStart("Начать"));
        commands.add(new AddUserCrypto("добавить"));
        commands.add(new AddUserCrypto("Добавить"));
        commands.add(new GetUserCryptoCurse("Узнать свой курс"));
        commands.add(new GetTicketList("Посмотреть"));
        commands.add(new DelTicketList("удалить"));
        commands.add(new DelTicketList("Удалить"));


        commands.add(new GetCryptoCourse("1"));
        commands.add(new GetUserCryptoCurse("2"));
        commands.add(new GetTicketList("3"));
    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
