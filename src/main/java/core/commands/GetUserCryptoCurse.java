package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.CommandDeterminant;
import core.modules.CryptoParser;
import vk.VKManager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GetUserCryptoCurse extends Command {
    public GetUserCryptoCurse(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        SimpleDateFormat onlyHour = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        ArrayList<String> userTicket = CommandDeterminant.getUserCrypto();
        CryptoParser cp = new CryptoParser();
        cp.setCryptoPrice(cp.getCryptoPrices());
        cp.setCryptoChanges(cp.getCryptoChanges());
        new VKManager().sendMessage("ваша крипта на "+onlyHour.format(date)+":\n"+userTicket,message.getUserId());
        for (String ticket:userTicket) {
            new VKManager().sendMessage(cp.getCryptoList().getCrypto(ticket).toString(),message.getUserId());
        }
    }
}
