package org.domain.colegium.colegium.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import org.domain.colegium.entity.AsignacionAlumno;
import org.domain.colegium.entity.Asistencia;
import org.domain.colegium.entity.Aviso;
import org.domain.colegium.entity.Colegio;
import org.domain.colegium.entity.EvaluacionAlumno;
import org.domain.colegium.entity.LibretaNotas;
import org.domain.colegium.entity.LibretaNotasSubperiodo;
import org.domain.colegium.entity.PeriodoAcademico;
import org.domain.colegium.entity.PeriodoAcademicoSeccion;
import org.domain.colegium.entity.ReciboPension;
import org.domain.colegium.entity.ResumenAlumno;
import org.domain.colegium.entity.SubPeriodoAcademicoSeccionCurso;
import org.jboss.portletbridge.seam.PortletScope;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;
import javax.ejb.Remove;


@Name("subPeriodoAcademicoHome")
//@Stateful
@Scope(ScopeType.SESSION)
//@AutoCreate
@PortletScope(PortletScope.ScopeType.APPLICATION_SCOPE)
public class SubPeriodoAcademicoHome extends EntityHome<PeriodoAcademico> {

	@In(create = true)
	ColegioHome colegioHome;
	@In(create = true)
	PeriodoAcademicoHome periodoAcademicoHome;
	


	public void setPeriodoAcademicoIdPeriodoAcademico(Long id) {
		setId(id);
	}

	public Long getPeriodoAcademicoIdPeriodoAcademico() {
		return (Long) getId();
	}

	@Override
	protected PeriodoAcademico createInstance() {
		PeriodoAcademico periodoAcademico = new PeriodoAcademico();
		return periodoAcademico;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Colegio colegio = colegioHome.getDefinedInstance();
		if (colegio != null) {
			getInstance().setColegio(colegio);
		}
	}

	public boolean isWired() {
		if (getInstance().getColegio() == null)
			return false;
		return true;
	}

	public PeriodoAcademico getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Aviso> getAvisos() {
		return getInstance() == null ? null : new ArrayList<Aviso>(
				getInstance().getAvisos());
	}

	public List<SubPeriodoAcademicoSeccionCurso> getSubPeriodoAcademicoSeccionCursos() {
		return getInstance() == null ? null
				: new ArrayList<SubPeriodoAcademicoSeccionCurso>(getInstance()
						.getSubPeriodoAcademicoSeccionCursos());
	}

	public List<LibretaNotasSubperiodo> getLibretaNotasSubperiodos() {
		return getInstance() == null ? null
				: new ArrayList<LibretaNotasSubperiodo>(getInstance()
						.getLibretaNotasSubperiodos());
	}

	public List<ResumenAlumno> getResumenAlumnos() {
		return getInstance() == null ? null : new ArrayList<ResumenAlumno>(
				getInstance().getResumenAlumnos());
	}

	public List<PeriodoAcademicoSeccion> getPeriodoAcademicoSeccions() {
		return getInstance() == null ? null
				: new ArrayList<PeriodoAcademicoSeccion>(getInstance()
						.getPeriodoAcademicoSeccions());
	}

	public List<Asistencia> getAsistencias() {
		return getInstance() == null ? null : new ArrayList<Asistencia>(
				getInstance().getAsistencias());
	}

	public List<ReciboPension> getReciboPensions() {
		return getInstance() == null ? null : new ArrayList<ReciboPension>(
				getInstance().getReciboPensions());
	}

	public List<EvaluacionAlumno> getEvaluacionAlumnos() {
		return getInstance() == null ? null : new ArrayList<EvaluacionAlumno>(
				getInstance().getEvaluacionAlumnos());
	}

	public List<LibretaNotas> getLibretaNotases() {
		return getInstance() == null ? null : new ArrayList<LibretaNotas>(
				getInstance().getLibretaNotases());
	}

	public List<AsignacionAlumno> getAsignacionAlumnos() {
		return getInstance() == null ? null : new ArrayList<AsignacionAlumno>(
				getInstance().getAsignacionAlumnos());
	}

	public List<PeriodoAcademico> getPeriodoAcademicos() {
		return getInstance() == null ? null : new ArrayList<PeriodoAcademico>(
				getInstance().getPeriodoAcademicos());
	}

	@Remove
	public String remove() {
		return null;
	}



}
