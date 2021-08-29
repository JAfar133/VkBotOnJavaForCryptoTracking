package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.CommandDeterminant;
import core.modules.CryptoParser;
import vk.VKManager;

import java.io.IOException;

public class DelTicketList extends Command {
    public DelTicketList(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        CryptoParser cp = new CryptoParser();
        String[] splitMessage = CommandDeterminant.getSplitMessage();
        for (int i = 1; i < splitMessage.length; i++) {
            if(!CommandDeterminant.getUserCrypto().contains(splitMessage[i]))continue;
            else CommandDeterminant.getUserCrypto().remove(splitMessage[i]);
        }
        new VKManager().sendMessage("Ваша крипта: "+CommandDeterminant.getUserCrypto(), message.getUserId());
    }
}
