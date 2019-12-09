package xmlextract;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test1 {
	protected long duration;
	protected Calendar date;
	
	public test1(long duration, Calendar date) {
		this.duration = duration;
		this.date = (Calendar)date.clone();
	}
	
	public void PrintData()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		System.out.println("Date = " + sdf.format(date.getTime()));
		System.out.println("Duration = " + duration + " seconds");
	}
}
