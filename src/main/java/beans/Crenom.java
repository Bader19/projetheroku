package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Crenom {
	 
	    private int id;
	    private Date heureDebut;
	    private Date heureFin;

	    public  Crenom(Date heureDebut, Date heureFin) {
	        this.heureDebut = heureDebut;
	        this.heureFin = heureFin;
	    }

	    public  Crenom(int id, Date time, Date time2) {
	        this.id = id;
	        this.heureDebut = time;
	        this.heureFin = time2;
	    }
	    
	    public Crenom() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getHeureDebut() {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String d  = sdf.format( heureDebut);
			return d;
		}
	    public void setHeureDebut(Date heureDebut) {
	        this.heureDebut = heureDebut;
	    }

	    public String getHeureFin() {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String d  = sdf.format(heureFin);
			return d;
		}

	    public void setHeureFin(Date heureFin) {
	        this.heureFin = heureFin;
	    }
	    
		@Override
		public String toString() {
			return " heureDebut=" + getHeureDebut() + ", heureFin=" + getHeureFin() + "]";
		}

	    
	    
	 

}
