package com.rosualexandru.disertatie.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

@Service
public class RSAKeyGeneratorService {

    private static final Logger log = LoggerFactory.getLogger(RSAKeyGeneratorService.class);

    private static final int KEY_SIZE = 2048;

    /**
     * Generates an RSA key pair (public and private keys) and saves them to files.
     */
    public void generateRSAKeys(String targetDirectory) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            saveKeyToFile(targetDirectory, "publicKey.pem", encodeKey(publicKey.getEncoded()));
            saveKeyToFile(targetDirectory, "privateKey.pem", encodeKey(privateKey.getEncoded()));

            System.out.println("✅ RSA Key Pair Generated Successfully!");
        } catch (IOException | NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
    }


    /**
     * Converts byte[] to Base64 encoded String.
     *
     * @param key The byte array of the key.
     * @return Base64 encoded string.
     */
    private String encodeKey(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * Saves the key to a file in PEM format.
     *
     * @param targetDirectory The name of the directory to save the files.
     * @param fileName        The name of the file to save.
     * @param key             The Base64-encoded key.
     * @throws IOException If an error occurs while writing the file.
     */
    private void saveKeyToFile(String targetDirectory, String fileName, String key) throws IOException {
        Utils.createDirectory(targetDirectory);
        String filePath = Utils.getFolderPath(targetDirectory) + File.separator + fileName;

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("-----BEGIN RSA KEY-----\n");
            fileWriter.write(key);
            fileWriter.write("\n-----END RSA KEY-----\n");
        }
        System.out.println("Saved Key: " + filePath);
    }

    public static void main(String[] args) {
        RSAKeyGeneratorService rsaKeyGeneratorService = new RSAKeyGeneratorService();
        rsaKeyGeneratorService.generateRSAKeys("certificates");
    }
}
