package vk;

import com.vk.api.sdk.objects.messages.*;
import common.Date;
import core.commands.ServiceCommand;

import java.util.*;

/**
 * @author Arthur Kupriyanov
 */
public class Event {
    private Keyboard keyboard1 = new Keyboard();
    public Keyboard getKeyboard1() {
        return keyboard1;
    }
public Event() {

    List<List<KeyboardButton>> allKey = new ArrayList<>();
    List<KeyboardButton> line1 = new ArrayList<>();
    List<KeyboardButton> line2 = new ArrayList<>();

    line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Начать").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
    line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Стоп (not working)").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
    line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("1").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
    line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("2").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
    line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("3").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
    allKey.add(line1);
    allKey.add(line2);
    keyboard1.setButtons(allKey);
    }
}
