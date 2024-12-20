public class Runner {
    private String name;
    private int progress; 

    public Runner(String name) {
        this.name = name;
        this.progress = 0; // inicio el progeso de cada corredor a 0
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void addProgress(int steps) {
        progress += steps;
    }
}
