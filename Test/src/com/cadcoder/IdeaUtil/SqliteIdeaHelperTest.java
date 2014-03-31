package com.cadcoder.IdeaUtil;

import android.test.AndroidTestCase;

/**
 * Created by Xander on 31/03/2014.
 */
public class SqliteIdeaHelperTest extends AndroidTestCase {

    public void testColumnNames() throws Exception {
        assertEquals("id", SqliteIdeaHelper.COLUMN_ID);
        assertEquals("title", SqliteIdeaHelper.COLUMN_TITLE);
        assertEquals("description", SqliteIdeaHelper.COLUMN_DESCRIPTION);
        assertEquals("created", SqliteIdeaHelper.COLUMN_CREATED);
        assertEquals("modified", SqliteIdeaHelper.COLUMN_MODIFIED);
    }
}
