package utils.helpers;

import automation.Initialization.RecordVideo;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import ultilities.PropertiesFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;
    public class CaptureHelpers extends ScreenRecorder {

        // ------Record with Monte Media library---------
        public static ScreenRecorder screenRecorder;
        public String name;

        //Hàm xây dựng
        public CaptureHelpers(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
                           Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
            super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
            this.name = name;
        }

        //Hàm này bắt buộc để ghi đè custom lại hàm trong thư viên viết sẵn
        @Override
        protected File createMovieFile(Format fileFormat) throws IOException {

            if (!movieFolder.exists()) {
                movieFolder.mkdirs();
            } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
            return new File(movieFolder,
                    name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
        }

        // Hàm Start record video
        public static void startRecord(String methodName) throws Exception {
            //Tạo thư mục để lưu file video vào
            File file = new File("./test-recordings/");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;

            Rectangle captureSize = new Rectangle(0, 0, width, height);

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                    .getDefaultConfiguration();
            screenRecorder = new automation.Initialization.RecordVideo(gc, captureSize,
                    new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, file, methodName);
            screenRecorder.start();
        }

        // Stop record video
        public static void stopRecord() throws Exception {
            screenRecorder.stop();
        }
    }


