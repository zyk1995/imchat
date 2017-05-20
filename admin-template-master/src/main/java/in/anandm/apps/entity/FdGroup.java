package in.anandm.apps.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zyk on 2017/5/9.
 */
@Entity
@Table(name = "fd_group", schema = "wechat", catalog = "")
public class FdGroup {
    private String groupId;
    private String groupName;
    private String userId;

    @Id
    @Column(name = "groupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FdGroup fdGroup = (FdGroup) o;

        if (groupId != null ? !groupId.equals(fdGroup.groupId) : fdGroup.groupId != null) return false;
        if (groupName != null ? !groupName.equals(fdGroup.groupName) : fdGroup.groupName != null) return false;
        if (userId != null ? !userId.equals(fdGroup.userId) : fdGroup.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

}
