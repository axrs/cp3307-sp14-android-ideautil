package com.cadcoder.IdeaUtil;

import android.test.AndroidTestCase;

/**
 * Created by Xander on 31/03/2014.
 */
public class SQLiteIdeaHelperTest extends AndroidTestCase {

    public void testColumnNames() throws Exception {
        assertEquals("id", SQLiteIdeaHelper.COLUMN_ID);
        assertEquals("title", SQLiteIdeaHelper.COLUMN_TITLE);
        assertEquals("description", SQLiteIdeaHelper.COLUMN_DESCRIPTION);
        assertEquals("created", SQLiteIdeaHelper.COLUMN_CREATED);
        assertEquals("modified", SQLiteIdeaHelper.COLUMN_MODIFIED);
    }
}
