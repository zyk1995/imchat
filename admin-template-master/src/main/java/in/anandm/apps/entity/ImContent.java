package in.anandm.apps.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zyk on 2017/5/8.
 */
@Entity
@Table(name = "im_content", schema = "wechat", catalog = "")
public class ImContent {
    private String contenttId;
    private String roomId;
    private String contentCreator;
    private String content;
    private Date createTime;

    @Id
    @Column(name = "contenttId")
    public String getContenttId() {
        return contenttId;
    }

    public void setContenttId(String contenttId) {
        this.contenttId = contenttId;
    }

    @Basic
    @Column(name = "roomId")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "contentCreator")
    public String getContentCreator() {
        return contentCreator;
    }

    public void setContentCreator(String contentCreator) {
        this.contentCreator = contentCreator;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImContent imContent = (ImContent) o;

        if (contenttId != null ? !contenttId.equals(imContent.contenttId) : imContent.contenttId != null) return false;
        if (roomId != null ? !roomId.equals(imContent.roomId) : imContent.roomId != null) return false;
        if (contentCreator != null ? !contentCreator.equals(imContent.contentCreator) : imContent.contentCreator != null)
            return false;
        if (content != null ? !content.equals(imContent.content) : imContent.content != null) return false;
        if (createTime != null ? !createTime.equals(imContent.createTime) : imContent.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contenttId != null ? contenttId.hashCode() : 0;
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (contentCreator != null ? contentCreator.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
