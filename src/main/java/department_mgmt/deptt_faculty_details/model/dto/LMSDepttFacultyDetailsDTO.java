package department_mgmt.deptt_faculty_details.model.dto;

import java.io.Serializable;

public class LMSDepttFacultyDetailsDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7113872998538615045L;
	private long facultySeqNo;
	private long depttSeqNo;

	public long getFacultySeqNo() {
		return facultySeqNo;
	}

	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public long getDepttSeqNo() {
		return depttSeqNo;
	}

	public void setDepttSeqNo(long depttSeqNo) {
		this.depttSeqNo = depttSeqNo;
	}

	public LMSDepttFacultyDetailsDTO(long facultySeqNo, long depttSeqNo) {
		super();
		this.facultySeqNo = facultySeqNo;
		this.depttSeqNo = depttSeqNo;
	}

	public LMSDepttFacultyDetailsDTO() {
		super();
	}

}
