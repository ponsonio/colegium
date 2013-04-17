package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("bancoHome")
public class BancoHome extends EntityHome<Banco>
{

    @In(create=true)
    CuentaBancoHome cuentaBancoHome;

    public void setBancoIdBanco(Short id)
    {
        setId(id);
    }

    public Short getBancoIdBanco()
    {
        return (Short) getId();
    }

    @Override
    protected Banco createInstance()
    {
        Banco banco = new Banco();
        return banco;
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
        CuentaBanco cuentaBanco=cuentaBancoHome.getDefinedInstance();
        if ( cuentaBanco!=null )
        {
           getInstance().setCuentaBanco(cuentaBanco);
        }
    }

    public boolean isWired()
    {
        return true;
    }

    public Banco getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }


}

