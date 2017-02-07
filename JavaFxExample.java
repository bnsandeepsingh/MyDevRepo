package com.sandeep.singh;
import java.io.FileOutputStream;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
public class JavaFxExample extends Application{
 
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage stage=new Stage();
		 stage.setTitle("Line Chart Sample");
	        //defining the axes
	        final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Number of Month");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	        lineChart.setAnimated(false);     
	        lineChart.setTitle("Index Tool");
	        //defining a series
	        XYChart.Series series = new XYChart.Series();
	        series.setName("My portfolio");
	        //populating the series with data
	        series.getData().add(new XYChart.Data(1, 23));
	        series.getData().add(new XYChart.Data(2, 14));
	        series.getData().add(new XYChart.Data(3, 15));
	        series.getData().add(new XYChart.Data(4, 24));
	        series.getData().add(new XYChart.Data(5, 34));
	        series.getData().add(new XYChart.Data(6, 36));
	        series.getData().add(new XYChart.Data(7, 22));
	        series.getData().add(new XYChart.Data(8, 45));
	        series.getData().add(new XYChart.Data(9, 43));
	        series.getData().add(new XYChart.Data(10, 17));
	        series.getData().add(new XYChart.Data(11, 29));
	        series.getData().add(new XYChart.Data(12, 25));
	        
	        Scene scene  = new Scene(lineChart,500,400);
	        lineChart.getData().add(series);
	       
	        stage.setScene(scene);
	        stage.show();
	        WritableImage img = lineChart.snapshot(null, null);
            ImageData imgData = ImageDataFactory.create(SwingFXUtils.fromFXImage(img, null), null);
            com.itextpdf.layout.element.Image pdfImg = new com.itextpdf.layout.element.Image(imgData);

            PdfWriter writer = new PdfWriter(new FileOutputStream("ss.pdf"));
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document doc = new Document(pdfDoc);
            doc.add(pdfImg);
            doc.close();
	}
}
