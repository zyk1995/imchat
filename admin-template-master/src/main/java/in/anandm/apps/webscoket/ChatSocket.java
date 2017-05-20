package in.anandm.apps.webscoket;

import in.anandm.apps.entity.ImUser;
import net.sf.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zyk on 2017/5/13.
 */
@ServerEndpoint("/ChatSocket")
public class ChatSocket {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Set<ChatSocket> sockets = new HashSet<ChatSocket>();
    private static List<String> nickNames = new ArrayList<String>();
    private Session session;//当前聊天人session
    private ImUser user;//当前聊天人
    private String nickName;
    private static Map<String, Session> map = new HashMap<String, Session>();

    /**
     * 用户接入
     * @param session 可选
     * @throws IOException
     */
    @OnOpen
    public  void onOpen(Session session) throws IOException{
        this.session = session;
        sockets.add(this);
        String queryString = session.getQueryString();    //获取请求连接后面的值,输入汉字会有乱码,实际项目中使用账户ID
        this.nickName = queryString.substring(queryString.indexOf("=") + 1); //当前聊天人loginId
        System.out.println("用户"+this.nickName+"接入");
        nickNames.add(this.nickName);//储存当前聊天人loginId

        map.put(nickName,session);
    }
    /**
     * 发送消息时调用
     * @param session
     * @param msg
     * @throws IOException
     */
    @OnMessage
    public  void receive(Session session,String msg) throws IOException{
        System.out.println("接收到来自用户的消息" + msg);

        //把用户发来的消息解析为JSON对象
        JSONObject obj = JSONObject.fromObject(msg);
        //向JSON对象中添加发送时间
        obj.put("date", df.format(new Date()));

        boolean flag = false;
        for(String to:nickNames){
            if(to.equals(obj.get("to"))){
                Session se = map.get(to);
                obj.put("isSelf", false);
                se.getAsyncRemote().sendText(obj.toString());
                flag = true;
                break;
            }
        }

        if(!flag){
            obj.put("nickname",obj.get("to"));
            obj.put("content","该用户已离线");
            obj.put("isSelf", false);
            session.getAsyncRemote().sendText(obj.toString());
        }
        System.out.println(obj.toString());
    }

    /**
     * 关闭网页时调用
     * @param session
     * @throws IOException
     */
    @OnClose
    public  void onClose(Session session) throws  IOException{
        sockets.remove(this);
        nickNames.remove(this.nickName);
        System.out.println(this.nickName+"退出聊天室");

    }
    /**
     * 用户连接异常
     * @param t
     */
    @OnError
    public  void onError(Throwable t) {
        System.out.println("用户连接异常");
    }

}
