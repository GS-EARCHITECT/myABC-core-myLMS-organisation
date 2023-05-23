package department_mgmt.deptt_faculty_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_DEPTT_FACULTY_DETAILS database table.
 * 
 */
@Embeddable
public class LMSDepttFacultyDetailsPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "FACULTY_SEQ_NO")
	private long facultySeqNo;

	@Column(name = "DEPTT_SEQ_NO")
	private long depttSeqNo;

	public LMSDepttFacultyDetailsPK() {
	}

	public long getFacultySeqNo() {
		return this.facultySeqNo;
	}

	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public long getDepttSeqNo() {
		return this.depttSeqNo;
	}

	public void setDepttSeqNo(long depttSeqNo) {
		this.depttSeqNo = depttSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSDepttFacultyDetailsPK)) {
			return false;
		}
		LMSDepttFacultyDetailsPK castOther = (LMSDepttFacultyDetailsPK) other;
		return (this.facultySeqNo == castOther.facultySeqNo) && (this.depttSeqNo == castOther.depttSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.facultySeqNo ^ (this.facultySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.depttSeqNo ^ (this.depttSeqNo >>> 32)));

		return hash;
	}

	public LMSDepttFacultyDetailsPK(long facultySeqNo, long depttSeqNo) {
		super();
		this.facultySeqNo = facultySeqNo;
		this.depttSeqNo = depttSeqNo;
	}

}