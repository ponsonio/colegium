package org.domain.colegium.session.controler.alumno;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.ResumenAlumnoHome;
import org.domain.colegium.dao.MaterialDAO;
import org.domain.colegium.entity.Materiales;
import org.domain.colegium.entity.ResumenAlumno;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;

import com.sun.xml.internal.ws.api.message.Attachment;


@Name("CAlumnoMateriales")
public class CAlumnoMateriales implements ICAlumnoMateriales {

	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	
	@In (create=true)
	PersonaHome personaHome;
	
	@In(create=true)
	AlumnoHome alumnoHome;
	
	@In(create=true)
	ResumenAlumnoHome resumenAlumnoHome;
	
	@In(create=true)
	PeriodoAcademicoHome periodoAcademicoHome ;
	
	@DataModel
	List<Materiales> materialesLista ;
	
	@In(create=true)
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;
	
	@In
	MaterialDAO materialDAO;
	
	
	@RequestParameter
	private Long attachmentId;
	
	
	@In(value="#{facesContext.externalContext}")
	private ExternalContext extCtx;
	
	@In(value="#{facesContext}")
	FacesContext facesContext;
	
	
	
	public void mostrarMaterialesAlumno() {
		try{
			CAlumnoDatosPrincipales.inicializar();
			materialesLista = materialDAO.obtenerMaterialesXSeccionXPeriodo(resumenAlumnoHome.getInstance().getSeccion().getIdSeccion()
					, periodoAcademicoHome.getInstance().getIdPeriodoAcademico());
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}
	}
	
	public void descargar() {
		log.info("Descargar:"+attachmentId);
        try {

			File attachment = new File("/home/jcabrera/redhat-010-1024x768.png_300.jpg");
			HttpServletResponse response = (HttpServletResponse)extCtx.getResponse();
		//response.setContentType(attachment.getContentType());
                response.addHeader("Content-disposition", "attachment; filename=\"" + attachment.getName() +"\"");
                FileInputStream fileIn = new FileInputStream(attachment);
			
			ServletOutputStream out = response.getOutputStream();			 
			byte[] outputByte = new byte[4096];
			//copy binary contect to output stream
			while(fileIn.read(outputByte, 0, 4096) != -1)
			{
				out.write(outputByte, 0, 4096);
			}
			out.flush();
			out.close();
			facesContext.responseComplete();
		} catch(Exception e) {
			log.error("\nFailure : " + e.toString() + "\n");
		}
	}

}
