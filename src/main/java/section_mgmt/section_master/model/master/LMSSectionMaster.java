package section_mgmt.section_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_SECTION_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_SECTION_MASTER")
public class LMSSectionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LMS_SECTION_SEQUENCE")
	@SequenceGenerator(name = "LMS_SECTION_SEQUENCE", sequenceName = "LMS_SECTION_SEQUENCE", allocationSize = 1)
	@Column(name = "SECTION_SEQ_NO")
	private long sectionSeqNo;

	@Column(name = "COURSE_SEQ_NO")
	private Long courseSeqNo;

	@Column(name = "SECTION_ID")
	private String sectionId;

	public LMSSectionMaster() {
	}

	public long getSectionSeqNo() {
		return sectionSeqNo;
	}

	public void setSectionSeqNo(long sectionSeqNo) {
		this.sectionSeqNo = sectionSeqNo;
	}

	public Long getCourseSeqNo() {
		return courseSeqNo;
	}

	public void setCourseSeqNo(Long courseSeqNo) {
		this.courseSeqNo = courseSeqNo;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public LMSSectionMaster(long sectionSeqNo, Long courseSeqNo, String sectionId) {
		super();
		this.sectionSeqNo = sectionSeqNo;
		this.courseSeqNo = courseSeqNo;
		this.sectionId = sectionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseSeqNo == null) ? 0 : courseSeqNo.hashCode());
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + (int) (sectionSeqNo ^ (sectionSeqNo >>> 32));
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
		LMSSectionMaster other = (LMSSectionMaster) obj;
		if (courseSeqNo == null) {
			if (other.courseSeqNo != null)
				return false;
		} else if (!courseSeqNo.equals(other.courseSeqNo))
			return false;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (sectionSeqNo != other.sectionSeqNo)
			return false;
		return true;
	}

}