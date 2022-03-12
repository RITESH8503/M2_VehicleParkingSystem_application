package Implementation.SRC;



import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public class EntryDateTime implements Serializable{
	
	static DecimalFormat format = new DecimalFormat("#00");
	
	private String datetime;
	private LocalDateTime local;
	private long epochTime; 
	
	
	public EntryDateTime(){
		datetime = init();
	}
	
	
	private String init(){
		local = LocalDateTime.now();
		epochTime = local.toEpochSecond(ZoneOffset.UTC); 
		
		StringBuilder sb = new StringBuilder(64);
        sb.append(local.getYear());
        sb.append("-");
        sb.append(format.format(local.getMonthValue()));
        sb.append("-");
        sb.append(format.format(local.getDayOfMonth()));
        sb.append(" ");
        sb.append(format.format(local.getHour()));
        sb.append(":");
        sb.append(format.format(local.getMinute()));
        sb.append(":");
        sb.append(format.format(local.getSecond()));
        
        return(sb.toString());
    }
	
	public long getEpochTimeHours() {
		return epochTime / 3600L;
	}
	
	
	public String getDateTime(){
		return datetime;
	}
	
	
	public String getDate(){
		return datetime.split(" ")[0];
	}
	
	
	public String getTime(){
		return datetime.split(" ")[1];
	}
	
	
	public LocalDateTime getLocaldate() {
		return local;
	}
	
}