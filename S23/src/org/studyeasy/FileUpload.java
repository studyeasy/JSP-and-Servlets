package org.studyeasy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.studyeasy.hibernate.DAO.FilesDAO;
import org.studyeasy.hibernate.entity.Files;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String path = "c:/images/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("action"));
		String action = request.getParameter("action");
		switch(action) {
		case "uploadFiles":
			uploadFile(request, response);
			break;
		default:
			request.getRequestDispatcher("indix.jsp").forward(request, response);
		}

	}

	public void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		try {
			List<FileItem> images = upload.parseRequest(request);
			for (FileItem image : images) {
				String name = image.getName();
				try {
					name = name.substring(name.lastIndexOf("\\") + 1);
				} catch (Exception e) {
				}
				System.out.println(name);
				new FilesDAO().addFileDetails(new Files(name));
				image.write(new File(path + name));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
