package View;

import Model.ModelChart;
import Model.ModelLegend;
import View.BlankPlotChart;
import Controller.BlankPlotChatRender;
import View.LegendItem;
import View.SeriesSize;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;



public class LineChart extends javax.swing.JPanel {

    DecimalFormat df = new DecimalFormat("#,##0.##");
    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 22;
    private final int seriesSpace = 10;
    private final Animator animator;
    private float animate;
    private String showLabel;
    private Point labelLocation = new Point();

    public LineChart() {
        initComponents();
        setOpaque(false);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
        };
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public int getMaxLegend() {
                return legends.size();
            }

            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
    List<Path2D.Double> gra = new ArrayList<>();
    for (int i = 0; i < legends.size(); i++) {
        gra.add(new Path2D.Double());
    }

   
    renderSeries(chart, g2, size, index, gra);   
    renderGraphics(g2, gra);                     
}
@Override
public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra) {
     double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
    double x = size.getX() + (size.getWidth() - totalSeriesWidth) / 2;

    for (int i = 0; i < legends.size(); i++) {
        double value = model.get(index).getValues()[i] * animate;
        double height = chart.getSeriesValuesOf(value, size.getHeight());
        double y = size.getY() + size.getHeight() - height;

        // Rounded rectangle with corner radius
        int arc = 12; // độ cong góc
        g2.setPaint(new GradientPaint(0, 0, legends.get(i).getColor(), 0, (int) height, legends.get(i).getColorLight()));
        g2.fillRoundRect((int) x, (int) y, seriesSize, (int) height, arc, arc);

        x += seriesSize + seriesSpace;
    }
}


            @Override
            public void renderGraphics(Graphics2D g2, List<Path2D.Double> gra) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                g2.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
                for (int i = 0; i < gra.size(); i++) {
                    g2.setPaint(new GradientPaint(0, 0, legends.get(i).getColor(), getWidth(), 0, legends.get(i).getColorLight()));
                    g2.draw(gra.get(i));
                }
                System.out.println("🎨 renderGraphics: " + gra.size() + " paths");
                
            }

            @Override
            public boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesHeight = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double y = (size.getHeight() - totalSeriesHeight) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    double seriesValue = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getWidth()) * animate;
                    int s = seriesSize / 2;
                    int sx = seriesSize / 3;
                    int py[] = {(int) (size.getY() + y), (int) (size.getY() + y + s), (int) (size.getY() + y + seriesSize), (int) (size.getY() + y + seriesSize), (int) (size.getY() + y + s), (int) (size.getY() + y)};
                    int px[] = {(int) (size.getX() + seriesValue), (int) (size.getX() + seriesValue + sx), (int) (size.getX() + seriesValue), (int) (size.getX()), (int) (size.getX() - sx), (int) (size.getX())};

                    if (new Polygon(px, py, px.length).contains(evt.getPoint())) {
                        double data = model.get(index).getValues()[i];
                        showLabel = df.format(data);
                        labelLocation.setLocation((int) (size.getX() + seriesValue + sx), (int) (size.getY() + y + s));
                        chart.repaint();
                        return true;
                    }
                    y += seriesSpace + seriesSize;
                }
                return false;
            }
        });
    }

    public void addLegend(String name, Color color, Color color1) {
        ModelLegend data = new ModelLegend(name, color, color1);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    public void clear() {
        animate = 0;
        showLabel = null;
        blankPlotChart.setLabelCount(0);
        model.clear();
        repaint();
    }

    public void start() {
        showLabel = null;
        if (!animator.isRunning()) {
            animator.start();
        }
    }

    private Dimension getLabelWidth(String text, Graphics2D g2) {
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(text, g2);
        return new Dimension((int) r2.getWidth(), (int) r2.getHeight());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new View.BlankPlotChart();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        blankPlotChart.setForeground(new java.awt.Color(0, 0, 0));
        blankPlotChart.setDoubleBuffered(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
