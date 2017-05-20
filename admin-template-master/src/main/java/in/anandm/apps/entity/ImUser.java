package in.anandm.apps.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by zyk on 2017/5/8.
 */
@Entity
@Table(name = "im_user", schema = "wechat", catalog = "")
public class ImUser {

    private String userId;

    private String loginId;

    private String password;

    private String nickname;

    @Id
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "loginId")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImUser imUser = (ImUser) o;

        if (userId != null ? !userId.equals(imUser.userId) : imUser.userId != null) return false;
        if (loginId != null ? !loginId.equals(imUser.loginId) : imUser.loginId != null) return false;
        if (password != null ? !password.equals(imUser.password) : imUser.password != null) return false;
        if (nickname != null ? !nickname.equals(imUser.nickname) : imUser.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImUser{" +
                "userId='" + userId + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
