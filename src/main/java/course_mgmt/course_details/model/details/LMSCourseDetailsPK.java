package course_mgmt.course_details.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SALES_MASTER database table.
 * 
 */
@Embeddable
public class LMSCourseDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146250022254553535L;

	@Column(name = "course_seq_no")
	private Long courseseqno;
	
    @Column(name = "subject_seq_no")
	private Long subjectseqno;
	
	public Long getCourse_seq_no() {
		return courseseqno;
	}

	public void setCourse_seq_no(Long course_seq_no) {
		this.courseseqno = course_seq_no;
	}

	public Long getSubject_Seq_no() {
		return subjectseqno;
	}

	public void setSubject_Seq_no(Long subject_Seq_no) {
		this.subjectseqno = subject_Seq_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseseqno == null) ? 0 : courseseqno.hashCode());
		result = prime * result + ((subjectseqno == null) ? 0 : subjectseqno.hashCode());
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
		LMSCourseDetailsPK other = (LMSCourseDetailsPK) obj;
		if (courseseqno == null) {
			if (other.courseseqno != null)
				return false;
		} else if (!courseseqno.equals(other.courseseqno))
			return false;
		if (subjectseqno == null) {
			if (other.subjectseqno != null)
				return false;
		} else if (!subjectseqno.equals(other.subjectseqno))
			return false;
		return true;
	}

	public LMSCourseDetailsPK(Long courseseqno, Long subjectseqno) {
		super();
		this.courseseqno = courseseqno;
		this.subjectseqno = subjectseqno;
	}

	public LMSCourseDetailsPK() {
		super();
	}

		
}