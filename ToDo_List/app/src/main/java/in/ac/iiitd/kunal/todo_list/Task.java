package in.ac.iiitd.kunal.todo_list;

import java.util.UUID;

/**
 * Created by KunalSaini on 07-Nov-16.
 */
public class Task {

    //need to add description here

    private UUID mId;
    private String mTitle;
    private String mDescription;

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    private String mDetail;

    public Task() {
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
