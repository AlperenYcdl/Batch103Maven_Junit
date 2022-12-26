package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUpo() {
        System.out.println("Her Test methodundan once calisir");
    }

    @After
    public void tearDown() {
        System.out.println("Her test methodundan sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }

}
