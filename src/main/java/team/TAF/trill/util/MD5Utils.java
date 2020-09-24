package team.TAF.trill.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Utils {
    public static String md5Code(String username, String password) {
        return new Md5Hash(password, username, 100).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Md5Hash("123", "admin", 100).toString());
    }
}
