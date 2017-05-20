package in.anandm.apps.dao;

import in.anandm.apps.entity.FdGroup;
import in.anandm.apps.entity.ImFriend;
import in.anandm.apps.entity.ImUser;

import java.util.List;

/**
 * Created by zyk on 2017/5/8.
 */

public interface UserDao {
   ImUser getUserByLoginId(String loginId);
   List<ImFriend> getFriendList(String groupId);
   List<FdGroup> getGroupList(String userId);
   void addUser(ImUser user);
   void addFriend(ImFriend friend);
}
