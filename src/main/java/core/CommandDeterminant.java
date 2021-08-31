package core;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Unknown;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Определяет команду
 *
 * @author Артур Куприянов
 * @version 1.1.0
 */
public class CommandDeterminant {
    private static String[] splitMessage;
//    private static ArrayList<String> userCrypto = new ArrayList();
//    public static void setUserCrypto(String ticket) {
//        userCrypto.add(ticket);
//    }
//
//    public static ArrayList<String> getUserCrypto() {
//        return userCrypto;
//    }

    public static String[] getSplitMessage() {
        return splitMessage;
    }
    public static String[] split(Message message){
        String txt = message.getText();
        txt = txt.replace(","," ");
        txt= txt.replaceAll("\\s+"," ");

        return txt.split(" ");

    }

    public static Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getText();

        for (Command command : commands
        ) {
                if (command.name.equals(body)||command.name.equals(split(message)[0])) {
                    splitMessage = split(message);
                    return command;
                }
        }

        return new Unknown("unknown");
    }

}
