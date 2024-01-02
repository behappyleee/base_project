package thread.performance;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceExample {

    // Digital Image 는 픽셀이라는 작은 단일 컬러 포인트로 나뉨
    // 각 픽셀의 색깔은 ARGB 로 불리는 네 가지 바이트로 표현이 됨
    // RGB 컴포넌트를 사용하여 모든 색상을 얻는게 가능

    public static final String IMAGE_FILE = "C:\\Users\\Chul Han\\Desktop\\workspace\\study\\base_project\\java\\multi_thread\\images\\many-flowers.jpg";
    public static final String OUTPUT_FILE = "C:\\Users\\Chul Han\\Desktop\\workspace\\study\\base_project\\java\\multi_thread\\images\\out\\test-make-image.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(IMAGE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth()
                , originalImage.getHeight(),
                BufferedImage.TYPE_INT_BGR);

        long startTime = System.currentTimeMillis();

        // Single Thread 로 구현
        // reColorSingleThread(originalImage, resultImage);

        // Multi Thread 로 구현
        reColorMultiThread(originalImage, resultImage,1);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        File outputFile = new File(OUTPUT_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);
        
        // 스레드를 생성하여 비용이 비싸짐
        // Single Thread Duration : 424 ms
        // Multi Thread Duration : 397 ms

        // 물리적으로 네 개의 코어와 여덟개와 가상 코어를 가진 쿼드코어 컴퓨터에서 스레드 수를 변경하면서 프로그램을 실행
        // 스레드 수를 물리 코에 수에 따라 늘렸더니 지연 시간이 눈에 띄게 줄어듦, 그리고 스레드 수를 가성 코어에 맞게 늘렸더니
        // 중간에서 지연시간이 성능향이 줄고 중간 쯤에서 역효과를 낳는데 이는 가상 코어 쌍이 서로 리소스를 공유하기 때문
        
        // 스레드 수를 가상 코어 수 이상 보다 늘리면 어떤 이점도 없음

        // 소스 이미지의 해상도가 낮아졌기에 다시 말해 처리할 수 있는 픽셀이 적어져 멀티 스레드로 처리하는 이점이 적어 짐
        // 멀티 스레드 솔루션이 스퀀시 솔루션보다 속도가 느려 짐
        
        // 문제를 여러 하위 문제로 분류해 멀티 스레드로 실행하면 속도와 성능을 크게 개선이 가능
        // 스레드가 코어보다 많으면 블로킹 호출이 없고 단순한 계산만 하는 문제에 역효과를낳음


        System.out.println("[DURATION TIME] : " + duration);
    }

    public static void reColorMultiThread(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {
        // 여러 스레드를 활용 해서 이미지 색 변하는 것을 분할 함 !
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        for(int i=0; i<numberOfThreads; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(()->{
               int leftCorner = 0;
               int topCorner = height * threadMultiplier;

               recolorImage(originalImage, resultImage, leftCorner,
                       topCorner, width, height);
            });

            threads.add(thread);
        }

        threads.forEach(Thread::start);

        for(Thread thread: threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void reColorSingleThread(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth()
                , originalImage.getHeight() );
    }

    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage
            , int leftCorner, int topCorner, int width, int height) {

        for(int x=leftCorner; x < leftCorner + width && x<originalImage.getWidth(); x++) {
            for(int y= topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
               reColorPixel(originalImage, resultImage, x, y);
            }
        }
    }


    public static void reColorPixel(BufferedImage originalImage
            , BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;
        // 색상 값을 자유롭게 조절
        if(isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = createRGBColors(newRed, newGreen, newBlue);

        setRGB(resultImage, x, y, newRGB);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    // 비트 마스크 - 비트 마스크는 어떤 비트를 남기고, 어떤 비트를 제가할지를 정의하는 역할을 함
    
    public static int createRGBColors(int red, int green, int blue) {
        int rgb = 0;
        
        // 컴포넌트를 나타내는 바이트를 가장 낮은 바이트로 시프트를 해야 함
        
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    // RED 픽셀만 가져옴
    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    // Green 픽셀만 가져옴
    public static int getGreen(int rgb) {
        return (rgb & 0x0000F00) >> 8;
    }

    // 파랑색만 추출
    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }

}
