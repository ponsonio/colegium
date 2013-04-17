package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cuentaBancoHome")
public class CuentaBancoHome extends EntityHome<CuentaBanco>
{

    @In(create=true)
    ColegioHome colegioHome;
    @In(create=true)
    BancoHome bancoHome;

    public void setCuentaBancoIdBanco(Short id)
    {
        setId(id);
    }

    public Short getCuentaBancoIdBanco()
    {
        return (Short) getId();
    }

    @Override
    protected CuentaBanco createInstance()
    {
        CuentaBanco cuentaBanco = new CuentaBanco();
        return cuentaBanco;
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
        Colegio colegio=colegioHome.getDefinedInstance();
        if ( colegio!=null )
        {
           getInstance().setColegio(colegio);
        }
        Banco banco=bancoHome.getDefinedInstance();
        if ( banco!=null )
        {
           getInstance().setBanco(banco);
        }
    }

    public boolean isWired()
    {
        if ( getInstance().getColegio()==null ) return false;
        if ( getInstance().getBanco()==null ) return false;
        return true;
    }

    public CuentaBanco getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }

    public List<ReciboPension> getReciboPensions() {
        return getInstance() == null ?
            null : new ArrayList<ReciboPension>( getInstance().getReciboPensions() );
    }

}

