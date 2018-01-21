import com.application.v1.daos.TestOrderDao;
import com.application.v1.daos.TestUserDao;
import com.application.v1.orms.test.TestOrder;
import com.application.v1.orms.test.TestUser;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.ManyToOne;
import javax.swing.*;

/**
 * @auther ttm
 * @date 2017/12/15
 */
public class ManyToOneTest extends SpringTest {

    private final static Logger LOG = Logger.getLogger(ManyToOneTest.class);

    @Autowired
    private TestOrderDao testOrderDao;

    @Autowired
    private TestUserDao testUserDao;

//    @Test
    public void saveOrder() {
        TestUser testUser = new TestUser();
        testUser.setName("小红");
        testUser.setEmail("chicuu@mail.com");
        testUserDao.save(testUser);
        TestOrder testOrder = new TestOrder();
        testOrder.setOrderName("order3");
        testOrder.setUser(testUser);
        testOrderDao.save(testOrder);
        TestOrder testOrder2 = new TestOrder();
        testOrder2.setOrderName("order4");
        testOrder2.setUser(testUser);
        testOrderDao.save(testOrder2);
    }

//    @Test
    public void findOrder() {
        TestOrder testOrder = testOrderDao.findOne(1);
        LOG.info("show data : " + testOrder.getOrderName());
    }

    @Test
    public void deleteUser() {
        testUserDao.delete(2);
    }

}
