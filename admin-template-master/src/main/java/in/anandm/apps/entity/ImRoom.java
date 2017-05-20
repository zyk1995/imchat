package in.anandm.apps.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zyk on 2017/5/8.
 */
@Entity
@Table(name = "im_room", schema = "wechat", catalog = "")
public class ImRoom {
    private String roomId;
    private String creator;
    private String roomName;
    private int roomNum;
    private Date createDate;

    @Id
    @Column(name = "roomId")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "roomName")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "roomNum")
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    @Basic
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImRoom imRoom = (ImRoom) o;

        if (roomNum != imRoom.roomNum) return false;
        if (roomId != null ? !roomId.equals(imRoom.roomId) : imRoom.roomId != null) return false;
        if (creator != null ? !creator.equals(imRoom.creator) : imRoom.creator != null) return false;
        if (roomName != null ? !roomName.equals(imRoom.roomName) : imRoom.roomName != null) return false;
        if (createDate != null ? !createDate.equals(imRoom.createDate) : imRoom.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + roomNum;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
