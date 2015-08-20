package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoApoderadoList")
public class TipoApoderadoList extends EntityQuery<TipoApoderado>
{

    private static final String EJBQL = "select tipoApoderado from TipoApoderado tipoApoderado";

    private static final String[] RESTRICTIONS = {
        "lower(tipoApoderado.nombre) like lower(concat(#{tipoApoderadoList.tipoApoderado.nombre},'%'))",
    };

    private TipoApoderado tipoApoderado = new TipoApoderado();

    public TipoApoderadoList()
    {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public TipoApoderado getTipoApoderado()
    {
        return tipoApoderado;
    }
}
