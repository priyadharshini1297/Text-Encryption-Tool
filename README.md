# Text Encryption Tool
A Java-based cybersecurity project developed to encrypt and decrypt text using multiple cryptographic algorithms for secure data protection.

## Project Description
The Text Encryption Tool is a command-line application that demonstrates text encryption and decryption using three cryptographic algorithms:
* AES (Advanced Encryption Standard)
* DES (Data Encryption Standard)
* RSA (Rivest–Shamir–Adleman)
The application allows users to select an encryption algorithm, enter text, generate encrypted output, and verify the original text through decryption.

## Features
* AES encryption and decryption
* DES encryption and decryption
* RSA encryption and decryption
* Automatic key generation
* Base64 encoded encrypted output
* Input validation
* Invalid choice handling
* Empty text validation
* Exception handling

## Technologies Used
* Java
* Java Cryptography Architecture (JCA)
* Visual Studio Code

## Algorithms Used

### AES
AES is a symmetric-key encryption algorithm that uses the same secret key for encryption and decryption.
### DES
DES is a symmetric-key encryption algorithm included in this project for educational purposes and algorithm comparison.
### RSA
RSA is an asymmetric-key encryption algorithm that uses a public key for encryption and a private key for decryption.

## How to Run
Compile the program:
```bash
javac TextEncryption.java
```
Run the program:
```bash
java TextEncryption
```
## Application Menu
```text
1. AES Encryption
2. DES Encryption
3. RSA Encryption
4. Exit
```
## Testing
The application was tested successfully with:
* AES encryption and decryption
* DES encryption and decryption
* RSA encryption and decryption
* Invalid menu choice
* Non-numeric input
* Empty text input
* Exit option

## Security Note
DES is an outdated cryptographic algorithm and is included for educational and comparison purposes. Modern applications should use stronger encryption methods such as appropriately configured AES.

## Learning Outcomes
This project provided practical understanding of:
* Symmetric and asymmetric encryption
* Encryption and decryption
* Cryptographic key generation
* Java Cryptography Architecture
* Input validation and exception handling

## Project Structure
```text
Text-Encryption-Tool/
├── TextEncryption.java
└── README.md
```
## Author
Priya Dharshini S
