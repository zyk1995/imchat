package in.anandm.apps.dao;

import in.anandm.apps.entity.ImRoom;
import in.anandm.apps.entity.UserRoom;

/**
 * Created by zyk on 2017/5/15.
 */
public interface RoomDao {
    void addRoom(ImRoom room);
    void addRoomRelation(UserRoom roomRelation);
}
