package atiatulmaula.javacvdemo;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class Main {

	public static void main(String[] args) {
		CvCapture capture = cvCreateFileCapture("video.mp4");
		IplImage image;
		IplImage grayimage = cvCreateImage(cvSize(480, 360), IPL_DEPTH_8U, 1);
		
		for(;;){
			image = cvQueryFrame(capture);
			if (image == null) break;
			
			cvCvtColor(image, grayimage, CV_BGR2GRAY);

			cvShowImage("Video Original", image);
			cvShowImage("Video Gray", grayimage);
			
			char c = (char) cvWaitKey(15);
			if(c == 'q') break;
		}
		
		cvReleaseImage(image);
		cvReleaseImage(grayimage);
		cvReleaseCapture(capture);
	}

}
