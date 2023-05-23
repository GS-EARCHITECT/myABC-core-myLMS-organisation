package section_mgmt.section_details.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import section_mgmt.section_details.model.details.LMSSectionDetails;
import section_mgmt.section_details.model.details.LMSSectionDetailsPK;
import section_mgmt.section_details.model.dto.LMSSectionDetailsDTO;
import section_mgmt.section_details.model.repo.LMSSectionDetailsRepo;

@Service("sectionDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSectionDetailsService implements I_LMSSectionDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(LMSSectionDetailsService.class);

	@Autowired
	private LMSSectionDetailsRepo sectionDetailsRepo;

	public LMSSectionDetailsDTO newSectionDetails(LMSSectionDetailsDTO lMaster) {
		LMSSectionDetailsPK lmssectionDetailsPK = new LMSSectionDetailsPK();
		lmssectionDetailsPK.setSectionSeqNo(lMaster.getSectionSeqNo());
		lmssectionDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());
		LMSSectionDetails lmssectionDetails = null;

		if (!sectionDetailsRepo.existsById(lmssectionDetailsPK)) {
			lmssectionDetails = this.setSectionDetails(lMaster);
			lmssectionDetails.setId(lmssectionDetailsPK);
			lMaster = getSectionDetailsDTO(sectionDetailsRepo.save(lmssectionDetails));
		}

		return lMaster;
	}

	public ArrayList<LMSSectionDetailsDTO> getAllSectionDetails() {
		ArrayList<LMSSectionDetails> sectionDetailsList = (ArrayList<LMSSectionDetails>) sectionDetailsRepo.findAll();
		ArrayList<LMSSectionDetailsDTO> lMasters = new ArrayList<LMSSectionDetailsDTO>();
		lMasters = sectionDetailsList != null ? this.getSectionDetailsDTOs(sectionDetailsList) : null;
		return lMasters;
	}

	public ArrayList<LMSSectionDetailsDTO> getSelectStudents(ArrayList<Long> ids) {
		ArrayList<LMSSectionDetails> lMasters = sectionDetailsRepo.getSelectStudents(ids);
		ArrayList<LMSSectionDetailsDTO> LMSSectionDetailsDTOs = new ArrayList<LMSSectionDetailsDTO>();
		LMSSectionDetailsDTO LMSSectionDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSectionDetailsDTO = this.getSectionDetailsDTO(lMasters.get(i));
				LMSSectionDetailsDTOs.add(LMSSectionDetailsDTO);
			}
		}
		return LMSSectionDetailsDTOs;
	}

	public ArrayList<LMSSectionDetailsDTO> getStudentsForSections(ArrayList<Long> ids) {
		ArrayList<LMSSectionDetails> lMasters = sectionDetailsRepo.getStudentsForSections(ids);
		ArrayList<LMSSectionDetailsDTO> LMSSectionDetailsDTOs = new ArrayList<LMSSectionDetailsDTO>();
		LMSSectionDetailsDTO LMSSectionDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSectionDetailsDTO = this.getSectionDetailsDTO(lMasters.get(i));
				LMSSectionDetailsDTOs.add(LMSSectionDetailsDTO);
			}
		}
		return LMSSectionDetailsDTOs;
	}

	public void updSectionDetails(LMSSectionDetailsDTO lMaster) {
		LMSSectionDetailsPK lmssectionDetailsPK = new LMSSectionDetailsPK();
		lmssectionDetailsPK.setSectionSeqNo(lMaster.getSectionSeqNo());
		lmssectionDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());
		LMSSectionDetails lmssectionDetails = null;

		if (sectionDetailsRepo.existsById(lmssectionDetailsPK)) {
			lmssectionDetails = setSectionDetails(lMaster);
			lmssectionDetails.setId(lmssectionDetailsPK);
			sectionDetailsRepo.save(lmssectionDetails);
		}
		return;
	}

	public void delSelectSections(ArrayList<Long> ids) {
		sectionDetailsRepo.delSelectSections(ids);
		return;
	}

	public void delSelectStudents(ArrayList<Long> ids) {
		sectionDetailsRepo.delSelectStudents(ids);
		return;
	}

	public void delAllSectionDetails() {
		sectionDetailsRepo.deleteAll();
	}

	private ArrayList<LMSSectionDetailsDTO> getSectionDetailsDTOs(ArrayList<LMSSectionDetails> lMasters) {
		LMSSectionDetailsDTO lDTO = null;
		ArrayList<LMSSectionDetailsDTO> lMasterDTOs = new ArrayList<LMSSectionDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getSectionDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSectionDetailsDTO getSectionDetailsDTO(LMSSectionDetails lMaster) {
		LMSSectionDetailsDTO lDTO = new LMSSectionDetailsDTO();
		lDTO.setSectionSeqNo(lMaster.getId().getSectionSeqNo());
		lDTO.setStudentSeqNo(lMaster.getId().getStudentSeqNo());
		return lDTO;
	}

	private LMSSectionDetails setSectionDetails(LMSSectionDetailsDTO lDTO) {
		LMSSectionDetails lMaster = new LMSSectionDetails();
		LMSSectionDetailsPK lmssectionDetailsPK = new LMSSectionDetailsPK();
		lmssectionDetailsPK.setSectionSeqNo(lDTO.getSectionSeqNo());
		lmssectionDetailsPK.setStudentSeqNo(lDTO.getStudentSeqNo());
		lMaster.setId(lmssectionDetailsPK);
		return lMaster;
	}
}