package com.example.cl49.com.massage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public abstract class dbmanager {
    private com.example.cl49.com.massage.db helper;
    private SQLiteDatabase db;
    public dbmanager() {}

    public dbmanager(Context context) {
        helper = new db(context);
        // 因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        // 所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
//		db=helper.getReadableDatabase();
    }
    public abstract void add(List<user> user);
    public abstract void del();
    public abstract void update(Object object);
    public abstract List query();
    public abstract Cursor queryTheCursor();
    public void closeDB() {
        db.close();
    }
}
