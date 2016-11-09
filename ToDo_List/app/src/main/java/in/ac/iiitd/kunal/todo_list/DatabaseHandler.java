package in.ac.iiitd.kunal.todo_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by KunalSaini on 28-Sep-16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "user_details";

    private static final String TABLE_INFO = "info";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "task_label";
    private static final String KEY_DETAIL="detail";

    public DatabaseHandler(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_INFO_TABLE = "CREATE TABLE " + TABLE_INFO + "("
                + KEY_ID + " INTEGER," + KEY_NAME + " TEXT,"
                + KEY_DETAIL + " TEXT " +")";

        db.execSQL(CREATE_INFO_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO);
        onCreate(db);
    }


    public void deleteInfo(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INFO, KEY_ID + " = ?", new String[]{Id});
        db.close();
    }

    public void addInfo(Task info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, info.getmId().toString());
        values.put(KEY_NAME, info.getmTitle());
        values.put(KEY_DETAIL, info.getmDescription());
        db.insert(TABLE_INFO, null, values);
        db.close();
    }


    public ArrayList<Task> getAllInfo() {
        ArrayList<Task> infoList = new ArrayList<Task>();
        String selectQuery = "SELECT  * FROM " + TABLE_INFO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Task contact = new Task();
                contact.setmId(UUID.fromString(cursor.getString(0)));
                contact.setmTitle(cursor.getString(1));
                contact.setmDescription(cursor.getString(2));
                infoList.add(contact);
            } while (cursor.moveToNext());
        }
        return infoList;
    }

    public int updateInfo(String id,Task info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, info.getmTitle());
        values.put(KEY_DETAIL, info.getmDescription());
        return db.update(TABLE_INFO, values, KEY_ID + " = ?",
                new String[] { id });
    }


}
