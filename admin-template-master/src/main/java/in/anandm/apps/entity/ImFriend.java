package in.anandm.apps.entity;

import javax.persistence.*;

/**
 * Created by zyk on 2017/5/8.
 */
@Entity
@Table(name = "im_friend", schema = "wechat", catalog = "")
public class ImFriend {
    private String friendId;

    private String fdLoginId;
    private String fdNickName;
    private String groupId;

    @Basic
    @Column(name = "groupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Id
    @Column(name = "friendId")
    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }


    @Basic
    @Column(name = "fdLoginId")
    public String getFdLoginId() {
        return fdLoginId;
    }

    public void setFdLoginId(String fdLoginId) {
        this.fdLoginId = fdLoginId;
    }

    @Basic
    @Column(name = "fdNickName")
    public String getFdNickName() {
        return fdNickName;
    }

    public void setFdNickName(String fdNickName) {
        this.fdNickName = fdNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImFriend)) return false;

        ImFriend imFriend = (ImFriend) o;

        if (getFriendId() != null ? !getFriendId().equals(imFriend.getFriendId()) : imFriend.getFriendId() != null)
            return false;
        if (getFdLoginId() != null ? !getFdLoginId().equals(imFriend.getFdLoginId()) : imFriend.getFdLoginId() != null)
            return false;
        if (getFdNickName() != null ? !getFdNickName().equals(imFriend.getFdNickName()) : imFriend.getFdNickName() != null)
            return false;
        return getGroupId() != null ? getGroupId().equals(imFriend.getGroupId()) : imFriend.getGroupId() == null;
    }

    @Override
    public int hashCode() {
        int result = getFriendId() != null ? getFriendId().hashCode() : 0;
        result = 31 * result + (getFdLoginId() != null ? getFdLoginId().hashCode() : 0);
        result = 31 * result + (getFdNickName() != null ? getFdNickName().hashCode() : 0);
        result = 31 * result + (getGroupId() != null ? getGroupId().hashCode() : 0);
        return result;
    }
}
