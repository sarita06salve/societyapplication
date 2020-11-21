package webitm.ibase.model;

import org.springframework.stereotype.Component;

@Component
public class MemberCmd 
{
	private SocietyMember societyMember;
	private JointMember jointMember;
	
	public SocietyMember getSocietyMember() {
		return societyMember;
	}
	public void setSocietyMember(SocietyMember societyMember) {
		this.societyMember = societyMember;
	}
	public JointMember getJointMember() {
		return jointMember;
	}
	public void setJointMember(JointMember jointMember) {
		this.jointMember = jointMember;
	}
}
