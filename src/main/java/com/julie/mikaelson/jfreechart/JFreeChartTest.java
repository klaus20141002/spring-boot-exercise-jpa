package com.julie.mikaelson.jfreechart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {
	 public static void main(String[] args) throws IOException{ 
	        
	        CategoryDataset dataset = getDataSet2(); 
	        JFreeChart chart = ChartFactory.createBarChart3D( 
	                           "水果产量图", // 图表标题
	                           "水果", // 目录轴的显示标签
	                           "产量", // 数值轴的显示标签
	                            dataset, // 数据集
	                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
	                            true,  // 是否显示图例(对于简单的柱状图必须是 false)
	                            false, // 是否生成工具
	                            false  // 是否生成 URL 链接
	                            ); 
	        //中文乱码
	        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
	        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
	        CategoryAxis domainAxis = categoryplot.getDomainAxis();  
	        TextTitle textTitle = chart.getTitle();
	        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));      
	        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
	        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
	        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
	        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));  
	        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
	                           
	        FileOutputStream fos_jpg = null; 
	        try { 
	            fos_jpg = new FileOutputStream("H:\\BarChart.jpg"); 
	            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f,chart,400,300,null); 
	        } finally { 
	            try { 
	                fos_jpg.close(); 
	            } catch (Exception e) {} 
	        } 
	        
	        
	        demo();
	        
	        
	        
	        
	        
	        
	    } 
	 
	 	private static void demo() throws IOException {
	 		 DefaultPieDataset data = getDataSet3();
	         JFreeChart chart = ChartFactory.createPieChart3D("水果产量图", // 图表标题
	                 data, // 数据集
	                 true, // 是否显示图例(对于简单的柱状图必须是 false)
	                 false, // 是否生成工具
	                 false // 是否生成 URL 链接
	                 );

	         //中文乱码
	         PiePlot3D plot = (PiePlot3D) chart.getPlot();
	         plot.setLabelFont(new Font("黑体", Font.PLAIN, 20));
	         TextTitle textTitle = chart.getTitle();
	         textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
	         chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

	         // 写图表对象到文件，参照柱状图生成源码
	         FileOutputStream fos_jpg = null;
	         try {
	             fos_jpg = new FileOutputStream("H:\\Pie3DChart.jpg");
	             ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,
	                     null);
	         } finally {
	             try {
	                 fos_jpg.close();
	             } catch (Exception e) {
	             }
	         }
	 	}
	 	/**
	     * 获取一个演示用的简单数据集对象
	     * 
	     * @return
	     */
	    private static DefaultPieDataset getDataSet3() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("苹果", 100);
	        dataset.setValue("梨子", 200);
	        dataset.setValue("葡萄", 300);
	        dataset.setValue("香蕉", 400);
	        dataset.setValue("荔枝", 500);
	        return dataset;
	    }
	 
	    /** 
	    * 获取一个演示用的组合数据集对象
	    * @return 
	    */ 
	    private static CategoryDataset getDataSet2() { 
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        dataset.addValue(100, "北京", "苹果"); 
	        dataset.addValue(100, "上海", "苹果"); 
	        dataset.addValue(100, "广州", "苹果"); 
	        dataset.addValue(200, "北京", "梨子"); 
	        dataset.addValue(200, "上海", "梨子"); 
	        dataset.addValue(200, "广州", "梨子"); 
	        dataset.addValue(300, "北京", "葡萄"); 
	        dataset.addValue(300, "上海", "葡萄"); 
	        dataset.addValue(300, "广州", "葡萄"); 
	        dataset.addValue(400, "北京", "香蕉"); 
	        dataset.addValue(400, "上海", "香蕉"); 
	        dataset.addValue(400, "广州", "香蕉"); 
	        dataset.addValue(500, "北京", "荔枝"); 
	        dataset.addValue(500, "上海", "荔枝"); 
	        dataset.addValue(500, "广州", "荔枝"); 
	        return dataset; 
	    } 
}
