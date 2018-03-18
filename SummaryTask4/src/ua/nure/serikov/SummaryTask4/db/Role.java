package ua.nure.serikov.SummaryTask4.db;

import ua.nure.serikov.SummaryTask4.db.entity.User;

/**
 * AutoBase
 *
 * Role entity.
 * 
 * @author Serikov Eugene
 */
public enum Role {
    ADMIN, DRIVER, DISPATCHER;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        return Role.values()[roleId - 1];
    }

    public static Role getRole(int roleId) {
        return Role.values()[roleId - 1];
    }

    public String getName() {
        return name().toLowerCase();
    }

}