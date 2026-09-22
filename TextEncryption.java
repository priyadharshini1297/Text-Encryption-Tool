import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class TextEncryption {

    // ================= AES =================

    static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    static String aesEncrypt(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(
                text.getBytes(StandardCharsets.UTF_8)
        );

        return Base64.getEncoder().encodeToString(encrypted);
    }

    static String aesDecrypt(String encryptedText, SecretKey key)
            throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decrypted = cipher.doFinal(
                Base64.getDecoder().decode(encryptedText)
        );

        return new String(decrypted, StandardCharsets.UTF_8);
    }


    // ================= DES =================

    static SecretKey generateDESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        return keyGenerator.generateKey();
    }

    static String desEncrypt(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(
                text.getBytes(StandardCharsets.UTF_8)
        );

        return Base64.getEncoder().encodeToString(encrypted);
    }

    static String desDecrypt(String encryptedText, SecretKey key)
            throws Exception {

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decrypted = cipher.doFinal(
                Base64.getDecoder().decode(encryptedText)
        );

        return new String(decrypted, StandardCharsets.UTF_8);
    }


    // ================= RSA =================

    static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator =
                KeyPairGenerator.getInstance("RSA");

        keyPairGenerator.initialize(2048);

        return keyPairGenerator.generateKeyPair();
    }

    static String rsaEncrypt(String text, PublicKey publicKey)
            throws Exception {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encrypted = cipher.doFinal(
                text.getBytes(StandardCharsets.UTF_8)
        );

        return Base64.getEncoder().encodeToString(encrypted);
    }

    static String rsaDecrypt(String encryptedText, PrivateKey privateKey)
            throws Exception {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decrypted = cipher.doFinal(
                Base64.getDecoder().decode(encryptedText)
        );

        return new String(decrypted, StandardCharsets.UTF_8);
    }


    // ================= MAIN =================

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Generate encryption keys
        SecretKey aesKey = generateAESKey();
        SecretKey desKey = generateDESKey();
        KeyPair rsaKeyPair = generateRSAKeyPair();

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          TEXT ENCRYPTION TOOL");
            System.out.println("========================================");
            System.out.println("1. AES Encryption");
            System.out.println("2. DES Encryption");
            System.out.println("3. RSA Encryption");
            System.out.println("4. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            // Handle non-number input
            if (!sc.hasNextInt()) {
                System.out.println(
                        "Invalid input! Please enter a number from 1 to 4."
                );
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            // Exit
            if (choice == 4) {
                System.out.println("Program ended.");
                break;
            }

            // Invalid menu choice
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice! Please select 1, 2, 3 or 4.");
                continue;
            }

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Empty text check
            if (text.trim().isEmpty()) {
                System.out.println("Text cannot be empty!");
                continue;
            }

            try {

                switch (choice) {

                    // ---------- AES ----------
                    case 1:

                        String aesEncrypted =
                                aesEncrypt(text, aesKey);

                        System.out.println();
                        System.out.println("----- AES -----");
                        System.out.println(
                                "Encrypted Text: " + aesEncrypted
                        );

                        System.out.println(
                                "Decrypted Text: "
                                        + aesDecrypt(aesEncrypted, aesKey)
                        );

                        break;


                    // ---------- DES ----------
                    case 2:

                        String desEncrypted =
                                desEncrypt(text, desKey);

                        System.out.println();
                        System.out.println("----- DES -----");
                        System.out.println(
                                "Encrypted Text: " + desEncrypted
                        );

                        System.out.println(
                                "Decrypted Text: "
                                        + desDecrypt(desEncrypted, desKey)
                        );

                        break;


                    // ---------- RSA ----------
                    case 3:

                        String rsaEncrypted =
                                rsaEncrypt(
                                        text,
                                        rsaKeyPair.getPublic()
                                );

                        System.out.println();
                        System.out.println("----- RSA -----");
                        System.out.println(
                                "Encrypted Text: " + rsaEncrypted
                        );

                        System.out.println(
                                "Decrypted Text: "
                                        + rsaDecrypt(
                                                rsaEncrypted,
                                                rsaKeyPair.getPrivate()
                                        )
                        );

                        break;


                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println(
                        "Encryption/Decryption error: "
                                + e.getMessage()
                );
            }
        }

        sc.close();
    }
}
