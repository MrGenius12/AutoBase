package ua.nure.serikov.SummaryTask4.db;

import org.junit.Test;
import ua.nure.serikov.SummaryTask4.db.entity.User;

import static org.junit.Assert.assertEquals;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class RoleTest {

    @Test
    public void testGetRole() throws Exception {
        assertEquals(Role.getRole(1), Role.ADMIN);
    }

    @Test
    public void testGetRoleByUser() throws Exception {
        User user = new User();
        user.setRoleId(1);

        assertEquals(Role.getRole(user), Role.ADMIN);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(Role.getRole(1).getName(), "admin");
    }
}