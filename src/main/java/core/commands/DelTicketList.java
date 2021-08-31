package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.CommandDeterminant;
import core.modules.CryptoParser;
import core.modules.UserList;
import vk.VKManager;

import java.io.IOException;

public class DelTicketList extends Command {
    public DelTicketList(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        CryptoParser cp = new CryptoParser();
        UserList userList = VKManager.getUserList();
        String[] splitMessage = CommandDeterminant.getSplitMessage();
        for (int i = 1; i < splitMessage.length; i++) {
            userList.getUser(VKManager.getUserID()).delUserTickets(splitMessage[i]);
        }
        new VKManager().sendMessage("Ваша крипта: "+userList.getUser(VKManager.getUserID()).getUserTickets());
    }
}
