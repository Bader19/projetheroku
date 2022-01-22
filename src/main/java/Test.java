import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import beans.Crenom;
import beans.Occupation;
import beans.Salle;
import service.CrenomService;
import service.OccupationService;
import service.SalleService;

public class Test {
	
	public static void main(String[] args) {
		Occupation n = null;
		OccupationService ms = new OccupationService();
		CrenomService cs = new CrenomService();
	 
		try {
			for ( Entry<Integer, Integer> c : ms.chart(2).entrySet()) {
				 
				System.out.println(c);
				 
				
			}
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
