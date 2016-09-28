package in.ac.iiitd.kunal.expresso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KunalSaini on 28-Sep-16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "user_details";

    private static final String TABLE_INFO = "info";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_COLLEGE_NAME="college_name";
    private static final String KEY_COLLEGE_ID="college_id";
    private static final String KEY_DOB="dob";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_INFO_TABLE = "CREATE TABLE " + TABLE_INFO + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_COLLEGE_ID +" TEXT,"+ KEY_COLLEGE_NAME +" TEXT," + KEY_DOB +" TEXT" +")";

        db.execSQL(CREATE_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO);
        onCreate(db);
    }


    public void addInfo(Information info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, info.getName());
        values.put(KEY_COLLEGE_ID, info.getCollege_id());
        values.put(KEY_COLLEGE_NAME, info.getCollege_name());
        values.put(KEY_DOB, info.getDob());
        values.put(KEY_PH_NO, info.getPhone_number());
        db.insert(TABLE_INFO, null, values);
        db.close();
    }


    public Information getInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_INFO, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO, KEY_COLLEGE_ID,KEY_COLLEGE_NAME,KEY_DOB }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Information info = new Information(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(4),cursor.getString(3),cursor.getString(5),cursor.getString(2));
        return info;
    }

    public List<Information> getAllInfo() {
        List<Information> infoList = new ArrayList<Information>();
        String selectQuery = "SELECT  * FROM " + TABLE_INFO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Information contact = new Information();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone_number(cursor.getString(2));
                contact.setCollege_id(cursor.getString(3));
                contact.setCollege_name(cursor.getString(4));
                contact.setDob(cursor.getString(5));
                infoList.add(contact);
            } while (cursor.moveToNext());
        }
        return infoList;
    }

    public int updateInfo(String id,Information info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, info.getName());
        values.put(KEY_COLLEGE_ID, info.getCollege_id());
        values.put(KEY_COLLEGE_NAME, info.getCollege_name());
        values.put(KEY_DOB, info.getDob());
        values.put(KEY_PH_NO, info.getPhone_number());
        return db.update(TABLE_INFO, values, KEY_ID + " = ?",
                new String[] { id });
    }

    public void deleteInfo(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INFO, KEY_ID + " = ?", new String[]{Id});
        db.close();
    }
}
