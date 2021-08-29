package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetStart extends Command {
    public GetStart(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        SimpleDateFormat onlyHour = new SimpleDateFormat("E dd.MM.yy hh:mm:ss zzz");
        Date date = new Date();
        new VKManager().sendMessage(onlyHour.format(date)+"\nЧтобы узнать курс, введите (1)<Узнать курс> \n"+
                "Чтобы узнать курс вашей крипты нажмите (2)<Узнать свой курс>\n\n"+
                "Чтобы посмотреть список доступных криптовалют введите (3)<Посмотреть>\n\n" +
                "Чтобы добавить отслеживаемую крипту, введите \n<добавить (ваш список)>\n\n"+
                "Чтобы удалить крипту из вашего списка введите \n<удалить (ваш список)>", message.getUserId());
    }
}
