package co.edu.eam.ingesoft.pa2.registrodocentes.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporte")
public class ServletReporte extends HttpServlet {

	@Resource(lookup = "java:jboss/datasources/registrodocentesDS")
	private javax.sql.DataSource ds;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int docente=Integer.parseInt(req.getParameter("docenteid"));
		String asig=req.getParameter("asignatura");
		
		//-----EJEMPLO-------------------------------------
		try(Connection con=ds.getConnection();
				) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("asignatura", asig);
			params.put("ID_DOCENTE",docente);
			ServletOutputStream salida=resp.getOutputStream();
			
			BufferedImage image = ImageIO.read(getClass().getResource("/reporte/logo.png"));
			params.put("imagen", image);
			
			GeneradorReporte generador=new GeneradorReporte(con);
			byte[] byteStream=generador.generarReporte(params, "/reporte/reporteRegistros.jrxml", 
						"Registros del mes", salida);
			resp.setHeader("Content-Disposition","filename=myReport.pdf");
			resp.setContentType("application/pdf");
			resp.setContentLength(byteStream.length);
			salida.write(byteStream,0,byteStream.length);  
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
