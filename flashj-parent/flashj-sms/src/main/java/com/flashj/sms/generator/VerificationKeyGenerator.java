package com.flashj.sms.generator;

/**
 * 验证key生成器
 */
public interface VerificationKeyGenerator {
    String generate(String prefix);
}
