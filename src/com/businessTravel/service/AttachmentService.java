package com.businessTravel.service;

import com.businessTravel.domain.Attachment;

public interface AttachmentService {
       void saveAttachment(Attachment attachment);
       Attachment getOneByName(String fileName);
}
