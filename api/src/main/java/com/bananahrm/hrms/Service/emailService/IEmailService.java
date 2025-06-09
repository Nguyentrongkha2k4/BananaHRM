package com.bananahrm.hrms.Service.emailService;

public interface IEmailService {
    public void sendEmail(String to, String subject, String body) throws Exception;
}
