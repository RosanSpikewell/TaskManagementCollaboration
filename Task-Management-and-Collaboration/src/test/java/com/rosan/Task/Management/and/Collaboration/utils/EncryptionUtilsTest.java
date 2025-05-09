package com.rosan.Task.Management.and.Collaboration.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionUtilsTest {
    private EncryptionUtils encryptionUtils = new EncryptionUtils();
    @Test
    void verifyPassowrd() {
        Boolean result = encryptionUtils.verifyPassowrd("Test@123","$2a$12$pFMackuWMMU7ghhWkm7fwueLbdlq.VpdOVuDVlDD810jLfyKhBCu2");
        assertTrue(result);
    }
}