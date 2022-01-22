package beans;

 
import java.util.Date;
 
public class Occupation {
	 
	    private int id;
	    private Date date;
	    private Crenom crenom;
	    private Salle salle;
	    private Client clientid;
	    private boolean validation;
		public Occupation(int id, Date date, Crenom crenom, Salle salle, Client clientid, boolean validation) {
			super();
			this.id = id;
			this.date = date;
			this.crenom = crenom;
			this.salle = salle;
			this.clientid = clientid;
			this.validation = validation;
		}
		public Occupation(int id, Date date, Crenom crenom, Salle salle, Client clientid ) {
			super();
			this.id = id;
			this.date = date;
			this.crenom = crenom;
			this.salle = salle;
			this.clientid = clientid;
 
		}
		public Occupation(  Date date, Crenom crenom, Salle salle, Client clientid ) {
			super();
	 
			this.date = date;
			this.crenom = crenom;
			this.salle = salle;
			this.clientid = clientid;
		 
		}
		public Occupation( Date date, Crenom crenom, Salle salle, Client clientid, boolean validation) {
			super();
		 
			this.date = date;
			this.crenom = crenom;
			this.salle = salle;
			this.clientid = clientid;
			this.validation = validation;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Crenom getCrenom() {
			return crenom;
		}
		public void setCrenom(Crenom crenom) {
			this.crenom = crenom;
		}
		public Salle getSalle() {
			return salle;
		}
		public void setSalle(Salle salle) {
			this.salle = salle;
		}
		public Client getClientid() {
			return clientid;
		}
		public void setClientid(Client clientid) {
			this.clientid = clientid;
		}
		public boolean isValidation() {
			return validation;
		}
		public void setValidation(boolean validation) {
			this.validation = validation;
		}
		@Override
		public String toString() {
			return "Occupation [id=" + id + ", date=" + date + ", crenom=" + crenom + ", salle=" + salle + ", clientid="
					+ clientid + ", validation=" + validation + "]";
		}
	    



		 
	    
	 

}
