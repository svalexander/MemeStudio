package nyc.c4q.shannonalexander_navarro.memestudio;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by rusili on 1/21/17.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Cursor mCursor;
    private int mColumnIndex;

    public ImageAdapter (Context localContext, Cursor cursor, int columnIndex) {
        this.mContext = localContext;
        this.mCursor = cursor;
        this.mColumnIndex = columnIndex;
    }

    public int getCount() {
        return mCursor.getCount();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView picturesView;
        if (convertView == null) {
            picturesView = new ImageView(mContext);
            // Move cursor to current position
            mCursor.moveToPosition(position);
            // Get the current value for the requested column
            int imageID = mCursor.getInt(mColumnIndex);
            // Set the content of the image based on the provided URI
            picturesView.setImageURI(Uri.withAppendedPath(
                    MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID));
            picturesView.setScaleType(ImageView.ScaleType.FIT_XY);
            picturesView.setPadding(10, 10, 10, 10);
            picturesView.setLayoutParams(new GridView.LayoutParams(300, 300));
        }
        else {
            picturesView = (ImageView)convertView;
        }
        return picturesView;
    }
}
