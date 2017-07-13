package com.businessTravel.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.AttachmentDao;
import com.businessTravel.domain.Attachment;
import com.businessTravel.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentDao attachmentDao;
	
	@Override
	public void saveAttachment(Attachment attachment) {
		// TODO Auto-generated method stub
		attachmentDao.insertAttachment(attachment);
	}

	@Override
	public Attachment getOneByName(String fileName ) {
		// TODO Auto-generated method stub
		return attachmentDao.getOneByName(fileName);
	}

	
	

}
