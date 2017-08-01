package com.kaola.recalgo.udf.md5sum;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import java.security.MessageDigest;

/**
 * Created by hzlidandan1 on 2017/8/1.
 */
public class md5sumEncode extends UDF {
    public Text evaluate(String str) {
        if (str == null || str == "") {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] input = (str + "\n").getBytes();
            md5.update(input);
            byte [] output = md5.digest();
            StringBuilder res = new StringBuilder();
            for (byte b: output) {
                res.append(Integer.toHexString(b&0xff));
            }
            Text text = new Text();
            text.set(res.toString());
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
