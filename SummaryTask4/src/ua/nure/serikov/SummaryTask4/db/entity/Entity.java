package ua.nure.serikov.SummaryTask4.db.entity;

import java.io.Serializable;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 4428191584754818572L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
