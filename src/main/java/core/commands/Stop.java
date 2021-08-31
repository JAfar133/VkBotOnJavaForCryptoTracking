package core.commands;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.Event;
import vk.VKManager;

import java.io.IOException;

public class Stop extends Command {
    public Stop(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) throws IOException {
        new VKManager().sendMessage("");
    }
}
