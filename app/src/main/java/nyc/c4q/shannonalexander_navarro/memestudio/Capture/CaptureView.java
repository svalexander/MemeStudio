package nyc.c4q.shannonalexander_navarro.memestudio.Capture;

/**
 * Created by rusili on 1/15/17.
 */

//public class CaptureView {
//    private View mView;
//
//    public CaptureView(View view){
//        this.mView = view;
//    }
//
//    public void capture(){
//        //Find the view we are after: Put into findViewById:
//
//        View view = (View) mView.findViewById();
//
//        //Create a Bitmap with the same dimensions
//        Bitmap image = Bitmap.createBitmap(view.getWidth(),
//                view.getHeight(),
//                Bitmap.Config.RGB_565);
//        //Draw the view inside the Bitmap
//        view.draw(new Canvas(image));
//
//        //Store to sdcard
//        try {
//            String path = Environment.getExternalStorageDirectory().toString();
//            CreateImageFile create = new CreateImageFile(view.getContext());
//            File viewFile = create.returnFile();
//            FileOutputStream out = new FileOutputStream(viewFile);
//
//            image.compress(Bitmap.CompressFormat.PNG, 90, out); //Output
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
