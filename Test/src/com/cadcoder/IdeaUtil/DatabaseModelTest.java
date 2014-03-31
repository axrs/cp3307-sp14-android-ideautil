package com.cadcoder.IdeaUtil;

import android.test.AndroidTestCase;

/**
 * Created by Xander on 31/03/2014.
 */
public class DatabaseModelTest extends AndroidTestCase {

    public void testConstructor() throws Exception {
        DatabaseModel m = new DatabaseModel();

        assertEquals(-1, m.getId());
        assertEquals(m.getCreated(), m.getModified());
        assertFalse(m.isDirty());
    }

    public void testSetId() throws Exception {
        DatabaseModel m = new DatabaseModel();
        m.setId(1230);

        assertEquals(1230, m.getId());
        m.setId(-123);
        assertEquals(1230, m.getId());
    }
}
