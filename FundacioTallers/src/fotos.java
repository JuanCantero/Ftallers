
import java.awt.Desktop;
import java.io.File;




public class fotos {

	

	
	  public static void main(String[] args) throws Exception {
	    File f = new File("C:\\Users\\Juan\\Desktop\\220px-Cat_November_2010-1a.jpg");
	    Desktop dt = Desktop.getDesktop();
	    dt.open(f);
	    System.out.println("Done.");
	 }
}
	


