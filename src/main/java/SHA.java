import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;

public class SHA {
    public static void main(String[] args) throws Exception {
        new SHA().displaySHAHash();

    }

    public void displaySHAHash() {

        File good = new File(getClass().getResource("shattered-1.pdf").getFile());
        File bad = new File(getClass().getResource("shattered-2.pdf").getFile());
        System.out.println("-------------- SHA-1 ------------");
        System.out.println("Digest: " + getSHAHash(good));
        System.out.println("Digest: " + getSHAHash(bad));

        System.out.println("-------------- SHA-256 ------------");
        System.out.println("Digest: " + getSHA2Hash(good));
        System.out.println("Digest: " + getSHA2Hash(bad));

    }

    public String getSHAHash(File file) {
        try {
            FileInputStream data = new FileInputStream(file);
            return DigestUtils.sha1Hex(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public String getSHA2Hash(File file) {
        try {
            FileInputStream data = new FileInputStream(file);
            return DigestUtils.sha256Hex(data);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


}
/*    public String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }*/
/*    public String getSHAHash(File file) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            FileInputStream fis = new FileInputStream(file);
            byte[] dataBytes = new byte[1024];
            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            byte[] byteData = md.digest();
            fis.close();
            return convertByteToHex(byteData);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/