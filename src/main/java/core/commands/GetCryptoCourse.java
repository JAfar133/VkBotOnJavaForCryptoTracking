package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.Crypto;
import core.modules.CryptoList;
import core.modules.CryptoParser;
import vk.VKManager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Arthur Kupriyanov
 */
public class GetCryptoCourse extends Command implements ServiceCommand {
    private CryptoList cl;

    public GetCryptoCourse(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        SimpleDateFormat onlyHour = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        CryptoParser cp = new CryptoParser();
        cp.setCryptoPrice(cp.getCryptoPrices());
        cp.setCryptoChanges(cp.getCryptoChanges());
        cl = cp.getCryptoList();
        new VKManager().sendMessage(onlyHour.format(date)+"\n");
        for (Crypto crypto: cl.getList()) {
            new VKManager().sendMessage(getCrypto(crypto.getTiket()));
        }


    }

    @Override
    public void service() {

    }

    private String getCrypto(String ticket){
        String Crypto;
        Crypto = cl.getCrypto(ticket).toString();
        return Crypto;
    }
}
