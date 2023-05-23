package course_mgmt.course_details.model.dto;

import java.io.Serializable;

public class LMSCourseDetailsDTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4312019857721435237L;
	private Long courseSeqNo;
	private Long subjectSeqNo;
	public Long getCourseSeqNo() {
		return courseSeqNo;
	}
	public void setCourseSeqNo(Long courseSeqNo) {
		this.courseSeqNo = courseSeqNo;
	}
	public Long getSubjectSeqNo() {
		return subjectSeqNo;
	}
	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public LMSCourseDetailsDTO(Long courseSeqNo, Long subjectSeqNo) {
		super();
		this.courseSeqNo = courseSeqNo;
		this.subjectSeqNo = subjectSeqNo;
	}
	public LMSCourseDetailsDTO() {
		super();
	}
	
	}
