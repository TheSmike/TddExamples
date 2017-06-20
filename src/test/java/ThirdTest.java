import it.omigrade.tdd.user.MockRepository;
import it.omigrade.tdd.user.MyRepository;
import it.omigrade.tdd.user.UserAccount;
import org.junit.Assert;
import org.junit.Test;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class ThirdTest {

//    @Test
//    public void stubTest() throws Exception {
//        //test di una funzionalità che dipende dai dati su un DB
//
//        UserAccount ua = new UserAccount("michele");
//        boolean ok = ua.accedi();
//
//        Assert.assertTrue(ok);
//
//    }


    @Test
    public void stubTest() throws Exception {
        //test di una funzionalità che dipende dai dati su un DB
        MyRepository repository = new MockRepository();
        UserAccount ua = new UserAccount(repository, "michele");
        boolean ok = ua.accedi("password_KO");
        Assert.assertFalse(ok);
        ok = ua.accedi("password_OK");
        Assert.assertTrue(ok);
    }

    @Test
    public void stubTest() throws Exception {
        //test di una funzionalità che dipende dai dati su un DB
        MyRepository repository = new MockRepository();
        UserAccount ua = new UserAccount(repository, "sara");
        ua.accedi("Any password");
        boolean isAdmin = ua.isAdmin();

        Assert.assertTrue(isAdmin);
    }

    @Test
    public void stubTest() throws Exception {
        //test di una funzionalità che dipende dai dati su un DB
        MyRepository repository = new MockRepository();
        Region region = StubRegion();
        UserAccount ua = new UserAccount(repository, region, "sara");
        ua.accedi("Any password");
        boolean isAdmin = ua.isAdmin();

        Assert.assertTrue(isAdmin);
    }





}
