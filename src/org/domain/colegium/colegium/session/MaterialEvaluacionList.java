package org.domain.colegium.colegium.session;

import org.domain.colegium.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("materialEvaluacionList")
public class MaterialEvaluacionList extends EntityQuery<MaterialEvaluacion>
{

    private static final String EJBQL = "select materialEvaluacion from MaterialEvaluacion materialEvaluacion";

    private static final String[] RESTRICTIONS = {
    };

    private MaterialEvaluacion materialEvaluacion;

    public MaterialEvaluacionList()
    {
        materialEvaluacion = new MaterialEvaluacion();
        materialEvaluacion.setId( new MaterialEvaluacionId() );
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
    }

    public MaterialEvaluacion getMaterialEvaluacion()
    {
        return materialEvaluacion;
    }
}
