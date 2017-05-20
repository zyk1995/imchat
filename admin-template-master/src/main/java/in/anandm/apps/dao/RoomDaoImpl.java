package in.anandm.apps.dao;

import in.anandm.apps.entity.ImRoom;
import in.anandm.apps.entity.UserRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zyk on 2017/5/15.
 */
@Repository
public class RoomDaoImpl implements RoomDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRoom(ImRoom room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    @Override
    public void addRoomRelation(UserRoom roomRelation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(roomRelation);
    }
}
