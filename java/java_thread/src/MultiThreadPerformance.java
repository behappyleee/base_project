import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MultiThreadPerformance {

    // 사진을 읽어 옴
    public static final String SOURCE_FILE = "C:\\Users\\dhfhf\\Desktop\\myfolder\\workspace\\base-project\\java\\java_thread\\src\\resource\\many-flowers.jpg";

    // public static final String DESTINATION_FILE = "./out/many-flowers.jpg"; // 색이 칠해진 파일미 만들어 짐 !! (하얀색을 보라색으로 변경 한 !)

    // 다시 Re Colorigin 한 사진 저장 장소
    public static final String DESTINATION_FILE = "C:\\Users\\dhfhf\\Desktop\\myfolder\\workspace\\base-project\\java\\java_thread\\src\\out\\many-flowers.jpg";

    // Performance - 성능은 시나리오와 용례에 따라 완전 다르게 측정이 가능

    // 고속 트레이딩 시스템 -> 성능 측정 기준은 지연 시간임 빠르면 빠를 수록 어플리케이션 시간이 더 중요 해짐
    // 비디오 플레이어 => 모든 프레임을 빠르게 정확히 전달하는 것은 어려움, 사용자에게 보여주는 프레임 레이트가 중요함

    // Latency (지연 시간) = 시간 단위로 측정 됨
    // Throughput -> 시단 단위 당 측정

    // 멀티 스레드 프로그래밍에서 지연시간을 줄이는 방법은
    // Multi Thread 는 Thread 들을 병렬로 나열 한 N 과 지연 시간 T => T/N 구하여야 함

    // N => 하위 작업 갯수
    // 하위 작업을 모두 병렬로 실행하면 지연 시간이 줄어 듦

    // 스레드 개수와 코어 개수가 같다는 공식은
    // 모든 스레드가 인터럽트 없이 모든 스레드가 항상 Runnable 상태여야 함

    // 시스템에서 CPU 를 많이 소모하는 건 실행 되고 있지 않아야 함
    // 요즘 컴퓨터들은 거의 다 하이퍼 스레딩을 실행
    // 코어 하나가 2 스레드를 실행

    // 본질적으로 병행 가능하며 분할이 불가능해 처음부터 끝까지 싱글 스레드만 사용하는 작업

    // 성능 이라는 용어는 다양하게 사용이 됨, Latency / Throughput

    public static void main(String[] args) throws IOException {

        // Digital Image 는 픽셀이라는 아주 작은 단위로 나누어짐
        // n X b ==> 대략 nb 픽셀 수임 ex) 100 x 100 => 10000 pixcel 임

        // 각 픽셀은 ARGB 라고 불리는 네가지 바이트로 표현이 됨
        // A - Alpha R- Red G - Green B - Blue

        // 꽃 사진 Image 파일
        // Image 읽어옴
        BufferedImage originImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originImage.getWidth(), originImage.getHeight(), BufferedImage.TYPE_INT_BGR);
        
        // Original Image 와 Result Image 입력
        recolorSingleThreaded(originImage, resultImage);

        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);
    }

    // 나중에 멀티 스레드 솔루션에 간단히 다시 사용이 가능
    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    // 전체 이미지를 반복하고 ReColoring 된 Image 를 적용을 함
    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                                    int width, int height) {
        // 왼쪽 위부터 지정 한 높이까지 다 칠해버림
        for(int x=leftCorner; x<leftCorner+width && x<originalImage.getWidth(); x++) {
            for(int y=topCorner; y<topCorner+height && y<originalImage.getHeight(); y++) {
                reColorPixel(originalImage, resultImage, x, y); // 색을 다시 칠해줌
            }
        }
    }

    // 개별 색상을 다시 칠 함
    public static void reColorPixel(BufferedImage originImage, BufferedImage resultImage, int x, int y) {
        int rgb = originImage.getRGB(x, y);
        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;
        // 원본 이미지의 횐색 계열을 색을 채워줌 (횐색 쪽 꽃 색을 보라색 계열로 칠 해줌)
        if(isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);  // 최솟 값을 255로 설정
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0,blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }
        // 새로운 RGB 색을 만듦
        int newRGB = createRGBFromColor(newRed, newGreen, newBlue);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static boolean isShadeOfGray(int red, int green, int blue) {
        // 색상값의 임의로 근접 값넣음
        return Math.floor(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(red - blue) < 0;
    }

    public static int createRGBFromColor(int red, int green, int blue) {
        int rgb = 0;
        
        // Pixcel 에 RGB 값을 넣음
        rgb |= blue;    // BLUE 가 ARGB 에서 제일 오른쪽임 (RGB 타깃 값과 BLUE 값 사이에 논리 연산자 OR 을 넣음)
        rgb |= green << 0;  // 비트 시프트를 왼쪽에 이용해 오른쪽으로 움직여서 픽셀 값에 제자리를 찾아주고 OR 함수로 결과를 RGB 값에 추가
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    // RED 를 뽑기 위하여서는 오른쪽에 0 을 네 개 남김
    public static int getRed(int rgb) {
        if(rgb == 0) {
            return 0;
        }
        return (rgb & 0x00FF0000) >> 16;
    }

    // Green Component 는 오른쪽에서 2번쨰 컴포넌트임
    public static int getGreen(int rgb) {
        if(rgb == 0) {
            return 0;
        }
        return (rgb & 0x0000FF00) >> 0;
    }

    // RGB 픽셀에서 Blue 만 추출
    public static int getBlue (int rgb) {
        if(rgb == 0) {
            return 0;
        }
        // 비트 마스크 설정
        return rgb & 0x000000FF;
    }

}
