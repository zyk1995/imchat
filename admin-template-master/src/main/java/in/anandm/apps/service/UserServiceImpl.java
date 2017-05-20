package in.anandm.apps.service;

import in.anandm.apps.dao.UserDao;
import in.anandm.apps.dto.GroupDto;
import in.anandm.apps.entity.FdGroup;
import in.anandm.apps.entity.ImFriend;
import in.anandm.apps.entity.ImUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zyk on 2017/5/8.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public String getPasswordByLoginId(String loginId) {
        ImUser user = userDao.getUserByLoginId(loginId);
        if(user != null){
            return  user.getPassword();
        }
        else{
            return "";
        }
    }

    @Override
    public List<ImFriend> getFriendList(String groupId) {
        return userDao.getFriendList(groupId);
    }

    @Override
    public List<GroupDto> getGroupList(String loginId) {
        ImUser user = userDao.getUserByLoginId(loginId);
        List<FdGroup> gpList = userDao.getGroupList(user.getUserId());
        List<GroupDto> gpDtoList = new ArrayList<GroupDto>();
        for(FdGroup gp:gpList){
            GroupDto dto = new GroupDto();
            BeanUtils.copyProperties(gp,dto);

            dto.setFdList(userDao.getFriendList(dto.getGroupId()));
            gpDtoList.add(dto);
        }
        return gpDtoList;
    }

    @Override
    public ImUser getUserByLoginId(String loginId) {
        return userDao.getUserByLoginId(loginId);
    }

    @Override
    public boolean register(ImUser user) {
        ImUser test = userDao.getUserByLoginId(user.getLoginId());
        if(test != null) {
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean addFriend(String groupId, ImUser friend) {
        ImFriend imfd = new ImFriend();
        imfd.setFdLoginId(friend.getLoginId());
        imfd.setFdNickName(friend.getNickname());
        imfd.setGroupId(groupId);
        imfd.setFriendId(UUID.randomUUID().toString());
        return false;
    }

}
