package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.CommandDeterminant;
import core.modules.CryptoParser;
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
        String[] splitMessage = CommandDeterminant.getSplitMessage();
        for (int i = 1; i < splitMessage.length; i++) {
            if(cp.getCryptoList().getCrypto(splitMessage[i])==null||CommandDeterminant.getUserCrypto().contains(splitMessage[i])) continue;
            else CommandDeterminant.setUserCrypto(cp.getCryptoList().getCrypto(splitMessage[i]).getTiket());
        }
        new VKManager().sendMessage("Вы ввели: "+CommandDeterminant.getUserCrypto()+"\t (2)<Узнать свой курс>", message.getUserId());
    }
}
