package core;

import com.vk.api.sdk.objects.messages.Message;

import java.io.IOException;

public class Commander {

    /**
     * Обработка сообщений, получаемых через сервис Вконтакте. Имеет ряд дополнительной информации.
     * @param message сообщение (запрос) пользователя
     */
    public static void execute(Message message) throws IOException {
        CommandDeterminant.getCommand(CommandManager.getCommands(), message).exec(message);
    }

}
