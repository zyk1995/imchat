package in.anandm.apps.service;

import java.util.List;

/**
 * Created by zyk on 2017/5/15.
 */
public interface RoomService {

    String createSingleRoom(String otherName,String creator);
    void addRoomRelation(String roomId,List<String> usersId);
}
