package common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class Common {
	public static String convert(String password) {
		try {
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes;

			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));

			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			return result;

		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}

	/**
	 * 文字列をDate型に変換する
	 * @param birthDate
	 * @return
	 */
	public static Date convertDate(String birthDate) {
		try {

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdFormat.parse(birthDate);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
	}
}
