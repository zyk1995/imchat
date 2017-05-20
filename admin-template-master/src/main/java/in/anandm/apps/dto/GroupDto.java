package in.anandm.apps.dto;


import in.anandm.apps.entity.ImFriend;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by zyk on 2017/5/10.
 */

@ToString
@Setter
@Getter
@lombok.Data
public class GroupDto {
    private String groupId;
    private String groupName;
    private List<ImFriend> fdList;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<ImFriend> getFdList() {
		return fdList;
	}
	public void setFdList(List<ImFriend> fdList) {
		this.fdList = fdList;
	}
	@Override
	public String toString() {
		return "GroupDto [groupId=" + groupId + ", groupName=" + groupName + ", fdList=" + fdList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fdList == null) ? 0 : fdList.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupDto other = (GroupDto) obj;
		if (fdList == null) {
			if (other.fdList != null)
				return false;
		} else if (!fdList.equals(other.fdList))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}
    
    
}
