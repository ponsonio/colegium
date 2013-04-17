package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("mensajeDestinatarioList")
public class MensajeDestinatarioList extends EntityQuery<MensajeDestinatario>
{

    private static final String EJBQL = "select mensajeDestinatario from MensajeDestinatario mensajeDestinatario";

    private static final String[] RESTRICTIONS = {
    };

    private MensajeDestinatario mensajeDestinatario;

    public MensajeDestinatarioList()
    {
        mensajeDestinatario = new MensajeDestinatario();
        mensajeDestinatario.setId( new MensajeDestinatarioId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public MensajeDestinatario getMensajeDestinatario()
    {
        return mensajeDestinatario;
    }
}
