package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	
	
	//PieChart
	public void generatePie(String path,List<Object[]> list) {
		
		//1.create Dataset using list
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] ob : list) {
			
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		//2.Convert to Jfreechart using chartFactory
		JFreeChart chart=ChartFactory.createPieChart3D("ShipmentTypes Modes", dataset);
		
		//3.Save as Image using chart Utils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentPie.jpg"), chart, 500, 600);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end  of method
	
	
	//BarChart
	public void generateBar(String path,List<Object[]> list) {
		
		//create dataset using list
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob : list) {
		//order vlaue, key label text
		dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "ShipmentModes Details");
		}
		
		
		//2.convert to JFreeChart using chartFactory
		JFreeChart chart=ChartFactory.createBarChart("shipmentType Modes", "modes", "count", dataset);
		
		//3.save as Image using charts
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentBar.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
