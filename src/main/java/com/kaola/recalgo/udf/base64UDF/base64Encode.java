package com.kaola.recalgo.udf.base64UDF;

import org.apache.commons.codec.binary.Base64;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Created by hzlidandan1 on 2017/08/01.
 */

public class base64Encode extends UDF {

    public Text evaluate(String str) {
        if (str == null || str == "") {
            return null;
        }
        try {
            byte[] b = Base64.encodeBase64(str.getBytes());
            Text text = new Text();
            text.set(b);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
