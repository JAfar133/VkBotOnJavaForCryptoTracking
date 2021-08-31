package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.CryptoParser;
import vk.VKManager;

import java.io.IOException;

public class GetTicketList extends Command {
    public GetTicketList(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        CryptoParser cp = new CryptoParser();
        new VKManager().sendMessage("Доступная крипта: \n"+cp.getCryptoArrayList());
    }
}
