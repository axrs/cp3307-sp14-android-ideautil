package com.cadcoder.IdeaUtil;

import android.test.AndroidTestCase;

/**
 * Created by Xander on 31/03/2014.
 */
public class IdeaModelTest extends AndroidTestCase {

    public void testDefaultConstructor() throws Exception {
        IdeaModel model = new IdeaModel();

        assertEquals("Untitled", model.getTitle());
        assertEquals("", model.getDescription());
        assertEquals(false, (boolean) model.isDirty());
        assertEquals(model.getCreated(), model.getModified());
    }

    public void testTitledConstructor() throws Exception {
        IdeaModel model = new IdeaModel("Sample");

        assertEquals("Sample", model.getTitle());
        assertEquals(model.getCreated(), model.getModified());
        assertTrue(model.isDirty());
    }

    public void testSetDescription() throws Exception {
        IdeaModel m = new IdeaModel("Test");

        m.setDescription("Hello");
        assertEquals("Hello", m.getDescription());
        assertTrue(m.isDirty());
    }
}
