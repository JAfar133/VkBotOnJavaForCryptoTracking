package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.CommandDeterminant;
import core.modules.CryptoParser;
import core.modules.UserList;
import vk.VKCore;
import vk.VKManager;

import java.io.IOException;
import java.util.ArrayList;

public class AddUserCrypto extends Command {
    public AddUserCrypto(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        CryptoParser cp = new CryptoParser();
        UserList userList = VKManager.getUserList();
        String[] splitMessage = CommandDeterminant.getSplitMessage();
        for (int i = 1; i < splitMessage.length; i++) {
            userList.getUser(VKManager.getUserID()).setUserTickets(splitMessage[i]);
        }
        new VKManager().sendMessage("Вы ввели: "+userList.getUser(VKManager.getUserID()).getUserTickets()+"\t (2)<Узнать свой курс>");
    }
}
