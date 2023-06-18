import java.util.Scanner;

class CaesarCipher{

    public static String encrypt(String msg, int key){
        String encryptedMsg = "";
        char[] ch = msg.toCharArray();

        for(int i=0; i<ch.length; i++){
            char c = ch[i];

            //Space
            if(c == ' '){
                encryptedMsg += c;
                continue;
            }

            if(c >= 'a' && c<='z'){  
                c = (char) (c + key);

                if(c > 'z'){
                    c = (char) (c - 'z' + 'a' - 1);
                }
                encryptedMsg += c;
                continue;
            }
            
            if(c >='A' || c <= 'Z'){
                c = (char) (c + key);

                if(c > 'Z'){
                    c = (char) (c - 'Z' + 'A' - 1);
                }

                encryptedMsg += c;
            }
            
        }
        return encryptedMsg;
    }

    public static String decrypt(String s,int key){
        String decryptedMsg = "";
        char[] ch = s.toCharArray();

        for(int i=0; i<ch.length; i++){
            char c = ch[i];

            //Space
            if(c == ' '){
                decryptedMsg += c;
                continue;
            }

            if(c >= 'a' && c <='z') {
                c = (char) (c - key);

                if(c < 'a'){
                    c = (char) (c + 'z' - 'a' + 1);
                }
                decryptedMsg += c;
                continue;
            }

            if(c >= 'A' && c <= 'Z'){
                c = (char) (c - key);

                if(c < 'A'){
                    c = (char) (c + 'Z' - 'A' + 1);
                }
                decryptedMsg += c;
            }
        }

        return decryptedMsg;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the message to be excrypted : ");
        String s = scan.nextLine();
        
        System.out.print("Enter a key num: " );
        int key = scan.nextInt();
        
        String encrypt = CaesarCipher.encrypt(s,key);
        System.out.println(encrypt);

        String decrypt = CaesarCipher.decrypt(encrypt,key);
        System.out.println(decrypt);

        scan.close();
    }
}