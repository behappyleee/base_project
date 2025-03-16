package templatemethod.data;

// CSV 데이터를 처리하는 과정을 구현
public class CSVDataProcessor extends DataProcessor {
    @Override
    protected void loadData(String data) {
        System.out.println("Loading data from CSV ....");
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing CSV Data ...");
    }

    @Override
    protected void saveData(String data) {
        System.out.println("Saving CSV Data ....");
    }

    @Override
    protected boolean isVisibleData(String data) {
        return data != null && data.contains("CSV");
    }
}
