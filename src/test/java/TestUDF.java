import com.kaola.recalgo.udf.md5sum.md5sumEncode;
/**
 * Created by hzlidandan1 on 2017/8/1.
 */
public class TestUDF {
    public static void main(String [] args) {
        md5sumEncode md5 = new md5sumEncode();
        String md5str = md5.evaluate("hello world").toString();
        System.out.print(md5str);
    }
}
