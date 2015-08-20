package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("reciboPensionHome")
public class ReciboPensionHome extends EntityHome<ReciboPension>
{

    @In(create=true)
    MonedaHome monedaHome;
    @In(create=true)
    AlumnoHome alumnoHome;
    @In(create=true)
    PeriodoAcademicoHome periodoAcademicoHome;
    @In(create=true)
    CuentaBancoHome cuentaBancoHome;
    @In(create=true)
    ReciboPensionDetalleHome reciboPensionDetalleHome;

    public void setReciboPensionIdReciboPension(String id)
    {
        setId(id);
    }

    public String getReciboPensionIdReciboPension()
    {
        return (String) getId();
    }

    @Override
    protected ReciboPension createInstance()
    {
        ReciboPension reciboPension = new ReciboPension();
        return reciboPension;
    }

    public void load()
    {
        if (isIdDefined())
        {
            wire();
        }
    }

    public void wire()
    {
        getInstance();
        Moneda moneda=monedaHome.getDefinedInstance();
        if ( moneda!=null )
        {
           getInstance().setMoneda(moneda);
        }
        Alumno alumno=alumnoHome.getDefinedInstance();
        if ( alumno!=null )
        {
           getInstance().setAlumno(alumno);
        }
        PeriodoAcademico periodoAcademico=periodoAcademicoHome.getDefinedInstance();
        if ( periodoAcademico!=null )
        {
           getInstance().setPeriodoAcademico(periodoAcademico);
        }
        CuentaBanco cuentaBanco=cuentaBancoHome.getDefinedInstance();
        if ( cuentaBanco!=null )
        {
           getInstance().setCuentaBanco(cuentaBanco);
        }
        ReciboPensionDetalle reciboPensionDetalle=reciboPensionDetalleHome.getDefinedInstance();
        if ( reciboPensionDetalle!=null )
        {
           getInstance().setReciboPensionDetalle(reciboPensionDetalle);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getMoneda()==null ) return false;
        if ( getInstance().getAlumno()==null ) return false;
        if ( getInstance().getPeriodoAcademico()==null ) return false;
        if ( getInstance().getCuentaBanco()==null ) return false;
        return true;
    }

    public ReciboPension getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

