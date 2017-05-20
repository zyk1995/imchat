package in.anandm.apps.service;

import in.anandm.apps.dao.RoomDao;
import in.anandm.apps.entity.ImRoom;
import in.anandm.apps.entity.UserRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zyk on 2017/5/15.
 */
@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public String createSingleRoom(String otherName,String creator) {
        ImRoom room = new ImRoom();
        String uuid = UUID.randomUUID().toString();
        room.setRoomId(uuid);
        room.setCreateDate(new Date(new java.util.Date().getTime()));
        room.setRoomName(otherName);
        room.setCreator(creator);
        room.setRoomNum(2);
        roomDao.addRoom(room);
        return "uuid";
    }

    @Override
    public void addRoomRelation(String roomId, List<String> usersId) {
        for(String userId:usersId){
            UserRoom roomRelation = new UserRoom();
            roomRelation.setId(UUID.randomUUID().toString());
            roomRelation.setRoomId(roomId);
            roomRelation.setUserId(userId);
            roomDao.addRoomRelation(roomRelation);
        }
    }
}
