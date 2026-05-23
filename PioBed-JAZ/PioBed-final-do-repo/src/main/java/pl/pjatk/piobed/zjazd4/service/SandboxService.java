package pl.pjatk.piobed.zjazd4.service;

import org.springframework.stereotype.Service;

@Service
public class SandboxService {

    public String throwException() {
        throw new RuntimeException("Exception from SandboxService");
    }
}
