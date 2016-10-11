import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.net.ftp.*;


public class ejemploFTPsubida{
	boolean ftpTransfer(String localfile, String destinationfile)
	{
		String server = "ftp.domain.com";
		String username = "ftpuser";
		String password = "ftppass";
		try
		{
			FTPClient ftp = new FTPClient();
			ftp.connect(server);
			if(!ftp.login(username, password))
			{
				ftp.logout();
				return false;
			}
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply))
			{
				ftp.disconnect();
				return false;
			}
			InputStream in = new FileInputStream(localfile);
			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			boolean Store = ftp.storeFile(destinationfile, in);
			in.close();
			ftp.logout();
			ftp.disconnect();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}

 