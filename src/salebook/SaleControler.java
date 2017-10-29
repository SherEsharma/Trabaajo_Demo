package salebook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@WebServlet("/SaleControler")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
maxFileSize = 1024 * 1024 * 10, 		// 10MB
maxRequestSize = 1024 * 1024 * 50)		
public class SaleControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File saveFile=null;
	private String file_path;
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String photo_path=request.getParameter("photo_path");
		System.out.println(photo_path);
		
		SalesDto sdto=new SalesDto();
		PrintWriter out=response.getWriter();
		SalesService ss=new SalesService();
		
		List<File> uploadedFiles = saveUploadedFiles(request);
			String file_path1=saveFile.getAbsolutePath();
			String s=InetAddress.getLocalHost().getHostAddress();
			System.out.println(s);
			String file_path="http://"+s+":8080/ImageUpload/File/"+saveFile+"";
			sdto.setFile_path(file_path);
			
			SalesService ser=new SalesService();
			 boolean b1=ss.cheak_Sales_Detail(sdto);
					  String s2="your book information has been submitted successfully!";  
				        RequestDispatcher rd=request.getRequestDispatcher("sale.jsp");
				     
				        rd.include(request, response);  
				
		}
	
	private List<File> saveUploadedFiles(HttpServletRequest request)
			throws IllegalStateException, IOException, ServletException {
		//Part part=null;
		
		List<File> listFiles = new ArrayList<File>();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		Collection<Part> multiparts = request.getParts();
		if (multiparts.size() > 0) {
			for (Part part : request.getParts()) {
			    String fileName = extractFileName(part);
				if (fileName == null || fileName.equals("")) {
					
					continue;
				}
				try{
			 saveFile = new File(fileName);
				}
				catch(Exception e)
				{
					System.out.println("please upload file");
				}
				
				//FileOutputStream outputStream = new FileOutputStream("C://Users//vicky143//Desktop//Aartek//Online_Book//Online_Book//Online_Book//WebContent//file1//"+saveFile+"");
				FileOutputStream outputStream = new FileOutputStream("E://Trabaaja//image//"+saveFile+"");
																	
				InputStream inputStream = part.getInputStream();
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.close();
				inputStream.close();
				
				listFiles.add(saveFile);
			}
		}
		return listFiles;
	}
	
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return null;
	}
	
	
	}