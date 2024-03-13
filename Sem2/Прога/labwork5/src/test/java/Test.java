import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
public class Test {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.alias("person", Person.class);
        xStream.alias("phon_number", PhoneNumber.class);

        PhoneNumber phoneNumber = new PhoneNumber(2,"#21");
        Person joe = new Person("Jioe","312", phoneNumber);
        String xml = xStream.toXML(joe);
        System.out.println(xml+"\n");
    }
}
class Person {
    private String firstname;
    private String lastname;
    private PhoneNumber phone;
    private PhoneNumber fax;

    public Person(String firstname, String lastname, PhoneNumber phone){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    // ... constructors and methods
}

class PhoneNumber {
    private int code;
    private String number;
    // ... constructors and methods
    public PhoneNumber(int code, String ds){
        this.code = code;
        this.number = ds;
    }
}
