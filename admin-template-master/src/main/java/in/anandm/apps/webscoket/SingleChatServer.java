package in.anandm.apps.webscoket;

import net.sf.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zyk on 2017/5/11.
 */
@ServerEndpoint("/singleChatServer")
public class SingleChatServer {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Vector<Session> room = new Vector<Session>();

    private static List<String> names = new ArrayList<String>();              //储存所有的联系人下姓名
    /**
     * 用户接入
     * @param session 可选
     */
    @OnOpen
    public void onOpen(Session session){
        System.out.println("用户接入");
        room.addElement(session);
    }

    /**
     * 接收到来自用户的消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("接收到来自用户的消息" + message);

        //把用户发来的消息解析为JSON对象
        JSONObject obj = JSONObject.fromObject(message);
        //向JSON对象中添加发送时间
        obj.put("date", df.format(new Date()));
        //遍历聊天室中的所有会话
        for(Session se : room){
            //设置消息是否为自己的
            obj.put("isSelf", se.equals(session));
            //发送消息给远程用户
            se.getAsyncRemote().sendText(obj.toString());
        }
    }

    /**
     * 用户断开
     * @param session
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("用户断开");
        room.remove(session);
    }

    /**
     * 用户连接异常
     * @param t
     */
    @OnError
    public void onError(Throwable t){
        System.out.println("用户连接异常");
    }
}

