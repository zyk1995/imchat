package in.anandm.apps.service;

import in.anandm.apps.dto.GroupDto;
import in.anandm.apps.entity.ImFriend;
import in.anandm.apps.entity.ImUser;

import java.util.List;

/**
 * Created by zyk on 2017/5/8.
 */
public interface UserService {
    String getPasswordByLoginId(String loginId);
    List<ImFriend> getFriendList(String groupId);
    List<GroupDto> getGroupList(String loginId);
    ImUser getUserByLoginId(String loginId);
    boolean register(ImUser user);
    boolean addFriend(String groupId, ImUser friend);
}

