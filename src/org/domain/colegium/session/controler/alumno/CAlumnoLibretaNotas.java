package org.domain.colegium.session.controler.alumno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.domain.colegium.colegium.session.AlumnoHome;
import org.domain.colegium.colegium.session.LibretaNotasHome;
import org.domain.colegium.colegium.session.PeriodoAcademicoHome;
import org.domain.colegium.colegium.session.PersonaHome;
import org.domain.colegium.colegium.session.SubPeriodoAcademicoHome;
import org.domain.colegium.dao.AlumnoDAO;
import org.domain.colegium.dao.AsistenciaDAO;
import org.domain.colegium.dao.LibretaNotasDAO;
import org.domain.colegium.dao.PeriodoAcademicoDAO;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.LibretaNotasSubperiodo;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.session.bean.Column;
import org.domain.colegium.session.bean.DataTableBean;
import org.domain.colegium.session.bean.Item;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

@Name("CAlumnoLibretaNotas")
@AutoCreate
public class CAlumnoLibretaNotas implements ICAlumnoLibretaNotas {
	
	
	@In
	Credentials credentials;
	
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;

	
	@In (create=true)
	@Out
	PersonaHome personaHome;

	@In (create=true)
	@Out
	AlumnoHome alumnoHome;
	

	@In(create=true)
	@Out
	PeriodoAcademicoHome  periodoAcademicoHome;
	
	
	@In (create=true)
	@Out
	LibretaNotasHome libretaNotasHome;
	
	
	@In (create=true)
	@Out
	DataTableBean dataTableBean ;
		
	ArrayList<Item> arrayListItems;
	
	ArrayList<Column> arrayListColumns;
	
	@In
	PeriodoAcademicoDAO periodoAcademicoDAO;

	@In
	LibretaNotasDAO libretaNotasDAO;

	@In
	CAlumnoDatosPrincipales CAlumnoDatosPrincipales;

	List<PeriodoAcademico> suPeriodoAcademicos;
	
	
	
	public void mostrarLibretaPeriodoActual() {
		try{
			
			if (personaHome.getInstance().getIdPersona() == 0)  CAlumnoDatosPrincipales.inicializar();
			libretaNotasHome.setInstance(libretaNotasDAO.obtenerLibretaNotasAlumnoPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico()));
			suPeriodoAcademicos =  periodoAcademicoDAO.obtenerSubPeriodosAcademicos(alumnoHome.getInstance().getColegio().getIdColegio() 
					,periodoAcademicoHome.getInstance().getIdPeriodoAcademico());
			libretaNotasHome.setInstance(libretaNotasDAO.obtenerLibretaNotasAlumnoPeriodo(alumnoHome.getInstance().getIdPersona(), periodoAcademicoHome.getInstance().getIdPeriodoAcademico()));	

			llenarDatos();
		}catch (Exception e) {
			statusMessages.add(e.getMessage()); 
			log.error(e);
		}

	}
	
	void llenarDatos(){	

		Iterator<PeriodoAcademico> iterator = suPeriodoAcademicos.iterator();
		Iterator<LibretaNotasSubperiodo> iteratorLibretaNotasSubperiodo = libretaNotasHome.getInstance().getLibretaNotasSubperiodos().iterator();
		PeriodoAcademico p ;

		arrayListColumns = new ArrayList<Column>(suPeriodoAcademicos.size()+1);
		arrayListItems = new ArrayList<Item>(2);
		long[] idPeriodo = new  long[suPeriodoAcademicos.size()];
		
		
		Column curso = new Column("Curso", 0);
		arrayListColumns.add(curso);

		int i = 0 ;
		while (iterator.hasNext()) {
			p = iterator.next();
			Column c = new Column(p.getEtiqueta(), 1);
			arrayListColumns.add(c);
			idPeriodo[i] = p.getIdPeriodoAcademico();
			//log.info("idPeriodo["+i+"]"+idPeriodo[i]);
			i++;
		}
		
		LibretaNotasSubperiodo libretaNotasSubperiodo ;
		
		Hashtable hashtableCurso = new Hashtable();
		
		ArrayList<String> v1 ;
		
		while (iteratorLibretaNotasSubperiodo.hasNext()){
			libretaNotasSubperiodo = iteratorLibretaNotasSubperiodo.next();
			String nombreCurso = libretaNotasSubperiodo.getSubPeriodoAcademicoSeccionCurso().getCurso().getNombre();
			long idPeriodoNota = libretaNotasSubperiodo.getPeriodoAcademico().getIdPeriodoAcademico();

			v1 = (ArrayList<String>)hashtableCurso.get(nombreCurso) ;
			
			if (v1 == null){
				v1 = new ArrayList<String>(suPeriodoAcademicos.size()+1);
				v1.add(nombreCurso);
				v1.add("");
				v1.add("");
				v1.add("");
				v1.add("");		
				Item item = new Item("bb", v1);
				arrayListItems.add(item);
				hashtableCurso.put(nombreCurso, v1);				
			}else{
				for (int x = 0 ; x < idPeriodo.length ; x++ ){
					if (idPeriodoNota == idPeriodo[x]) v1.set(x+1,libretaNotasSubperiodo.getNota().toString());
				}				
				hashtableCurso.put(nombreCurso, v1);
			}			
				
				//log.info(libretaNotasSubperiodo.getPeriodoAcademico().getIdPeriodoAcademico());
				//log.info(libretaNotasSubperiodo.getSubPeriodoAcademicoSeccionCurso().getCurso().getNombre());
				//log.info(libretaNotasSubperiodo.getNota());
			
		}
		dataTableBean.setArrayListColumns(arrayListColumns);
		dataTableBean.setArrayListItem(arrayListItems);

	}

}
