package templatemethod.data;

// JSON 데이터를 처리하는 과정을 구현
public class JSONDataProcessor extends DataProcessor {
    @Override
    protected void loadData(String data) {
        System.out.println("Loading data form JSON File");
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing Json data");
    }

    @Override
    protected void saveData(String data) {
        System.out.println("Saving Json Data to database");
    }

    @Override
    protected boolean isVisibleData(String data) {
        return data != null && data.contains("JSON");
    }
}
