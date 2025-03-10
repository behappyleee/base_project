public class FacadePattern_2 {
    public static void main(String[] args) {

    }
}

class FileSystemFacade {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileDeleter fileDeleter;

    public FileSystemFacade(FileReader fileReader, FileWriter fileWriter, FileDeleter fileDeleter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.fileDeleter = fileDeleter;
    }
}

// 파일을 읽는 클래스, 파일을 쓰는 클래스, 파일을 삭제하는 클래스가 존재, 각 책임별로 클래스를 만듦, 하지만 Client 에서 사용하기에는
// 분리되어 있어서 사용하기가 불편함
class FileReader {
    public String readFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class FileWriter {
    public void writeFile(String fileName, String content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class FileDeleter {
    public void deleteFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}