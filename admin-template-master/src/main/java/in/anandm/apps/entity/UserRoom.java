package in.anandm.apps.entity;

import javax.persistence.*;

/**
 * Created by zyk on 2017/5/8.
 */
@Entity
@Table(name = "user_room", schema = "wechat", catalog = "")
public class UserRoom {
    private String id;
    private String userId;
    private String roomId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "roomId")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoom userRoom = (UserRoom) o;

        if (id != null ? !id.equals(userRoom.id) : userRoom.id != null) return false;
        if (userId != null ? !userId.equals(userRoom.userId) : userRoom.userId != null) return false;
        if (roomId != null ? !roomId.equals(userRoom.roomId) : userRoom.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }
}
