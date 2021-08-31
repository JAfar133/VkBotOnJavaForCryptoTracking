package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import core.modules.User;
import core.modules.UserList;

import java.util.Random;

/**
 * @author Arthur Kupriyanov
 */
public class VKManager {
    public static VKCore vkCore;
    static int userID;

    private static UserList userList = new UserList();
    public static UserList getUserList() {
        return userList;
    }

    public static int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {

        if(userID!=0){
        VKManager.userID = userID;
        userList.addUser(new User(userID));
            }

    }

    public void sendMessage(String msg){
        Random random = new Random();
        {
            try {
                vkCore = new VKCore();
            } catch (ApiException | ClientException e) {
                e.printStackTrace();
            }
        }
        if (msg == null){
            System.out.println("null");
            return;
        }
        try {
            System.out.println(getUserInfo(userID));
            System.out.println(getSendQuery()+" successful");
            Keyboard k = new Event().getKeyboard1();
            int randomid = random.nextInt(10000);
                vkCore.getVk().messages().send(vkCore.getActor()).message(msg)
                        .userId(userID)
                        .randomId(randomid)
                        .keyboard(k)
                        .execute();

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }

    /**
     * Обращается к VK API и получает объект, описывающий пользователя.
     * @param id идентификатор пользователя в VK
     * @return {@link UserXtrCounters} информацию о пользователе
     * @see UserXtrCounters
     */
    public static GetResponse getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
