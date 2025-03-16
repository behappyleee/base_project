package templatemethod.data;

abstract public class DataProcessor {
    // 템플릿 메서드는 어떤 조건 형태로 분기하는 형태로 사용할 수 도 있음
    public final void process(String data) {
        loadData(data);
        if (isVisibleData(data)) {
            processData(data);
            saveData(data);
        } else {
            System.out.println("Data is invalid, processing aborted.");
        }
    }

    protected abstract void loadData(String data);
    protected abstract void processData(String data);
    protected abstract void saveData(String data);
    protected abstract boolean isVisibleData(String data);
}

