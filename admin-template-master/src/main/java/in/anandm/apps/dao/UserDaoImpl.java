package in.anandm.apps.dao;

import in.anandm.apps.entity.FdGroup;
import in.anandm.apps.entity.ImFriend;
import in.anandm.apps.entity.ImUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zyk on 2017/5/8.
 */
@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ImUser getUserByLoginId(String loginId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ImUser.class);
        criteria.add(Restrictions.eq("loginId", loginId));
        return criteria.list().size() > 0 ? (ImUser) criteria.list().get(0) : null;
    }

    @Override
    public List<ImFriend> getFriendList(String groupId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ImFriend.class);
        criteria.add(Restrictions.eq("groupId", groupId));
        return criteria.list();
    }

    @Override
    public List<FdGroup> getGroupList(String userId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(FdGroup.class);
        criteria.add(Restrictions.eq("userId", userId));
        return criteria.list();
    }

    @Override
    public void addUser(ImUser user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void addFriend(ImFriend friend) {
        Session session = sessionFactory.getCurrentSession();
        session.save(friend);
    }


}
