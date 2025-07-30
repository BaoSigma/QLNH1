package Model;

public class ModelChart {
    private String label;
    private double[] values;

    public ModelChart(String label, double[] values) {
        this.label = label;
        this.values = values;
    }

    public String getLabel() {
        return label;
    }

    public double[] getValues() {
        return values;
    }

    public double getMaxValues() {
    double max = Double.NEGATIVE_INFINITY;
    for (double d : values) {
        if (d > max) {
            max = d;
        }
    }
    return max;
}

}
